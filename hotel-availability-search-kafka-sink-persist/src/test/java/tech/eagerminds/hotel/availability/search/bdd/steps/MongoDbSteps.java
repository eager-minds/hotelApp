package tech.eagerminds.hotel.availability.search.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import tech.eagerminds.hotel.availability.search.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;

public class MongoDbSteps extends CucumberSpringConfiguration {

  @Autowired
  ScenarioContext scenarioContext;

  @Autowired
  private MongoOperations mongoOperations;

  @And("mongoDB service is running")
  public void mongodbServiceIsRunning() {
    mongoOperations.getCollectionNames();
  }

  @Then("entity of received topic message is persisted on mongoDB")
  public void entityOfReceivedTopicMessageIsPersistedOnMongoDB(AvailabilitySearchEntity entity) {
    AvailabilitySearchEntity availabilitySearchEntity = mongoOperations.findById(entity.id(),
        AvailabilitySearchEntity.class);
    assertThat(availabilitySearchEntity).isEqualToComparingFieldByFieldRecursively(entity);
  }
}
