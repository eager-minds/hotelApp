package tech.eagerminds.hotel.availability.search.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import tech.eagerminds.hotel.availability.search.domain.entity.AvailabilitySearchEntity;

@ScenarioScope
@Component
public class ScenarioContext {

  @LocalServerPort
  protected int port;
  private Response response;

  private AvailabilitySearchEntity availabilitySearchEntity;

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

  public AvailabilitySearchEntity availabilitySearchEntity() {
    return availabilitySearchEntity;
  }

  public void setAvailabilitySearchEntity(
      AvailabilitySearchEntity availabilitySearchEntity) {
    this.availabilitySearchEntity = availabilitySearchEntity;
  }
}
