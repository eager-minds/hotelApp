package tech.eagerminds.core.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.eagerminds.core.api.domain.dto.BuildInfo;

@Configuration
@ComponentScan(basePackages = "tech.eagerminds.core.api")
public class EagermindsCoreControllerConfigurations {

  @Bean
  @ConditionalOnMissingBean
  public BuildInfo buildInfo(@Value("${spring.application.name}") String applicationName,
      @Value("${info.build.version}") String buildVersion,
      @Value("${info.build.timestamp}") String buildTimestamp) {
    return new BuildInfo(applicationName, buildVersion, buildTimestamp);
  }
}
