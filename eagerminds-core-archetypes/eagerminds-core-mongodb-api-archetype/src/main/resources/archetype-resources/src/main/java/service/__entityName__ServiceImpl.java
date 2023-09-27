package ${package}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericMongodbService;
import ${package}.domain.entity.${entityName}Entity;{package}.repository.${entityName}Repository;

@Service
public class ${entityName}ServiceImpl implements
    EagerMindsGenericMongodbService<${entityName}Entity, String> {

  private final ${entityName}Repository ${entityNameLowerCamelCase}Repository;

  @Autowired
  public ${entityName}ServiceImpl(${entityName}Repository ${entityNameLowerCamelCase}Repository) {
    this.${entityNameLowerCamelCase}Repository = ${entityNameLowerCamelCase}Repository;
  }

  @Override
  public MongoRepository<${entityName}Entity, String> getMongoRepository() {
    return ${entityNameLowerCamelCase}Repository;
  }

  @Override
  public ${entityName}Entity update(String id,
      ${entityName}Entity ${entityNameLowerCamelCase}Entity) {
    Optional<${entityName}Entity> ${entityNameLowerCamelCase} = ${entityNameLowerCamelCase}Repository
        .findById(id);
    if (${entityNameLowerCamelCase}.isPresent()) {
      ${entityNameLowerCamelCase}Entity.setId(id);
      return ${entityNameLowerCamelCase}Repository.save(${entityNameLowerCamelCase}Entity);
    }
    return null;
  }

}
