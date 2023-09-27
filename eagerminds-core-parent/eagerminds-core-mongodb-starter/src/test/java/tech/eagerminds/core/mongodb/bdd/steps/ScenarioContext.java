package tech.eagerminds.core.mongodb.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import java.util.List;
import org.springframework.stereotype.Component;
import tech.eagerminds.core.mongodb.domain.entity.EagerMindsMessageEntity;

@ScenarioScope
@Component
public class ScenarioContext {

  private EagerMindsMessageEntity savedEagerMindsMessageEntity;

  private EagerMindsMessageEntity receivedEagerMindsMessageEntity;

  private List<EagerMindsMessageEntity> receivedEagerMindsMessageEntityList;

  public EagerMindsMessageEntity savedEagerMindsMessageEntity() {
    return savedEagerMindsMessageEntity;
  }

  public void setSavedEagerMindsMessageEntity(
      EagerMindsMessageEntity savedEagerMindsMessageEntity) {
    this.savedEagerMindsMessageEntity = savedEagerMindsMessageEntity;
  }

  public EagerMindsMessageEntity receivedEagerMindsMessageEntity() {
    return receivedEagerMindsMessageEntity;
  }

  public void setReceivedEagerMindsMessageEntity(
      EagerMindsMessageEntity receivedEagerMindsMessageEntity) {
    this.receivedEagerMindsMessageEntity = receivedEagerMindsMessageEntity;
  }

  public List<EagerMindsMessageEntity> receivedEagerMindsMessageEntityList() {
    return receivedEagerMindsMessageEntityList;
  }

  public void setReceivedEagerMindsMessageEntityList(
      List<EagerMindsMessageEntity> receivedEagerMindsMessageEntityList) {
    this.receivedEagerMindsMessageEntityList = receivedEagerMindsMessageEntityList;
  }
}
