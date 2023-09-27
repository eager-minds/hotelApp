package tech.eagerminds.showcase.controller;

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
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

@RestController
@RequestMapping(path = "eagerMindsShowcase")
public class EagerMindsShowcaseControllerImpl implements EagerMindsShowcaseController {

  private static final Logger LOG = LoggerFactory.getLogger(EagerMindsShowcaseControllerImpl.class);

  private final EagerMindsGenericMongodbService<EagerMindsShowcaseEntity, String> eagerMindsShowcaseMongoDbService;

  private final MongoOperations mongoOperations;

  @Autowired
  public EagerMindsShowcaseControllerImpl(EagerMindsGenericMongodbService<EagerMindsShowcaseEntity,
      String> eagerMindsShowcaseMongoDbService, MongoOperations mongoOperations) {
    this.eagerMindsShowcaseMongoDbService = eagerMindsShowcaseMongoDbService;
    this.mongoOperations = mongoOperations;
  }

  @Override
  public ResponseEntity<EagerMindsShowcaseValueDto> findById(String id) {
    Optional<EagerMindsShowcaseEntity> optionalEagerMindsShowcaseEntity =
        eagerMindsShowcaseMongoDbService.findById(id);
    if (optionalEagerMindsShowcaseEntity.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    EagerMindsShowcaseEntity eagerMindsShowcaseEntity = optionalEagerMindsShowcaseEntity.get();
    Query query = new Query();
    query.addCriteria(Criteria.where("myString").is(eagerMindsShowcaseEntity.myString()))
        .addCriteria(Criteria.where("myInt").is(eagerMindsShowcaseEntity.myInt()))
        .addCriteria(Criteria.where("myIntArray").is(eagerMindsShowcaseEntity.myIntArray()));
    long count = mongoOperations.count(query, EagerMindsShowcaseEntity.class);
    LOG.info("EagerMindsShowcaseEntity count: {}", count);
    EagerMindsShowcaseValueDto eagerMindsShowcaseValueDto = new EagerMindsShowcaseValueDto(
        eagerMindsShowcaseEntity.id(), eagerMindsShowcaseEntity.myString(),
        eagerMindsShowcaseEntity.myInt(), eagerMindsShowcaseEntity.myIntArray());
    return new ResponseEntity<>(eagerMindsShowcaseValueDto, HttpStatus.OK);
  }
}
