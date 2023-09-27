package tech.eagerminds.showcase.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import tech.eagerminds.showcase.EagermindsShowcaseKafkaSourceApiApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = {EagermindsShowcaseKafkaSourceApiApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@Import({TestChannelBinderConfiguration.class})
public class CucumberSpringConfiguration {

}