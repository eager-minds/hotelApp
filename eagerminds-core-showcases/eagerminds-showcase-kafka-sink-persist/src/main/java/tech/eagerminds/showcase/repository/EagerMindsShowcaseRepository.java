package tech.eagerminds.showcase.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

@Repository
public interface EagerMindsShowcaseRepository
    extends ReactiveMongoRepository<EagerMindsShowcaseEntity, String> {

}
