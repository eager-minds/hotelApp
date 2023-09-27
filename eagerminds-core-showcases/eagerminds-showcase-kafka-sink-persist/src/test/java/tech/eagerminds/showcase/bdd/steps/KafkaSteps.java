package tech.eagerminds.showcase.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;
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

  @Given("^kafka service is running$")
  public void kafka_service_is_running() {
    assertThat(messageProducer).isNotNull();
  }

  @Given("^kafka has a topic \"([^\"]*)\"$")
  public void kafka_has_a_topic(String topicName) {
    this.topic = topicName;
  }

  @Given("eagerminds-showcase well formatted message key")
  public void eagerMindsShowcaseWellFormattedMessageKey(
      EagerMindsShowcaseKey eagerMindsShowcaseKey) {
    this.scenarioContext.setEagerMindsShowcaseKey(eagerMindsShowcaseKey);
  }

  @Given("eagerminds-showcase well formatted message value")
  public void eagerMindsShowcaseWellFormattedMessageValue(
      EagerMindsShowcaseValue eagerMindsShowcaseValue) {
    this.scenarioContext.setEagerMindsShowcaseValue(eagerMindsShowcaseValue);
  }

  @When("message is sent to {string} topic")
  public void messageIsSentToTopic(String topicName) {
    EagerMindsMessage<EagerMindsShowcaseKey, EagerMindsShowcaseValue> sentEagermindsMessage =
        new EagerMindsMessage<>(scenarioContext.eagerMindsShowcaseKey(),
            scenarioContext.eagerMindsShowcaseValue());
    messageProducer.publishMessage(topicName, sentEagermindsMessage);
  }

}