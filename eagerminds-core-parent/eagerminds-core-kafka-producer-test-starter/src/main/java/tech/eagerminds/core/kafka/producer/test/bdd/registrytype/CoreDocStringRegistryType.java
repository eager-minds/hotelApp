package tech.eagerminds.core.kafka.producer.test.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;

public class CoreDocStringRegistryType {

  ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public JsonNode json(String docString) throws JsonProcessingException {
    return objectMapper.readTree(docString);
  }
}
