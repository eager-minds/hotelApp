package tech.eagerminds.showcase.service;

import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.kafka.library.helper.MessageHelper;
import tech.eagerminds.core.kafka.library.service.MessageConsumer;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcase;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseKey;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseValue;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

@Service
public class MessageConsumerImpl implements MessageConsumer {

  EagerMindsGenericReactiveMongodbService<EagerMindsShowcaseEntity, String> eagerMindsGenericReactiveMongodbService;

  @Autowired
  public MessageConsumerImpl(
      EagerMindsGenericReactiveMongodbService<EagerMindsShowcaseEntity, String>
          eagerMindsGenericReactiveMongodbService) {
    this.eagerMindsGenericReactiveMongodbService = eagerMindsGenericReactiveMongodbService;
  }

  @Override
  public <V extends GenericRecord> void messageProcessor(Message<V> message) {
    LOG.info("received message: {}", message);
    EagerMindsShowcaseKey eagerMindsShowcaseKey = MessageHelper.getMessageKey(message.getHeaders(),
        EagerMindsShowcaseKey.class);
    if (message.getPayload() instanceof EagerMindsShowcaseValue eagerMindsShowcaseValue) {
      EagerMindsShowcase eagerMindsShowcase = eagerMindsShowcaseValue.getEntity();
      EagerMindsShowcaseEntity eagerMindsShowcaseEntity = new EagerMindsShowcaseEntity(
          eagerMindsShowcaseKey.getId(),
          eagerMindsShowcase.getMyString(),
          eagerMindsShowcase.getMyInt(),
          eagerMindsShowcase.getMyIntArray());
      eagerMindsGenericReactiveMongodbService.save(eagerMindsShowcaseEntity).block();
    }
  }
}
