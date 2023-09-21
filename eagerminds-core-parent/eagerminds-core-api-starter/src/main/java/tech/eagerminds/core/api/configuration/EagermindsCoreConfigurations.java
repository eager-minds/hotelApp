package tech.eagerminds.core.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tech.eagerminds.core.api.controller.InfoControllerImpl;
import tech.eagerminds.core.api.controller.PingControllerImpl;
import tech.eagerminds.core.api.domain.dto.BuildInfo;

@Configuration
@Import(EagermindsCoreControllerConfigurations.class)
public class EagermindsCoreConfigurations {

}
