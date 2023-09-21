package tech.eagerminds.core.kafka.producer.configuration;

import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsKey;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsValue;
import tech.eagerminds.core.kafka.producer.test.service.ConsumerMessageParser;
import tech.eagerminds.core.kafka.producer.test.service.PlainConsumerMessageParser;

@TestConfiguration
public class EagerMindsConsumerConfiguration {

  @Bean
  public Consumer<Message<EagerMindsValue>> genericConsumer(
      @Autowired ConsumerMessageParser<EagerMindsKey, EagerMindsValue> consumerMessageParser) {
    return (message) -> consumerMessageParser.getMessageWithHeader(message, EagerMindsKey.class);
  }

  @Bean
  public Consumer<Message<String>> plainConsumer(@Autowired PlainConsumerMessageParser plainConsumerMessageParser) {
    return plainConsumerMessageParser::getMessage;
  }

  @Bean
  public ConsumerMessageParser<EagerMindsKey, EagerMindsValue> genericConsumerMessageParser() {
    return new ConsumerMessageParser<>() {
    };
  }

  @Bean
  public PlainConsumerMessageParser plainConsumerMessageParser() {
    return new PlainConsumerMessageParser() {
    };
  }

}