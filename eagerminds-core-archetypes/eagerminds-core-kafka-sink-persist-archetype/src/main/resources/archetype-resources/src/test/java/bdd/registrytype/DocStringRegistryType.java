package ${package}.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import ${package}.domain.avro.${topicEntityName}Key;
import ${package}.domain.avro.${topicEntityName}Value;
import ${package}.domain.entity.${topicEntityName}Entity;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public ${topicEntityName}Key ${topicEntityNameLowerCamelCase}_key_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, ${topicEntityName}Key.class);
  }

  @DocStringType
  public ${topicEntityName}Value ${topicEntityNameLowerCamelCase}_value_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, ${topicEntityName}Value.class);
  }

  @DocStringType
  public ${topicEntityName}Entity ${topicEntityNameLowerCamelCase}_entity_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, ${topicEntityName}Entity.class);
  }
}
