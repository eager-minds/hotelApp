package tech.eagerminds.hotel.availability.search.bdd.registrytype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchValueDto;

public class DocStringRegistryType {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @DocStringType
  public AvailabilitySearchValueDto eagerminds_availabilitySearch_value_dto_json(String docString)
      throws JsonProcessingException {
    return objectMapper.readValue(docString, AvailabilitySearchValueDto.class);
  }
}
