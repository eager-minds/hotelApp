package tech.eagerminds.core.mongodb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMessageEntity;

@Repository
public interface EagerMindsMessageRepository
    extends ReactiveMongoRepository<EagerMindsMessageEntity, String> {

}
