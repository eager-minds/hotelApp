package tech.eagerminds.hotel.availability.search.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchKeyDto;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchValueDto;

public interface KafkaAvailabilitySearchController {

  @PostMapping(path = "search", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<AvailabilitySearchKeyDto> search(@RequestBody AvailabilitySearchValueDto availabilitySearchValueDto);
}
