package tech.eagerminds.core.kafka.consumer.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.eagerminds.core.kafka.library.helper.MessageHelper.getMessageKey;
import static tech.eagerminds.core.kafka.library.helper.MessageHelper.parse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.consumer.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.core.kafka.consumer.service.MessageConsumerImpl;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsKey;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsValue;
import tech.eagerminds.core.kafka.library.service.MessageProducer;

public class KafkaSteps extends CucumberSpringConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaSteps.class);

  @Autowired
  MessageProducer messageProducer;
  String topic;

  Message<byte[]> receivedMessage;

  EagerMindsMessage<EagerMindsKey, EagerMindsValue> sentEagermindsMessage;

  @Given("^(?:[a-z]+ )?kafka service is running$")
  public void kafka_service_is_running() {
    assertThat(messageProducer).isNotNull();
  }

  @Given("I have a kafka consumer service")
  public void kafka_consumer_service() {
    assertThat(MessageConsumerImpl.RECEIVED_MESSAGES).isNotNull();
  }

  @Given("^kafka has a topic \"([^\"]*)\"$")
  public void kafka_has_a_topic(String topicName) {
    this.topic = topicName;
  }

  @When("I send a kafka message")
  public void send_a_kafka_message(EagerMindsValue eagerMindsValue) {
    EagerMindsKey eagerMindsKey = EagerMindsKey.newBuilder().setId(UUID.randomUUID().toString())
        .build();
    this.sentEagermindsMessage = new EagerMindsMessage<>(eagerMindsKey, eagerMindsValue);
    messageProducer.publishMessage(this.topic, sentEagermindsMessage);
  }

  @And("I get a kafka message from topic")
  public void kafka_message_from_topic() {
    assertThat(MessageConsumerImpl.RECEIVED_MESSAGES).hasSize(1);
    Message a = MessageConsumerImpl.RECEIVED_MESSAGES.get(0);
    receivedMessage = MessageConsumerImpl.RECEIVED_MESSAGES.get(0);
    LOG.info("received message: {}", receivedMessage);
  }

  @Then("received kafka message is equals to sent message")
  public void received_kafka_message_is_equals_to_sent_message() {
    assertThat(receivedMessage).isNotNull();
    assertThat(receivedMessage.getHeaders().get(KafkaHeaders.KEY))
        .isNotNull()
        .isInstanceOf(EagerMindsKey.class);
    EagerMindsKey eagerMindsKey = getMessageKey(receivedMessage.getHeaders(), EagerMindsKey.class);
    assertThat(eagerMindsKey).isNotNull().isEqualTo(sentEagermindsMessage.key());

    EagerMindsValue receivedEagerMindsValue = parse(receivedMessage, EagerMindsValue.class);
    assertThat(receivedEagerMindsValue).isNotNull().isEqualTo(sentEagermindsMessage.value());
  }
}