package tech.eagerminds.hotel.availability.search.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchKey;
import tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearchValue;

@ScenarioScope
@Component
public class ScenarioContext {

  private AvailabilitySearchKey availabilitySearchKey;
  private AvailabilitySearchValue availabilitySearchValue;

  public AvailabilitySearchKey availabilitySearchKey() {
    return availabilitySearchKey;
  }

  public void setAvailabilitySearchKey(
      AvailabilitySearchKey availabilitySearchKey) {
    this.availabilitySearchKey = availabilitySearchKey;
  }

  public AvailabilitySearchValue availabilitySearchValue() {
    return availabilitySearchValue;
  }

  public void setAvailabilitySearchValue(
      AvailabilitySearchValue availabilitySearchValue) {
    this.availabilitySearchValue = availabilitySearchValue;
  }
}
