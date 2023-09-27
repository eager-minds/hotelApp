package tech.eagerminds.hotel.availability.search.service;

import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchCountDto;
import tech.eagerminds.hotel.availability.search.exception.HttpException;

public interface AvailabilitySearchService {

  AvailabilitySearchCountDto countById(String id) throws HttpException;
}
