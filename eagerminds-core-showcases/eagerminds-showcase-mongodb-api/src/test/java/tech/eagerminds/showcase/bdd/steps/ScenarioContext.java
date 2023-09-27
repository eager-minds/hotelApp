package tech.eagerminds.showcase.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import tech.eagerminds.showcase.domain.entity.EagerMindsShowcaseEntity;

@ScenarioScope
@Component
public class ScenarioContext {

  @LocalServerPort
  protected int port;
  private Response response;

  private EagerMindsShowcaseEntity eagerMindsShowcaseEntity;

  public int port() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public Response response() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public EagerMindsShowcaseEntity eagerMindsShowcaseEntity() {
    return eagerMindsShowcaseEntity;
  }

  public void setEagerMindsShowcaseEntity(
      EagerMindsShowcaseEntity eagerMindsShowcaseEntity) {
    this.eagerMindsShowcaseEntity = eagerMindsShowcaseEntity;
  }
}
