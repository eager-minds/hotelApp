package tech.eagerminds.core.kafka.library.service;

import java.util.Objects;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;

public interface MessageProducer {

  Logger LOG = LoggerFactory.getLogger(MessageProducer.class);

  void sendMessage(String bindingName, Object message);

  default void publishMessage(String bindingName, String messageString) {
    sendMessage(bindingName, messageString);
    LOG.info("Event sent: {}", messageString);
  }

  default <K extends GenericRecord, V extends GenericRecord> void publishMessage(String bindingName,
      EagerMindsMessage<K, V> eagerMindsMessage) {
    K messageKey = Objects.requireNonNull(eagerMindsMessage).key();
    V messageValue = eagerMindsMessage.value();
    publishMessage(bindingName, messageKey, messageValue);
  }

  default <K extends GenericRecord, V extends GenericRecord> void publishMessage(String bindingName,
      K eagerMindsKey,
      V eagerMindsValue) {
    Message<V> o = MessageBuilder
        .withPayload(eagerMindsValue)
        .setHeader(KafkaHeaders.KEY, eagerMindsKey)
        .build();

    sendMessage(bindingName, o);
    LOG.info("Event sent: {}, {}", eagerMindsKey, o.getPayload());
  }
}
