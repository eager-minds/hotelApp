package tech.eagerminds.hotel.availability.search.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericMongodbService;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchCountDto;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchValueDto;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;
import tech.eagerminds.hotel.availability.search.exception.HttpException;

@Service
public class AvailabilitySearchServiceImpl implements AvailabilitySearchService {

  private final EagerMindsGenericMongodbService<AvailabilitySearchEntity, String> availabilitySearchMongoDbService;

  private final MongoOperations mongoOperations;

  @Autowired
  public AvailabilitySearchServiceImpl(EagerMindsGenericMongodbService<AvailabilitySearchEntity,
      String> availabilitySearchMongoDbService, MongoOperations mongoOperations) {
    this.availabilitySearchMongoDbService = availabilitySearchMongoDbService;
    this.mongoOperations = mongoOperations;
  }

  @Override
  public AvailabilitySearchCountDto countById(String id) throws HttpException {
    Optional<AvailabilitySearchEntity> optionalAvailabilitySearchEntity =
        availabilitySearchMongoDbService.findById(id);
    if (optionalAvailabilitySearchEntity.isEmpty()) {
      throw new HttpException(HttpStatus.NOT_FOUND);
    }
    AvailabilitySearchEntity availabilitySearchEntity = optionalAvailabilitySearchEntity.get();
    Query query = new Query();
    query.addCriteria(Criteria.where("hotelId").is(availabilitySearchEntity.hotelId()))
        .addCriteria(Criteria.where("checkIn").is(availabilitySearchEntity.checkIn()))
        .addCriteria(Criteria.where("checkOut").is(availabilitySearchEntity.checkOut()))
        .addCriteria(Criteria.where("ages").is(availabilitySearchEntity.ages()));
    long count = mongoOperations.count(query, AvailabilitySearchEntity.class);
    AvailabilitySearchValueDto availabilitySearchValueDto = new AvailabilitySearchValueDto(
        availabilitySearchEntity.hotelId(), availabilitySearchEntity.checkIn(),
        availabilitySearchEntity.checkOut(), availabilitySearchEntity.ages());
    return new AvailabilitySearchCountDto(availabilitySearchEntity.id(), availabilitySearchValueDto,
        count);
  }
}
