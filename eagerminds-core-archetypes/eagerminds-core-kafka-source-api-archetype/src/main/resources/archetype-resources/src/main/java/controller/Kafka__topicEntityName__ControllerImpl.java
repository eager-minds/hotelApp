package ${package}.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.eagerminds.core.kafka.library.service.MessageProducer;
import ${package}.domain.avro.${topicEntityName}Key;
import ${package}.domain.avro.${topicEntityName}Value;
import ${package}.domain.dto.${topicEntityName}KeyDto;
import ${package}.domain.dto.${topicEntityName}ValueDto;
import ${package}.mapper.${topicEntityName}Mapper;

@RestController
@RequestMapping(path = "kafka-${topicEntityNameLowerCamelCase}")
public class Kafka${topicEntityName}ControllerImpl implements Kafka${topicEntityName}Controller {

  static final String TOPIC_BINDING_NAME = "${topicName}";
  private final ${topicEntityName}Mapper ${topicEntityNameLowerCamelCase}Mapper;
  private final MessageProducer messageProducer;

  @Autowired
  public Kafka${topicEntityName}ControllerImpl(${topicEntityName}Mapper ${topicEntityNameLowerCamelCase}Mapper, MessageProducer messageProducer) {
    this.${topicEntityNameLowerCamelCase}Mapper = ${topicEntityNameLowerCamelCase}Mapper;
    this.messageProducer = messageProducer;
  }

  @Override
  public ResponseEntity<${topicEntityName}KeyDto> sendMessage(${topicEntityName}ValueDto ${topicEntityNameLowerCamelCase}ValueDto) {
    ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key = ${topicEntityName}Key.newBuilder()
        .setId(UUID.randomUUID().toString())
        .build();
    ${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value = ${topicEntityNameLowerCamelCase}Mapper.toAvro(${topicEntityNameLowerCamelCase}ValueDto);
    messageProducer.publishMessage(TOPIC_BINDING_NAME, ${topicEntityNameLowerCamelCase}Key, ${topicEntityNameLowerCamelCase}Value);
    ${topicEntityName}KeyDto ${topicEntityNameLowerCamelCase}KeyDto = ${topicEntityNameLowerCamelCase}Mapper.toDto(${topicEntityNameLowerCamelCase}Key);
    return new ResponseEntity<>(${topicEntityNameLowerCamelCase}KeyDto, HttpStatus.CREATED);
  }
}
