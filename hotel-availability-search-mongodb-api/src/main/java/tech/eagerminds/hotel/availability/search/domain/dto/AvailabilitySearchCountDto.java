package tech.eagerminds.hotel.availability.search.domain.dto;

public record AvailabilitySearchCountDto(String searchId, AvailabilitySearchValueDto search,
                                         Long count) {

}
