package tech.eagerminds.hotel.availability.search.service;

import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.kafka.library.helper.MessageHelper;
import tech.eagerminds.core.kafka.library.service.MessageConsumer;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;

@Service
public class MessageConsumerImpl implements MessageConsumer {

  EagerMindsGenericReactiveMongodbService<AvailabilitySearchEntity, String> eagerMindsGenericReactiveMongodbService;

  @Autowired
  public MessageConsumerImpl(
      EagerMindsGenericReactiveMongodbService<AvailabilitySearchEntity, String> eagerMindsGenericReactiveMongodbService) {
    this.eagerMindsGenericReactiveMongodbService = eagerMindsGenericReactiveMongodbService;
  }

  @Override
  public <V extends GenericRecord> void messageProcessor(Message<V> message) {
    LOG.info("received message: {}", message);
    AvailabilitySearchKey availabilitySearchKey = MessageHelper.getMessageKey(message.getHeaders(),
        AvailabilitySearchKey.class);
    if (message.getPayload() instanceof AvailabilitySearchValue availabilitySearchValue) {
      AvailabilitySearch availabilitySearch = availabilitySearchValue.getEntity();
      AvailabilitySearchEntity availabilitySearchEntity = new AvailabilitySearchEntity(
          availabilitySearchKey.getId(),
          availabilitySearch.getHotelId(),
          availabilitySearch.getCheckIn(),
          availabilitySearch.getCheckOut(),
          availabilitySearch.getAges());
      eagerMindsGenericReactiveMongodbService.save(availabilitySearchEntity).block();
    }
  }
}
