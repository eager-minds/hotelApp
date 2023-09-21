package tech.eagerminds.core.kafka.producer.service;

import java.util.Objects;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;
import tech.eagerminds.core.kafka.library.service.MessageProducer;

@Service
public class MessageProducerImpl implements MessageProducer {

  private static final Logger LOG = LoggerFactory.getLogger(MessageProducerImpl.class);

  private final StreamBridge streamBridge;

  @Autowired
  public MessageProducerImpl(StreamBridge streamBridge) {
    this.streamBridge = streamBridge;
  }

  @Override
  public void publishMessage(String bindingName, String messageString) {
    streamBridge.send(bindingName, messageString);
    LOG.info("Event sent: {}", messageString);
  }

  @Override
  public <K extends GenericRecord, V extends GenericRecord> void publishMessage(String bindingName,
      EagerMindsMessage<K, V> eagerMindsMessage) {
    K messageKey = Objects.requireNonNull(eagerMindsMessage).key();
    V messageValue = eagerMindsMessage.value();
    publishMessage(bindingName, messageKey, messageValue);
  }

  @Override
  public <K extends GenericRecord, V extends GenericRecord> void publishMessage(String bindingName, K eagerMindsKey,
      V eagerMindsValue) {
    Message<V> o = MessageBuilder
        .withPayload(eagerMindsValue)
        .setHeader(KafkaHeaders.KEY, eagerMindsKey)
        .build();

    streamBridge.send(bindingName, o);
    LOG.info("Event sent: {}, {}", eagerMindsKey, o.getPayload());
  }

}