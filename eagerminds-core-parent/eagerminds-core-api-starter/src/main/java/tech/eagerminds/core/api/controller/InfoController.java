package tech.eagerminds.core.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import tech.eagerminds.core.api.domain.dto.BuildInfo;

public interface InfoController {

  @GetMapping(produces = "application/json")
  BuildInfo getInfo();
}
