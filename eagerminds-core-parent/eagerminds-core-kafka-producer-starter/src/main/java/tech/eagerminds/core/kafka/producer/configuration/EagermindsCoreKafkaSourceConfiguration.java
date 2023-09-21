package tech.eagerminds.core.kafka.producer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.eagerminds.core.kafka.producer.service.MessageProducerImpl;

@Configuration
@Import(MessageProducerImpl.class)
public class EagermindsCoreKafkaSourceConfiguration {

}
