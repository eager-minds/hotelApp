package tech.eagerminds.hotel.availability.search.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;
import tech.eagerminds.core.kafka.library.service.MessageProducer;
import tech.eagerminds.hotel.availability.search.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;

public class KafkaSteps extends CucumberSpringConfiguration {

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

  @Given("hotel_availability_searches well formatted message key")
  public void availabilitySearchWellFormattedMessageKey(
      AvailabilitySearchKey availabilitySearchKey) {
    this.scenarioContext.setAvailabilitySearchKey(availabilitySearchKey);
  }

  @Given("hotel_availability_searches well formatted message value")
  public void availabilitySearchWellFormattedMessageValue(
      AvailabilitySearchValue availabilitySearchValue) {
    this.scenarioContext.setAvailabilitySearchValue(availabilitySearchValue);
  }

  @When("message is sent to {string} topic")
  public void messageIsSentToTopic(String topicName) {
    EagerMindsMessage<AvailabilitySearchKey, AvailabilitySearchValue> sentEagermindsMessage =
        new EagerMindsMessage<>(scenarioContext.availabilitySearchKey(),
            scenarioContext.availabilitySearchValue());
    messageProducer.publishMessage(topicName, sentEagermindsMessage);
  }

}