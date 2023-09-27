package tech.eagerminds.hotel.availability.search.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;
import tech.eagerminds.hotel.availability.search.repository.AvailabilitySearchRepository;

@Service
public class AvailabilitySearchServiceImpl implements
    EagerMindsGenericReactiveMongodbService<AvailabilitySearchEntity, String> {

  private final AvailabilitySearchRepository availabilitySearchRepository;

  @Autowired
  public AvailabilitySearchServiceImpl(
      AvailabilitySearchRepository availabilitySearchRepository) {
    this.availabilitySearchRepository = availabilitySearchRepository;
  }

  @Override
  public ReactiveMongoRepository<AvailabilitySearchEntity, String> getReactiveMongoRepository() {
    return availabilitySearchRepository;
  }

  @Override
  public Mono<AvailabilitySearchEntity> update(String id,
      AvailabilitySearchEntity availabilitySearchEntity) {
    return availabilitySearchRepository.findById(id).map(Optional::of)
        .defaultIfEmpty(Optional.empty())
        .flatMap(optionalAvailabilitySearchEntity -> {
          if (optionalAvailabilitySearchEntity.isPresent()) {
            availabilitySearchEntity.setId(id);
            return availabilitySearchRepository.save(availabilitySearchEntity);
          }

          return Mono.empty();
        });
  }

}
