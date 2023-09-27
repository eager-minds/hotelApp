package ${package}.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ${package}.domain.dto.${topicEntityName}KeyDto;
import ${package}.domain.dto.${topicEntityName}ValueDto;

public interface Kafka${topicEntityName}Controller {

  @PostMapping(path = "send", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<${topicEntityName}KeyDto> sendMessage(@RequestBody ${topicEntityName}ValueDto ${topicEntityNameLowerCamelCase}ValueDto);
}
