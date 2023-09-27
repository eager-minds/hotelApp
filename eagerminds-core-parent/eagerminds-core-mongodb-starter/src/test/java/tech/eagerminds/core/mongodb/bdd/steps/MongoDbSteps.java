package tech.eagerminds.core.mongodb.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import tech.eagerminds.core.mongodb.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMessageEntity;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMetadataEntity;
import tech.eagerminds.core.mongodb.service.EagerMindsGenericReactiveMongodbService;

public class MongoDbSteps extends CucumberSpringConfiguration {

  @Autowired
  ScenarioContext scenarioContext;
  @Autowired
  private EagerMindsGenericReactiveMongodbService<EagerMindsMessageEntity, String> eagerMindsMessageService;

  @Autowired
  private MongoOperations mongoOperations;

  @Given("mongoDb service is running")
  public void mongodbServiceIsRunning() {
    mongoOperations.getCollectionNames();
  }

  @And("mongoDb service does not contain {string} collection")
  public void mongodbServiceDoesNotContainCollection(String collectionName) {
    mongoOperations.dropCollection(collectionName);
  }

  @Given("^an eagermindsMessage object$")
  public void anEagermindsMessageObject(EagerMindsMessageEntity eagerMindsMessageEntity) {
    scenarioContext.setSavedEagerMindsMessageEntity(eagerMindsMessageEntity);
  }

  @When("I persist the eagermindsMessage to mongo")
  public void iPersistTheEagermindsMessageToMongo() {
    eagerMindsMessageService.save(scenarioContext.savedEagerMindsMessageEntity()).block();
  }

  @And("I get all eagermindsMessages")
  public void iGetAllEagermindsMessages() {
    scenarioContext.setReceivedEagerMindsMessageEntityList(
        mongoOperations.findAll(EagerMindsMessageEntity.class));
  }

  @Then("There is only one item")
  public void thereIsOnlyOneItem() {
    assertThat(scenarioContext.receivedEagerMindsMessageEntityList())
        .hasSize(1);
  }

  @Then("received eagermindsMessage is equals to sent message field by field recursively")
  public void receivedEagermindsMessageIsEqualsToSentMessageFieldByFieldRecursively() {
    assertThat(scenarioContext.receivedEagerMindsMessageEntityList().get(0))
        .isEqualToComparingFieldByFieldRecursively(scenarioContext.savedEagerMindsMessageEntity());

    List<EagerMindsMetadataEntity> metadataList =
        mongoOperations.findAll(EagerMindsMetadataEntity.class);
    assertThat(metadataList)
        .hasSize(1);
    assertThat(metadataList.get(0))
        .isEqualToComparingFieldByFieldRecursively(
            scenarioContext.savedEagerMindsMessageEntity().metadata());
  }
}