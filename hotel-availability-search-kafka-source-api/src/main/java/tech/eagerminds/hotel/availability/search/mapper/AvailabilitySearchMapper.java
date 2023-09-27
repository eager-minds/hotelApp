package tech.eagerminds.hotel.availability.search.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchKeyDto;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchValueDto;

@Mapper(componentModel = "spring")
public interface AvailabilitySearchMapper {

  @Mapping(target = "id", source = "searchId")
  AvailabilitySearchKey toAvro(AvailabilitySearchKeyDto availabilitySearchKeyDto);

  @Mapping(target = "searchId", source = "id")
  AvailabilitySearchKeyDto toDto(AvailabilitySearchKey availabilitySearchKey);

  @Mapping(target = "metadata", ignore = true)
  @Mapping(target = "entity", source = ".")
  @Mapping(target = "entityBuilder", ignore = true)
  AvailabilitySearchValue toAvro(AvailabilitySearchValueDto availabilitySearchValueDto);

  @Mapping(target = ".", source = "entity")
  AvailabilitySearchValueDto toDto(AvailabilitySearchValue availabilitySearchValue);

  AvailabilitySearch toAvailabilitySearch(AvailabilitySearchValueDto availabilitySearchValueDto);
}
