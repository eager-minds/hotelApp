package ${package}.bdd.steps;

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
import ${package}.bdd.configuration.CucumberSpringConfiguration;
import ${package}.domain.avro.${topicEntityName}Key;
import ${package}.domain.avro.${topicEntityName}Value;

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

  @Given("${topicName} well formatted message key")
  public void ${topicEntityNameLowerCamelCase}WellFormattedMessageKey(
      ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key) {
    this.scenarioContext.set${topicEntityName}Key(${topicEntityNameLowerCamelCase}Key);
  }

  @Given("${topicName} well formatted message value")
  public void ${topicEntityNameLowerCamelCase}WellFormattedMessageValue(
      ${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value) {
    this.scenarioContext.set${topicEntityName}Value(${topicEntityNameLowerCamelCase}Value);
  }

  @When("message is sent to {string} topic")
  public void messageIsSentToTopic(String topicName) {
    EagerMindsMessage<${topicEntityName}Key, ${topicEntityName}Value> sentEagermindsMessage =
        new EagerMindsMessage<>(scenarioContext.${topicEntityNameLowerCamelCase}Key(),
            scenarioContext.${topicEntityNameLowerCamelCase}Value());
    messageProducer.publishMessage(topicName, sentEagermindsMessage);
  }

}