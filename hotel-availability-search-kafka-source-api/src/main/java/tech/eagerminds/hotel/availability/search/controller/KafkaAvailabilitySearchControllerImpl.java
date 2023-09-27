package tech.eagerminds.hotel.availability.search.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.eagerminds.core.kafka.library.service.MessageProducer;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchKeyDto;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchValueDto;
import tech.eagerminds.hotel.availability.search.mapper.AvailabilitySearchMapper;

@RestController
@RequestMapping(path = "kafka-availabilitySearch")
public class KafkaAvailabilitySearchControllerImpl implements KafkaAvailabilitySearchController {

  static final String TOPIC_BINDING_NAME = "hotel_availability_searches";
  private final AvailabilitySearchMapper availabilitySearchMapper;
  private final MessageProducer messageProducer;

  @Autowired
  public KafkaAvailabilitySearchControllerImpl(AvailabilitySearchMapper availabilitySearchMapper, MessageProducer messageProducer) {
    this.availabilitySearchMapper = availabilitySearchMapper;
    this.messageProducer = messageProducer;
  }

  @Override
  public ResponseEntity<AvailabilitySearchKeyDto> search(AvailabilitySearchValueDto availabilitySearchValueDto) {
    AvailabilitySearchKey availabilitySearchKey = AvailabilitySearchKey.newBuilder()
        .setId(UUID.randomUUID().toString())
        .build();
    AvailabilitySearchValue availabilitySearchValue = availabilitySearchMapper.toAvro(availabilitySearchValueDto);
    messageProducer.publishMessage(TOPIC_BINDING_NAME, availabilitySearchKey, availabilitySearchValue);
    AvailabilitySearchKeyDto availabilitySearchKeyDto = availabilitySearchMapper.toDto(availabilitySearchKey);
    return new ResponseEntity<>(availabilitySearchKeyDto, HttpStatus.CREATED);
  }
}
