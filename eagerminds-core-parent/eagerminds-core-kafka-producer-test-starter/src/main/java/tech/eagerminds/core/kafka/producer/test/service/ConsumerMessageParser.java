package tech.eagerminds.core.kafka.producer.test.service;

import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;

public interface ConsumerMessageParser<K extends GenericRecord, V extends GenericRecord> {

  Logger LOG = LoggerFactory.getLogger(ConsumerMessageParser.class);

  default void getMessageWithHeader(Message<V> message, Class<K> keyClass) {
    K recordKey = message.getHeaders().get(KafkaHeaders.KEY, keyClass);
    V eagerMindsValue = message.getPayload();
    EagerMindsMessage<K, V> eagerMindsMessage = new EagerMindsMessage<>(recordKey, eagerMindsValue);
    LOG.info("Received payload: {}", eagerMindsMessage);
  }

  default void getMessage(Message<V> message) {
    V eagerMindsValue = message.getPayload();
    LOG.info("Received payload: {}", eagerMindsValue);
  }
}