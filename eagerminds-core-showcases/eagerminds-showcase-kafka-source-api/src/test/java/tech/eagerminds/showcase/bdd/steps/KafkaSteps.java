package tech.eagerminds.showcase.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.eagerminds.core.kafka.library.helper.MessageHelper.getMessageKey;
import static tech.eagerminds.core.kafka.library.helper.MessageHelper.parse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.library.service.MessageProducer;
import tech.eagerminds.showcase.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseKey;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseValue;

public class KafkaSteps extends CucumberSpringConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaSteps.class);
  @Autowired
  MessageProducer messageProducer;
  String topic;
  @Autowired
  OutputDestination output;

  @Autowired
  ScenarioContext scenarioContext;

  Message<byte[]> receivedMessage;

  @Given("^(?:[a-z]+ )?kafka service is running$")
  public void kafka_service_is_running() {
    assertThat(messageProducer).isNotNull();
  }

  @Given("I have a kafka consumer service")
  public void kafka_consumer_service() {
    assertThat(output).isNotNull();
  }

  @Given("^kafka has a topic \"([^\"]*)\"$")
  public void kafka_has_a_topic(String topicName) {
    this.topic = topicName;
  }

  @And("I get a kafka message from topic")
  public void kafka_message_from_topic() {
    receivedMessage = output.receive(100, this.topic);
    LOG.info("received message: {}", receivedMessage);
  }

  @Then("received kafka message is equals to sent message")
  public void received_kafka_message_is_equals_to_sent_message() {
    assertThat(receivedMessage).isNotNull();
    assertThat(receivedMessage.getHeaders().get(KafkaHeaders.KEY))
        .isNotNull()
        .isInstanceOf(EagerMindsShowcaseKey.class);
    EagerMindsShowcaseKey eagerMindsShowcaseKey = getMessageKey(receivedMessage.getHeaders(),
        EagerMindsShowcaseKey.class);
    assertThat(eagerMindsShowcaseKey)
        .isNotNull()
        .isEqualToComparingOnlyGivenFields(scenarioContext.savedEagerMindsShowcaseKeyDto(), "id");
    assertThat(eagerMindsShowcaseKey.getId())
        .isNotNull()
        .isEqualTo(scenarioContext.savedEagerMindsShowcaseKeyDto().id());

    EagerMindsShowcaseValue receivedEagerMindsShowcaseValue = parse(receivedMessage,
        EagerMindsShowcaseValue.class);
    assertThat(receivedEagerMindsShowcaseValue).isNotNull();
    assertThat(receivedEagerMindsShowcaseValue.getEntity().getMyString())
        .isEqualTo(scenarioContext.savedEagerMindsShowcaseValueDto().myString());
    assertThat(receivedEagerMindsShowcaseValue.getEntity().getMyInt())
        .isEqualTo(scenarioContext.savedEagerMindsShowcaseValueDto().myInt());
    assertThat(receivedEagerMindsShowcaseValue.getEntity().getMyIntArray())
        .isEqualTo(scenarioContext.savedEagerMindsShowcaseValueDto().myIntArray());
  }

}