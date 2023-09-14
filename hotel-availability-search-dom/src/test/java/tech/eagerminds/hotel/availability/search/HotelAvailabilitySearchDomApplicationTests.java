package tech.eagerminds.hotel.availability.search;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.springframework.kafka.test.utils.KafkaTestUtils.producerProps;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelAvailabilitySearchDomApplicationTests {

  @Test
  void contextLoads() {
  }

}
