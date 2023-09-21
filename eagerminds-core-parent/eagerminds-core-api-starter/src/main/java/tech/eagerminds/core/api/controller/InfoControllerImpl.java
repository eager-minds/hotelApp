package tech.eagerminds.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.eagerminds.core.api.domain.dto.BuildInfo;

@RestController
@RequestMapping(path = "build-info")
public class InfoControllerImpl implements InfoController {

  BuildInfo buildInfo;

  @Autowired
  public InfoControllerImpl(BuildInfo buildInfo) {
    this.buildInfo = buildInfo;
  }

  @Override
  public BuildInfo getInfo() {
    return buildInfo;
  }
}
