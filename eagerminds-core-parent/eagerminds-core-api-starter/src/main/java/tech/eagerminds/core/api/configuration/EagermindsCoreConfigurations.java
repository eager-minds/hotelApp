package tech.eagerminds.core.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EagermindsCoreControllerConfigurations.class)
public class EagermindsCoreConfigurations {

}
