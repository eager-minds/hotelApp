package tech.eagerminds.core.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ping")
public class PingControllerImpl implements PingController {

  @Override
  public String ping() {
    return "pong";
  }

}
