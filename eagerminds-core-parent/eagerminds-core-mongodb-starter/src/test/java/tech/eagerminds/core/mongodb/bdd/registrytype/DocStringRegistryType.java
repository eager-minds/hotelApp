package tech.eagerminds.core.mongodb.bdd.registrytype;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMessageEntity;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public EagerMindsMessageEntity eagerminds_message_value_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, EagerMindsMessageEntity.class);
  }
}
