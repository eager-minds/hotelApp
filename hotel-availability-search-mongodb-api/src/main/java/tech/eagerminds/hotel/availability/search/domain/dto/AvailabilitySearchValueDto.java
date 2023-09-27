package tech.eagerminds.hotel.availability.search.domain.dto;

import java.util.List;

public record AvailabilitySearchValueDto(String hotelId, String checkIn,
                                         String checkOut, List<Integer> ages) {

}
