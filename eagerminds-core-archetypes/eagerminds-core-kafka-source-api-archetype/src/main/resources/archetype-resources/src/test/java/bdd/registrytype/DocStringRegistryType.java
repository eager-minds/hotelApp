package ${package}.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import ${package}.domain.dto.${topicEntityName}ValueDto;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public ${topicEntityName}ValueDto eagerminds_${topicEntityNameLowerCamelCase}_value_dto_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, ${topicEntityName}ValueDto.class);
  }
}
