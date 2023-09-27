package ${package}.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ${package}.domain.avro.${topicEntityName};
import ${package}.domain.avro.${topicEntityName}Key;
import ${package}.domain.avro.${topicEntityName}Value;
import ${package}.domain.dto.${topicEntityName}KeyDto;
import ${package}.domain.dto.${topicEntityName}ValueDto;

@Mapper(componentModel = "spring")
public interface ${topicEntityName}Mapper {

  ${topicEntityName}Key toAvro(${topicEntityName}KeyDto ${topicEntityNameLowerCamelCase}KeyDto);

  ${topicEntityName}KeyDto toDto(${topicEntityName}Key ${topicEntityNameLowerCamelCase}Key);

  @Mapping(target = "metadata", ignore = true)
  @Mapping(target = "entity", source = ".")
  @Mapping(target = "entityBuilder", ignore = true)
  ${topicEntityName}Value toAvro(${topicEntityName}ValueDto ${topicEntityNameLowerCamelCase}ValueDto);

  @Mapping(target = ".", source = "entity")
  ${topicEntityName}ValueDto toDto(${topicEntityName}Value ${topicEntityNameLowerCamelCase}Value);

  ${topicEntityName} to${topicEntityName}(${topicEntityName}ValueDto ${topicEntityNameLowerCamelCase}ValueDto);
}
