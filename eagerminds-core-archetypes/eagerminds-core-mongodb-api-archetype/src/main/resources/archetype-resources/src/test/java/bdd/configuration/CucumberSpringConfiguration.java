package ${package}.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import ${package}.${artifactIdCamelCase}Application;

@CucumberContextConfiguration
@SpringBootTest(classes = {${artifactIdCamelCase}Application.class},
    webEnvironment = WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {

}