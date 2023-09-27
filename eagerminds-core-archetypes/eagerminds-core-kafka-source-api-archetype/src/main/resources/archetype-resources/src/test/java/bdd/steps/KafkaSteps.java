package ${package}.bdd.steps;

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
  public void i_get_a_kafka_message_from_topic() {
    receivedMessage = output.receive(100, this.topic);
    LOG.info("received message: {}", receivedMessage);
  }

  @Then("received kafka message is equals to sent message")
  public void received_kafka_message_is_equals_to_sent_message() {
    assertThat(receivedMessage).isNotNull();
    assertThat(receivedMessage.getHeaders().get(KafkaHeaders.KEY))
        .isNotNull().isInstanceOf(${topicEntityName}Key.class);
    ${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key = getMessageKey(receivedMessage.getHeaders(), ${topicEntityName}Key.class);
    assertThat(${topicEntityNameLowerCamelCase}Key)
        .isNotNull()
        .isEqualToComparingOnlyGivenFields(scenarioContext.saved${topicEntityName}KeyDto(), "id");
    assertThat(${topicEntityNameLowerCamelCase}Key.getId())
        .isNotNull()
        .isEqualTo(scenarioContext.saved${topicEntityName}KeyDto().id());

    ${topicEntityName}Value received${topicEntityName}Value = parse(receivedMessage, ${topicEntityName}Value.class);
    assertThat(received${topicEntityName}Value).isNotNull();
//    assertThat(received${topicEntityName}Value.getEntity().getMyString())
//        .isEqualTo(scenarioContext.saved${topicEntityName}ValueDto().myString());
//    assertThat(received${topicEntityName}Value.getEntity().getMyInt())
//        .isEqualTo(scenarioContext.saved${topicEntityName}ValueDto().myInt());
//    assertThat(received${topicEntityName}Value.getEntity().getMyIntArray())
//        .isEqualTo(scenarioContext.saved${topicEntityName}ValueDto().myIntArray());
  }

}