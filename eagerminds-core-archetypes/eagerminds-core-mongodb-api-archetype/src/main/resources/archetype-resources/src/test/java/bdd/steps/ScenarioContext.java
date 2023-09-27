package ${package}.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import ${package}.domain.entity.${entityName}Entity;

@ScenarioScope
@Component
public class ScenarioContext {

  @LocalServerPort
  protected int port;
  private Response response;

  private ${entityName}Entity ${entityNameLowerCamelCase}Entity;

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

  public ${entityName}Entity ${entityNameLowerCamelCase}Entity() {
    return ${entityNameLowerCamelCase}Entity;
  }

  public void set${entityName}Entity(
      ${entityName}Entity ${entityNameLowerCamelCase}Entity) {
    this.${entityNameLowerCamelCase}Entity = ${entityNameLowerCamelCase}Entity;
  }
}
