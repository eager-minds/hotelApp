package tech.eagerminds.showcase.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericMongodbService;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;
import tech.eagerminds.showcase.repository.EagerMindsShowcaseRepository;

@Service
public class EagerMindsShowcaseServiceImpl implements
    EagerMindsGenericMongodbService<EagerMindsShowcaseEntity, String> {

  private final EagerMindsShowcaseRepository eagerMindsShowcaseRepository;

  @Autowired
  public EagerMindsShowcaseServiceImpl(EagerMindsShowcaseRepository eagerMindsShowcaseRepository) {
    this.eagerMindsShowcaseRepository = eagerMindsShowcaseRepository;
  }

  @Override
  public MongoRepository<EagerMindsShowcaseEntity, String> getMongoRepository() {
    return eagerMindsShowcaseRepository;
  }

  @Override
  public EagerMindsShowcaseEntity update(String id,
      EagerMindsShowcaseEntity eagerMindsShowcaseEntity) {
    Optional<EagerMindsShowcaseEntity> eagerMindsShowcase = eagerMindsShowcaseRepository
        .findById(id);
    if (eagerMindsShowcase.isPresent()) {
      eagerMindsShowcaseEntity.setId(id);
      return eagerMindsShowcaseRepository.save(eagerMindsShowcaseEntity);
    }
    return null;
  }

}
