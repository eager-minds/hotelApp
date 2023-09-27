package ${package}.bdd.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import ${package}.${artifactIdCamelCase}Application;

@CucumberContextConfiguration
@SpringBootTest(classes = {${artifactIdCamelCase}Application.class})
@Import({TestChannelBinderConfiguration.class})
public class CucumberSpringConfiguration {

}