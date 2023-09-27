package tech.eagerminds.core.kafka.consumer.configuration;

import java.util.function.Consumer;
import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import tech.eagerminds.core.kafka.library.service.MessageConsumer;

@Configuration
public class EagermindsCoreKafkaSinkConfiguration {

  @Bean
  public <V extends GenericRecord> Consumer<Message<V>> genericConsumer(
      @Autowired MessageConsumer messageConsumer) {
    return messageConsumer::messageProcessor;
  }

  @Bean
  public Consumer<Message<String>> plainConsumer(
      @Autowired MessageConsumer messageConsumer) {
    return messageConsumer::plainMessageProcessor;
  }

}