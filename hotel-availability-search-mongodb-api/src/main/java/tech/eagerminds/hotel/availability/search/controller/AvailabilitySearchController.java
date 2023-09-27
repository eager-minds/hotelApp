package tech.eagerminds.hotel.availability.search.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchCountDto;

public interface AvailabilitySearchController {

  @GetMapping(path = "count/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<AvailabilitySearchCountDto> countById(@PathVariable("id") String id);
}
