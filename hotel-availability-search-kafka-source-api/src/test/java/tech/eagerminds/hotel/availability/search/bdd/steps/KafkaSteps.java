package tech.eagerminds.hotel.availability.search.bdd.steps;

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
import tech.eagerminds.hotel.availability.search.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;

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
        .isNotNull().isInstanceOf(AvailabilitySearchKey.class);
    AvailabilitySearchKey availabilitySearchKey = getMessageKey(receivedMessage.getHeaders(), AvailabilitySearchKey.class);
    assertThat(availabilitySearchKey)
        .isNotNull();
    assertThat(availabilitySearchKey.getId())
        .isNotNull()
        .isEqualTo(scenarioContext.savedAvailabilitySearchKeyDto().searchId());

    AvailabilitySearchValue receivedAvailabilitySearchValue = parse(receivedMessage, AvailabilitySearchValue.class);
    assertThat(receivedAvailabilitySearchValue).isNotNull();
    assertThat(receivedAvailabilitySearchValue.getEntity().getHotelId())
        .isEqualTo(scenarioContext.savedAvailabilitySearchValueDto().hotelId());
    assertThat(receivedAvailabilitySearchValue.getEntity().getCheckIn())
        .isEqualTo(scenarioContext.savedAvailabilitySearchValueDto().checkIn());
    assertThat(receivedAvailabilitySearchValue.getEntity().getCheckOut())
        .isEqualTo(scenarioContext.savedAvailabilitySearchValueDto().checkOut());
    assertThat(receivedAvailabilitySearchValue.getEntity().getAges())
        .isEqualTo(scenarioContext.savedAvailabilitySearchValueDto().ages());
  }

}