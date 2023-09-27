package ${package}.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import ${package}.domain.dto.${topicEntityName}KeyDto;
import ${package}.domain.dto.${topicEntityName}ValueDto;

@ScenarioScope
@Component
public class ScenarioContext {

  @LocalServerPort
  protected int port;
  private Response response;
  private ${topicEntityName}KeyDto saved${topicEntityName}KeyDto;

  private ${topicEntityName}ValueDto saved${topicEntityName}ValueDto;

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

  public ${topicEntityName}KeyDto saved${topicEntityName}KeyDto() {
    return saved${topicEntityName}KeyDto;
  }

  public void setSaved${topicEntityName}KeyDto(
      ${topicEntityName}KeyDto saved${topicEntityName}KeyDto) {
    this.saved${topicEntityName}KeyDto = saved${topicEntityName}KeyDto;
  }

  public ${topicEntityName}ValueDto saved${topicEntityName}ValueDto() {
    return saved${topicEntityName}ValueDto;
  }

  public void setSaved${topicEntityName}ValueDto(
      ${topicEntityName}ValueDto saved${topicEntityName}ValueDto) {
    this.saved${topicEntityName}ValueDto = saved${topicEntityName}ValueDto;
  }
}
