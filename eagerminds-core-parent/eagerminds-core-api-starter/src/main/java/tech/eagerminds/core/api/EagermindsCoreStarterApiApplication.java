package tech.eagerminds.core.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.eagerminds.core.api.configuration.EagermindsCoreConfigurations;
import tech.eagerminds.core.api.controller.InfoControllerImpl;
import tech.eagerminds.core.api.controller.PingControllerImpl;
import tech.eagerminds.core.api.domain.dto.BuildInfo;

@SpringBootApplication
//@Configuration
//@Import({EagermindsCoreConfigurations.class, InfoControllerImpl.class, PingControllerImpl.class})
//@ConditionalOnClass({InfoControllerImpl.class, PingControllerImpl.class})
public class EagermindsCoreStarterApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(EagermindsCoreStarterApiApplication.class, args);
  }

}