package tech.eagerminds.showcase.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;
import tech.eagerminds.showcase.repository.EagerMindsShowcaseRepository;

@Service
public class EagerMindsShowcaseServiceImpl implements
    EagerMindsGenericReactiveMongodbService<EagerMindsShowcaseEntity, String> {

  private final EagerMindsShowcaseRepository eagerMindsShowcaseRepository;

  @Autowired
  public EagerMindsShowcaseServiceImpl(
      EagerMindsShowcaseRepository eagerMindsShowcaseRepository) {
    this.eagerMindsShowcaseRepository = eagerMindsShowcaseRepository;
  }

  @Override
  public ReactiveMongoRepository<EagerMindsShowcaseEntity, String> getReactiveMongoRepository() {
    return eagerMindsShowcaseRepository;
  }

  @Override
  public Mono<EagerMindsShowcaseEntity> update(String id,
      EagerMindsShowcaseEntity eagerMindsShowcaseEntity) {
    return eagerMindsShowcaseRepository.findById(id).map(Optional::of)
        .defaultIfEmpty(Optional.empty())
        .flatMap(optionalEagerMindsShowcaseEntity -> {
          if (optionalEagerMindsShowcaseEntity.isPresent()) {
            eagerMindsShowcaseEntity.setId(id);
            return eagerMindsShowcaseRepository.save(eagerMindsShowcaseEntity);
          }

          return Mono.empty();
        });
  }

}
