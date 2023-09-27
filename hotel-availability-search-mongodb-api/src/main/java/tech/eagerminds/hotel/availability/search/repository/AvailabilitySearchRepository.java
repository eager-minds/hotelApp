package tech.eagerminds.hotel.availability.search.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;

@Repository
public interface AvailabilitySearchRepository
    extends MongoRepository<AvailabilitySearchEntity, String> {

}
