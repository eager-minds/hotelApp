package tech.eagerminds.showcase.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseKey;
import tech.eagerminds.showcase.domain.avro.EagerMindsShowcaseValue;

@ScenarioScope
@Component
public class ScenarioContext {

  private EagerMindsShowcaseKey eagerMindsShowcaseKey;
  private EagerMindsShowcaseValue eagerMindsShowcaseValue;

  public EagerMindsShowcaseKey eagerMindsShowcaseKey() {
    return eagerMindsShowcaseKey;
  }

  public void setEagerMindsShowcaseKey(
      EagerMindsShowcaseKey eagerMindsShowcaseKey) {
    this.eagerMindsShowcaseKey = eagerMindsShowcaseKey;
  }

  public EagerMindsShowcaseValue eagerMindsShowcaseValue() {
    return eagerMindsShowcaseValue;
  }

  public void setEagerMindsShowcaseValue(
      EagerMindsShowcaseValue eagerMindsShowcaseValue) {
    this.eagerMindsShowcaseValue = eagerMindsShowcaseValue;
  }
}
