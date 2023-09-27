package tech.eagerminds.hotel.availability.search.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public AvailabilitySearchKey availabilitySearch_key_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, AvailabilitySearchKey.class);
  }

  @DocStringType
  public AvailabilitySearchValue availabilitySearch_value_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, AvailabilitySearchValue.class);
  }

  @DocStringType
  public AvailabilitySearchEntity availabilitySearch_entity_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, AvailabilitySearchEntity.class);
  }
}
