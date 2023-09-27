package ${package}.service;

import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.kafka.library.helper.MessageHelper;
import tech.eagerminds.core.kafka.library.service.MessageConsumer;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;
import ${package}.domain.avro.${topicEntityName};
import ${package}.domain.avro.${topicEntityName}Key;
import ${package}.domain.avro.${topicEntityName}Value;
import ${package}.domain.entity.${topicEntityName}Entity;

@Service
public class MessageConsumerImpl implements MessageConsumer {

  EagerMindsGenericReactiveMongodbService<${topicEntityName}Entity, String> eagerMindsGenericReactiveMongodbService;

  @Autowired
  public MessageConsumerImpl(
      EagerMindsGenericReactiveMongodbService<${topicEntityName}Entity, String> eagerMindsGenericReactiveMongodbService) {
    this.eagerMindsGenericReactiveMongodbService = eagerMindsGenericReactiveMongodbService;
  }

  @Override
  public <V extends GenericRecord> void messageProcessor(Message<V> message) {
    LOG.info("received message: {}", message);
    ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key = MessageHelper.getMessageKey(message.getHeaders(),
        ${topicEntityName}Key.class);
    if (message.getPayload() instanceof ${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value) {
      ${topicEntityName} ${topicEntityNameLowerCamelCase} = ${topicEntityNameLowerCamelCase}Value.getEntity();
      ${topicEntityName}Entity ${topicEntityNameLowerCamelCase}Entity = new ${topicEntityName}Entity(
          ${topicEntityNameLowerCamelCase}Key.getId(),
          ${topicEntityNameLowerCamelCase}.getMyString(),
          ${topicEntityNameLowerCamelCase}.getMyInt(),
          ${topicEntityNameLowerCamelCase}.getMyIntArray());
      eagerMindsGenericReactiveMongodbService.save(${topicEntityNameLowerCamelCase}Entity).block();
    }
  }
}
