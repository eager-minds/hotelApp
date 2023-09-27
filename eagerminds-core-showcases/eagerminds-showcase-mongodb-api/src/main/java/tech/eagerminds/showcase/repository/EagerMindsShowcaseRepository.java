package tech.eagerminds.showcase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

@Repository
public interface EagerMindsShowcaseRepository
    extends MongoRepository<EagerMindsShowcaseEntity, String> {

}
