package ${package}.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import ${package}.bdd.configuration.CucumberSpringConfiguration;
import ${package}.domain.entity.${entityName}Entity;

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
  public void entityOfReceivedTopicMessageIsPersistedOnMongoDB(${entityName}Entity entity) {
    ${entityName}Entity ${entityNameLowerCamelCase}Entity = mongoOperations.findById(entity.id(),
        ${entityName}Entity.class);
    assertThat(${entityNameLowerCamelCase}Entity).isEqualToComparingFieldByFieldRecursively(entity);
  }

  @And("mongoDB has a document")
  public void mongodbHasADocument(${entityName}Entity ${entityNameLowerCamelCase}Entity) {
    ${entityName}Entity ${entityNameLowerCamelCase} = mongoOperations.save(${entityNameLowerCamelCase}Entity);
    scenarioContext.set${entityName}Entity(${entityNameLowerCamelCase});
  }
}
