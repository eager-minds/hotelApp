package tech.eagerminds.core.mongodb.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import tech.eagerminds.core.mongodb.EagermindsCoreStarterMongoDbApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = {EagermindsCoreStarterMongoDbApplication.class})
public class CucumberSpringConfiguration {

}