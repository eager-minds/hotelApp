package tech.eagerminds.core.kafka.producer.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsPlainMessage;

public interface PlainConsumerMessageParser {

  Logger LOG = LoggerFactory.getLogger(PlainConsumerMessageParser.class);

  default <K> void getMessageWithHeader(Message<String> message, Class<K> keyClass) {
    K recordKey = message.getHeaders().get(KafkaHeaders.KEY, keyClass);
    String eagerMindsValue = message.getPayload();
    EagerMindsPlainMessage<K> eagerMindsPlainMessage = new EagerMindsPlainMessage<>(recordKey, eagerMindsValue);
    LOG.info("Received payload: {}", eagerMindsPlainMessage);
  }

  default void getMessage(Message<String> message) {
    String eagerMindsValue = message.getPayload();
    LOG.info("Received payload: {}", eagerMindsValue);
  }

}