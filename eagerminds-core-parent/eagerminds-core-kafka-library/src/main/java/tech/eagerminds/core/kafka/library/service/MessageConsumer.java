package tech.eagerminds.core.kafka.library.service;

import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;

public interface MessageConsumer {

  Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

  default <V extends GenericRecord> void messageProcessor(Message<V> message) {
    GenericRecord recordKey = message.getHeaders()
        .get(KafkaHeaders.RECEIVED_KEY, GenericRecord.class);
    EagerMindsMessage<GenericRecord, V> eagerMindsMessage = new EagerMindsMessage<>(recordKey,
        message.getPayload());
    log(eagerMindsMessage);
  }

  private <V extends GenericRecord> void log(
      EagerMindsMessage<GenericRecord, V> eagerMindsMessage) {
    LOG.info("Received payload: {}", eagerMindsMessage);
  }

  default void plainMessageProcessor(Message<String> message) {
    LOG.info("Received string message: {}", message);
  }
}