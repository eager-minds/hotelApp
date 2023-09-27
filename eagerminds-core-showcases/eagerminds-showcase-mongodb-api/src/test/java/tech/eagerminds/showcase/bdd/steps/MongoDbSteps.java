package tech.eagerminds.showcase.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import tech.eagerminds.showcase.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

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
  public void entityOfReceivedTopicMessageIsPersistedOnMongoDB(EagerMindsShowcaseEntity entity) {
    EagerMindsShowcaseEntity eagerMindsShowcaseEntity = mongoOperations.findById(entity.id(),
        EagerMindsShowcaseEntity.class);
    assertThat(eagerMindsShowcaseEntity).isEqualToComparingFieldByFieldRecursively(entity);
  }

  @And("mongoDB has a document")
  public void mongodbHasADocument(EagerMindsShowcaseEntity eagerMindsShowcaseEntity) {
    EagerMindsShowcaseEntity eagerMindsShowcase = mongoOperations.save(eagerMindsShowcaseEntity);
    scenarioContext.setEagerMindsShowcaseEntity(eagerMindsShowcase);
  }
}
