package tech.eagerminds.showcase.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import tech.eagerminds.showcase.EagermindsShowcaseKafkaSinkPersistApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = {EagermindsShowcaseKafkaSinkPersistApplication.class})
@Import({TestChannelBinderConfiguration.class})
public class CucumberSpringConfiguration {

}