package tech.eagerminds.core.mongodb.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMessageEntity;
import tech.eagerminds.core.mongodb.repository.EagerMindsMessageRepository;

@Service
public class EagerMindsReactiveMongodbServiceImpl implements
    EagerMindsGenericReactiveMongodbService<EagerMindsMessageEntity, String> {

  private final EagerMindsMessageRepository eagerMindsMessageRepository;

  @Autowired
  public EagerMindsReactiveMongodbServiceImpl(
      EagerMindsMessageRepository eagerMindsMessageRepository) {
    this.eagerMindsMessageRepository = eagerMindsMessageRepository;
  }

  @Override
  public ReactiveMongoRepository<EagerMindsMessageEntity, String> getReactiveMongoRepository() {
    return eagerMindsMessageRepository;
  }

  @Override
  public Mono<EagerMindsMessageEntity> update(String id,
      EagerMindsMessageEntity eagerMindsMessageEntity) {
    return eagerMindsMessageRepository.findById(id).map(Optional::of)
        .defaultIfEmpty(Optional.empty())
        .flatMap(optionalEagerMindsMessageEntity -> {
          if (optionalEagerMindsMessageEntity.isPresent()) {
            eagerMindsMessageEntity.setId(id);
            return eagerMindsMessageRepository.save(eagerMindsMessageEntity);
          }

          return Mono.empty();
        });
  }

}
