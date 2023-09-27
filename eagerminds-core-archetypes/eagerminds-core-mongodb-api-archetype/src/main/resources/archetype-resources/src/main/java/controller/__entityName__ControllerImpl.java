package ${package}.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericMongodbService;
import ${package}.domain.dto.${entityName}ValueDto;
import ${package}.domain.entity.${entityName}Entity;

@RestController
@RequestMapping(path = "${entityNameLowerCamelCase}")
public class ${entityName}ControllerImpl implements ${entityName}Controller {

  private static final Logger LOG = LoggerFactory.getLogger(${entityName}ControllerImpl.class);

  private final EagerMindsGenericMongodbService<${entityName}Entity, String> ${entityNameLowerCamelCase}MongoDbService;

  private final MongoOperations mongoOperations;

  @Autowired
  public ${entityName}ControllerImpl(EagerMindsGenericMongodbService<${entityName}Entity,
    String> ${entityNameLowerCamelCase}MongoDbService, MongoOperations mongoOperations) {
    this.${entityNameLowerCamelCase}MongoDbService = ${entityNameLowerCamelCase}MongoDbService;
    this.mongoOperations = mongoOperations;
  }

  @Override
  public ResponseEntity<${entityName}ValueDto> findById(String id) {
    Optional<${entityName}Entity> optional${entityName}Entity =
        ${entityNameLowerCamelCase}MongoDbService.findById(id);
    if (optional${entityName}Entity.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ${entityName}Entity ${entityNameLowerCamelCase}Entity = optional${entityName}Entity.get();
    Query query = new Query();
    query.addCriteria(Criteria.where("myString").is(${entityNameLowerCamelCase}Entity.myString()))
        .addCriteria(Criteria.where("myInt").is(${entityNameLowerCamelCase}Entity.myInt()))
        .addCriteria(Criteria.where("myIntArray").is(${entityNameLowerCamelCase}Entity.myIntArray()));
    long count = mongoOperations.count(query, ${entityName}Entity.class);
    LOG.info("${entityName}Entity count: {}", count);
    ${entityName}ValueDto ${entityNameLowerCamelCase}ValueDto = new ${entityName}ValueDto(
        ${entityNameLowerCamelCase}Entity.id(), ${entityNameLowerCamelCase}Entity.myString(),
        ${entityNameLowerCamelCase}Entity.myInt(), ${entityNameLowerCamelCase}Entity.myIntArray());
    return new ResponseEntity<>(${entityNameLowerCamelCase}ValueDto, HttpStatus.OK);
  }
}
