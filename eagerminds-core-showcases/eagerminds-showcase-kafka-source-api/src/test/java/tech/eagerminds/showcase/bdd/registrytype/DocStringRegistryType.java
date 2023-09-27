package tech.eagerminds.showcase.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public EagerMindsShowcaseValueDto eagerMindsShowcase_value_dto_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, EagerMindsShowcaseValueDto.class);
  }
}
