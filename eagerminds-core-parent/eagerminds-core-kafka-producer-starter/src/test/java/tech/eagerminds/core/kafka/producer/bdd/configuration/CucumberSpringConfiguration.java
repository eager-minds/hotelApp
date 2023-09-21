package tech.eagerminds.core.kafka.producer.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;

@CucumberContextConfiguration
@SpringBootTest
@Import({TestChannelBinderConfiguration.class})
public class CucumberSpringConfiguration {

}