package tech.eagerminds.core.kafka.producer;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.library.service.MessageProducer;

@SpringBootTest
@Import({TestChannelBinderConfiguration.class})
class PlainTextPublisherTest {

  static final String PLAIN_BINDING_PRODUCER_NAME = "plainTestProducer-out-0";
  static final String PLAIN_TOPIC_NAME = "plain-test";
  @Autowired
  MessageProducer messageProducer;

  @Test
  void givenTextPlainMessage_andBindingProducerName_whenPublishMessage_thenMessageIsSerialized(
      @Autowired MessageProducer messageProducer, @Autowired OutputDestination output) {
    messageProducer.publishMessage(PLAIN_BINDING_PRODUCER_NAME, "Hello");

    Message<byte[]> result = output.receive(100, PLAIN_TOPIC_NAME);

    assertThat(result).isNotNull();
    assertThat(new String(result.getPayload())).isEqualTo("Hello");
  }

  @Test
  void givenTextPlainMessage_andBindingProducerName_whenPublishMessage_thenMessageIsSerialized_V2(
      @Autowired OutputDestination output) {
    messageProducer.publishMessage(PLAIN_BINDING_PRODUCER_NAME, "Hello");

    Message<byte[]> result = output.receive(100, PLAIN_TOPIC_NAME);

    assertThat(result).isNotNull();
    try (StringDeserializer stringDeserializer = new StringDeserializer()) {
      String message = stringDeserializer.deserialize(PLAIN_TOPIC_NAME, result.getPayload());
      assertThat(message).isEqualTo("Hello");
    }
  }

  @Test
  void givenTextPlainMessage_andTopicName_whenPublishMessage_thenMessageIsPlain(
      @Autowired MessageProducer messageProducer, @Autowired OutputDestination output) {
    messageProducer.publishMessage(PLAIN_TOPIC_NAME, "Hello");

    Message<byte[]> outputMessage = output.receive(100, PLAIN_TOPIC_NAME);

    assertThat(outputMessage).isNotNull();

    Object payload = outputMessage.getPayload();

    assertThat(payload).isEqualTo("Hello");
  }
}