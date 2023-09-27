package ${package}.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ${package}.domain.dto.${entityName}ValueDto;

public interface ${entityName}Controller {

  @GetMapping(path = "find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<${entityName}ValueDto> findById(@PathVariable("id") String id);
}
