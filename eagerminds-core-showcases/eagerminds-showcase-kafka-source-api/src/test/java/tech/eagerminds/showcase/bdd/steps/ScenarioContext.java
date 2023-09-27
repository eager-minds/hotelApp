package tech.eagerminds.showcase.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseKeyDto;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;

@ScenarioScope
@Component
public class ScenarioContext {

  @LocalServerPort
  protected int port;
  private Response response;
  private EagerMindsShowcaseKeyDto savedEagerMindsShowcaseKeyDto;

  private EagerMindsShowcaseValueDto savedEagerMindsShowcaseValueDto;

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

  public EagerMindsShowcaseKeyDto savedEagerMindsShowcaseKeyDto() {
    return savedEagerMindsShowcaseKeyDto;
  }

  public void setSavedEagerMindsShowcaseKeyDto(EagerMindsShowcaseKeyDto savedEagerMindsShowcaseKeyDto) {
    this.savedEagerMindsShowcaseKeyDto = savedEagerMindsShowcaseKeyDto;
  }

  public EagerMindsShowcaseValueDto savedEagerMindsShowcaseValueDto() {
    return savedEagerMindsShowcaseValueDto;
  }

  public void setSavedEagerMindsShowcaseValueDto(EagerMindsShowcaseValueDto savedEagerMindsShowcaseValueDto) {
    this.savedEagerMindsShowcaseValueDto = savedEagerMindsShowcaseValueDto;
  }
}
