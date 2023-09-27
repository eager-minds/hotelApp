package tech.eagerminds.showcase.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseKey;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseValue;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public EagerMindsShowcaseKey eagerMindsShowcase_key_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, EagerMindsShowcaseKey.class);
  }

  @DocStringType
  public EagerMindsShowcaseValue eagerMindsShowcase_value_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, EagerMindsShowcaseValue.class);
  }

  @DocStringType
  public EagerMindsShowcaseEntity eagerMindsShowcase_entity_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, EagerMindsShowcaseEntity.class);
  }
}
