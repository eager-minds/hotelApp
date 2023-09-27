package tech.eagerminds.core.kafka.producer;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.eagerminds.core.kafka.library.helper.MessageHelper.parse;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsKey;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsValue;
import tech.eagerminds.core.kafka.library.service.MessageProducer;

@SpringBootTest
@Import({TestChannelBinderConfiguration.class})
class EagerMindsValuePublisherTest {

  final static String GENERIC_BINDING_PRODUCER_NAME = "genericTestProducer-out-0";
  final static String GENERIC_TOPIC_NAME = "generic-test";

  @Autowired
  MessageProducer messageProducer;

  private static EagerMindsMessage<EagerMindsKey, EagerMindsValue> createMessage() {
    EagerMindsKey eagerMindsKey = new EagerMindsKey();
    eagerMindsKey.setId(UUID.randomUUID().toString());
    return new EagerMindsMessage<>(eagerMindsKey,
        EagerMindsValue.newBuilder().setEntity("my-entity").build());
  }

  @Test
  void produceMessageUsingBindingProducerName(@Autowired OutputDestination output) {
    EagerMindsMessage<EagerMindsKey, EagerMindsValue> eagerMindsMessage = createMessage();
    messageProducer.publishMessage(GENERIC_BINDING_PRODUCER_NAME, eagerMindsMessage);

    Message<byte[]> message = output.receive(100, GENERIC_TOPIC_NAME);
    EagerMindsValue EagerMindsValue = parse(message, eagerMindsMessage.value().getClass());

    assertThat(EagerMindsValue).isEqualTo(eagerMindsMessage.value());
    assertThat(message.getHeaders()).containsEntry(KafkaHeaders.KEY, eagerMindsMessage.key());
  }

  @Test
  void produceMessageUsingTopicName(@Autowired MessageProducer messageProducer,
      @Autowired OutputDestination output) {
    EagerMindsMessage<EagerMindsKey, EagerMindsValue> eagerMindsMessage = createMessage();
    messageProducer.publishMessage(GENERIC_TOPIC_NAME, eagerMindsMessage);

    Message<byte[]> message = output.receive(100, GENERIC_TOPIC_NAME);
    EagerMindsValue EagerMindsValue = parse(message, eagerMindsMessage.value().getClass());

    assertThat(EagerMindsValue).isEqualTo(eagerMindsMessage.value());
    assertThat(message.getHeaders()).containsEntry(KafkaHeaders.KEY, eagerMindsMessage.key());
  }
}