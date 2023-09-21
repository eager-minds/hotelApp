package tech.eagerminds.core.api.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface PingController {

  @GetMapping
  String ping();
}
