package tech.eagerminds.core.kafka.producer;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static tech.eagerminds.core.kafka.producer.test.helper.MessageHelper.compareMessages;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.test.context.EmbeddedKafka;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsKey;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsValue;
import tech.eagerminds.core.kafka.producer.configuration.EagerMindsConsumerConfiguration;
import tech.eagerminds.core.kafka.library.service.MessageProducer;
import tech.eagerminds.core.kafka.producer.test.service.ConsumerMessageParser;
import tech.eagerminds.core.kafka.producer.test.service.PlainConsumerMessageParser;

@SpringBootTest(classes = {EagermindsCoreStarterKafkaApplication.class})
@Import({EagerMindsConsumerConfiguration.class})
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
//@DirtiesContext
class EmbeddedKafkaTest {

  final static String GENERIC_BINDING_PRODUCER_NAME = "genericProducer-out-0";
  final static String GENERIC_TOPIC_NAME = "generic-test";
  final static String PLAIN_BINDING_PRODUCER_NAME = "plainProducer-out-0";
  final static String PLAIN_TOPIC_NAME = "plain-test";
  @Autowired
  StreamBridge streamBridge;
  @Autowired
  MessageProducer messageProducer;

  @SpyBean
  ConsumerMessageParser<EagerMindsKey, EagerMindsValue> consumerMessageParser;
  @SpyBean
  PlainConsumerMessageParser plainConsumerMessageParser;

  private static EagerMindsMessage<EagerMindsKey, EagerMindsValue> createMessage() {
    EagerMindsKey eagerMindsKey = new EagerMindsKey();
    eagerMindsKey.setId(UUID.randomUUID().toString());
    return new EagerMindsMessage<>(eagerMindsKey, EagerMindsValue.newBuilder().setEntity("my-entity").build());
  }

  @Test
  void givenEmbeddedKafkaBroker_andBindingProducerName_whenSendingWithSimpleProducer_thenMessageReceived() {
    EagerMindsMessage<EagerMindsKey, EagerMindsValue> publishEagerMindsMessage = createMessage();
    messageProducer.publishMessage(GENERIC_BINDING_PRODUCER_NAME, publishEagerMindsMessage);

    verify(consumerMessageParser, timeout(1000))
        .getMessageWithHeader(argThat(receivedMessage -> compareMessages(publishEagerMindsMessage, receivedMessage)),
            eq(EagerMindsKey.class));
  }

  @Test
  void givenEmbeddedKafkaBroker_andTopicName_whenSendingWithSimpleProducer_thenMessageReceived() {
    EagerMindsMessage<EagerMindsKey, EagerMindsValue> publishEagerMindsMessage = createMessage();
    messageProducer.publishMessage(GENERIC_TOPIC_NAME, publishEagerMindsMessage);

    verify(consumerMessageParser, timeout(1000))
        .getMessageWithHeader(argThat(receivedMessage -> compareMessages(publishEagerMindsMessage, receivedMessage)),
            eq(EagerMindsKey.class));
  }

  @Test
  void producePlainTextUsingBindingProducerName() {
    String plainMessage = "Sending with our own simple KafkaProducer";
    messageProducer.publishMessage(PLAIN_BINDING_PRODUCER_NAME, plainMessage);

    verify(plainConsumerMessageParser, timeout(1000))
        .getMessage(argThat(receivedMessage -> receivedMessage.getPayload().equals(plainMessage)));
  }

  @Test
  void producePlainTextUsingTopicName() {
    String plainMessage = "Sending with our own simple KafkaProducer";
    messageProducer.publishMessage(PLAIN_TOPIC_NAME, plainMessage);

    verify(plainConsumerMessageParser, timeout(1000))
        .getMessage(argThat(receivedMessage -> receivedMessage.getPayload().equals(plainMessage)));
  }
}