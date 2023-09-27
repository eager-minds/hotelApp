package tech.eagerminds.showcase.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;

public interface EagerMindsShowcaseController {

  @GetMapping(path = "find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<EagerMindsShowcaseValueDto> findById(@PathVariable("id") String id);
}
