package tech.eagerminds.showcase.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import tech.eagerminds.showcase.EagermindsShowcaseMongodbApiApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = {EagermindsShowcaseMongodbApiApplication.class},
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {

}