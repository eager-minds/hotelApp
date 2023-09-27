package tech.eagerminds.hotel.availability.search.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericMongodbService;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;
import tech.eagerminds.hotel.availability.search.repository.AvailabilitySearchRepository;

@Service
public class EagerMindsMongoDbServiceImpl implements
    EagerMindsGenericMongodbService<AvailabilitySearchEntity, String> {

  private final AvailabilitySearchRepository availabilitySearchRepository;

  @Autowired
  public EagerMindsMongoDbServiceImpl(AvailabilitySearchRepository availabilitySearchRepository) {
    this.availabilitySearchRepository = availabilitySearchRepository;
  }

  @Override
  public MongoRepository<AvailabilitySearchEntity, String> getMongoRepository() {
    return availabilitySearchRepository;
  }

  @Override
  public AvailabilitySearchEntity update(String id,
      AvailabilitySearchEntity availabilitySearchEntity) {
    Optional<AvailabilitySearchEntity> availabilitySearch = availabilitySearchRepository
        .findById(id);
    if (availabilitySearch.isPresent()) {
      availabilitySearchEntity.setId(id);
      return availabilitySearchRepository.save(availabilitySearchEntity);
    }
    return null;
  }

}
