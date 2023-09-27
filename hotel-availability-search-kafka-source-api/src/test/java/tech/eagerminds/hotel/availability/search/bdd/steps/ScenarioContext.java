package tech.eagerminds.hotel.availability.search.bdd.steps;

import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchKeyDto;
import tech.eagerminds.hotel.availability.search.domain.dto.AvailabilitySearchValueDto;

@ScenarioScope
@Component
public class ScenarioContext {

  @LocalServerPort
  protected int port;
  private Response response;
  private AvailabilitySearchKeyDto savedAvailabilitySearchKeyDto;

  private AvailabilitySearchValueDto savedAvailabilitySearchValueDto;

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

  public AvailabilitySearchKeyDto savedAvailabilitySearchKeyDto() {
    return savedAvailabilitySearchKeyDto;
  }

  public void setSavedAvailabilitySearchKeyDto(
      AvailabilitySearchKeyDto savedAvailabilitySearchKeyDto) {
    this.savedAvailabilitySearchKeyDto = savedAvailabilitySearchKeyDto;
  }

  public AvailabilitySearchValueDto savedAvailabilitySearchValueDto() {
    return savedAvailabilitySearchValueDto;
  }

  public void setSavedAvailabilitySearchValueDto(
      AvailabilitySearchValueDto savedAvailabilitySearchValueDto) {
    this.savedAvailabilitySearchValueDto = savedAvailabilitySearchValueDto;
  }
}
