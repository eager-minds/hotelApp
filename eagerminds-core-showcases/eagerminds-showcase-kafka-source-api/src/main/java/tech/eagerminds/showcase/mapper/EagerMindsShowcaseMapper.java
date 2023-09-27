package tech.eagerminds.showcase.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcase;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseKey;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseValue;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseKeyDto;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;

@Mapper(componentModel = "spring")
public interface EagerMindsShowcaseMapper {

  EagerMindsShowcaseKey toAvro(EagerMindsShowcaseKeyDto eagerMindsShowcaseKeyDto);

  @Mapping(target = "metadata", ignore = true)
  @Mapping(target = "entity", source = ".")
  @Mapping(target = "entityBuilder", ignore = true)
  EagerMindsShowcaseValue toAvro(EagerMindsShowcaseValueDto eagerMindsShowcaseValueDto);

  EagerMindsShowcaseKeyDto toDto(EagerMindsShowcaseKey eagerMindsShowcaseKey);

  @Mapping(target = ".", source = "entity")
  EagerMindsShowcaseValueDto toDto(EagerMindsShowcaseValue eagerMindsShowcaseValue);

  EagerMindsShowcase toEagerMindsShowcase(EagerMindsShowcaseValueDto eagerMindsShowcaseValueDto);
}
