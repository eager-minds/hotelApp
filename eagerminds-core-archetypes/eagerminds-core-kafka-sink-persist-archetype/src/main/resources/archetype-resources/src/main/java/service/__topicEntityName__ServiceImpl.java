package ${package}.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;
import ${package}.domain.entity.${topicEntityName}Entity;
import ${package}.repository.${topicEntityName}Repository;

@Service
public class ${topicEntityName}ServiceImpl implements
    EagerMindsGenericReactiveMongodbService<${topicEntityName}Entity, String> {

  private final ${topicEntityName}Repository ${topicEntityNameLowerCamelCase}Repository;

  @Autowired
  public ${topicEntityName}ServiceImpl(
      ${topicEntityName}Repository ${topicEntityNameLowerCamelCase}Repository) {
    this.${topicEntityNameLowerCamelCase}Repository = ${topicEntityNameLowerCamelCase}Repository;
  }

  @Override
  public ReactiveMongoRepository<${topicEntityName}Entity, String> getReactiveMongoRepository() {
    return ${topicEntityNameLowerCamelCase}Repository;
  }

  @Override
  public Mono<${topicEntityName}Entity> update(String id,
      ${topicEntityName}Entity ${topicEntityNameLowerCamelCase}Entity) {
    return ${topicEntityNameLowerCamelCase}Repository.findById(id).map(Optional::of)
        .defaultIfEmpty(Optional.empty())
        .flatMap(optional${topicEntityName}Entity -> {
          if (optional${topicEntityName}Entity.isPresent()) {
            ${topicEntityNameLowerCamelCase}Entity.setId(id);
            return ${topicEntityNameLowerCamelCase}Repository.save(${topicEntityNameLowerCamelCase}Entity);
          }

          return Mono.empty();
        });
  }

}
