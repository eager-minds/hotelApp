package tech.eagerminds.showcase.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.eagerminds.core.kafka.library.service.MessageProducer;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseKey;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseValue;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseKeyDto;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;
import tech.eagerminds.showcase.mapper.EagerMindsShowcaseMapper;

@RestController
@RequestMapping(path = "kafka-eagerMindsShowcase")
public class KafkaEagerMindsShowcaseControllerImpl implements KafkaEagerMindsShowcaseController {

  static final String TOPIC_BINDING_NAME = "eagerminds-showcase";
  private final EagerMindsShowcaseMapper eagerMindsShowcaseMapper;
  private final MessageProducer messageProducer;

  @Autowired
  public KafkaEagerMindsShowcaseControllerImpl(EagerMindsShowcaseMapper eagerMindsShowcaseMapper,
      MessageProducer messageProducer) {
    this.eagerMindsShowcaseMapper = eagerMindsShowcaseMapper;
    this.messageProducer = messageProducer;
  }

  @Override
  public ResponseEntity<EagerMindsShowcaseKeyDto> sendMessage(
      EagerMindsShowcaseValueDto eagerMindsShowcaseValueDto) {
    EagerMindsShowcaseKey eagerMindsShowcaseKey = EagerMindsShowcaseKey.newBuilder()
        .setId(UUID.randomUUID().toString())
        .build();
    EagerMindsShowcaseValue eagerMindsShowcaseValue = eagerMindsShowcaseMapper.toAvro(
        eagerMindsShowcaseValueDto);
    messageProducer.publishMessage(TOPIC_BINDING_NAME, eagerMindsShowcaseKey,
        eagerMindsShowcaseValue);
    EagerMindsShowcaseKeyDto eagerMindsShowcaseKeyDto = eagerMindsShowcaseMapper.toDto(
        eagerMindsShowcaseKey);
    return new ResponseEntity<>(eagerMindsShowcaseKeyDto, HttpStatus.CREATED);
  }
}
