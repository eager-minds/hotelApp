package tech.eagerminds.hotel.availability.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchCountDto;
import tech.eagerminds.hotel.availability.search.exception.HttpException;
import tech.eagerminds.hotel.availability.search.service.AvailabilitySearchService;

@RestController
@RequestMapping(path = "availabilitySearch")
public class AvailabilitySearchControllerImpl implements AvailabilitySearchController {

  private final AvailabilitySearchService availabilitySearchService;

  @Autowired
  public AvailabilitySearchControllerImpl(AvailabilitySearchService availabilitySearchService) {
    this.availabilitySearchService = availabilitySearchService;
  }

  @Override
  public ResponseEntity<AvailabilitySearchCountDto> countById(String id) {
    try {
      AvailabilitySearchCountDto availabilitySearchCountDto =
          availabilitySearchService.countById(id);
      return new ResponseEntity<>(availabilitySearchCountDto, HttpStatus.OK);
    } catch (HttpException e) {
      return new ResponseEntity<>(e.httpStatus());
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
