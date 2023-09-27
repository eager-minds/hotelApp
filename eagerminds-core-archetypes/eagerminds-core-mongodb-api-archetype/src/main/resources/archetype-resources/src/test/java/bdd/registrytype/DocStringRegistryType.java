package ${package}.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import ${package}.domain.entity.${entityName}Entity;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public ${entityName}Entity ${entityNameLowerCamelCase}_entity_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, ${entityName}Entity.class);
  }
}
