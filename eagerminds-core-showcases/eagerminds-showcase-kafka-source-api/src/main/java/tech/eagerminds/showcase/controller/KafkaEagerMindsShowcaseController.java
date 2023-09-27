package tech.eagerminds.showcase.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseKeyDto;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;

public interface KafkaEagerMindsShowcaseController {

  @PostMapping(path = "send", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<EagerMindsShowcaseKeyDto> sendMessage(@RequestBody EagerMindsShowcaseValueDto eagerMindsShowcaseValueDto);
}
