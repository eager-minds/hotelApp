package tech.eagerminds.showcase.bdd.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.notNullValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.AssertionsForClassTypes;
import org.springframework.beans.factory.annotation.Autowired;
import tech.eagerminds.core.api.helper.HttpMethod;
import tech.eagerminds.showcase.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseKeyDto;
import tech.eagerminds.showcase.domain.dto.EagerMindsShowcaseValueDto;

public class ApiSteps extends CucumberSpringConfiguration {

  @Autowired
  ScenarioContext scenarioContext;
  private RequestSpecification requestSpecification;

  @AfterAll
  public static void tearDown() {
    RestAssured.reset();
  }

  private void setRequestSpecification() {
    requestSpecification = given().port(scenarioContext.port())
//    use given().baseUri("https://your.mock.server/path") instead to test with a mock server
//    requestSpecification = given().baseUri("https://virtserver.swaggerhub.com/eagerminds/xyzXYZxyz/1.0.0")
        .log().all();
  }

  @Given("^(?:[a-z]+ )?api service is running$")
  public void api_service_is_running() {
    setRequestSpecification();
// This get will throw an exception if the service is not running
    requestSpecification.get();
  }

  @Given("^content type is \"([^\"]*)\"$")
  public void content_type_is(ContentType contentType) {
    requestSpecification.when().contentType(contentType);
  }

  @Given("^request body is$")
  public void request_body_is(EagerMindsShowcaseValueDto eagerMindsShowcaseValueDto) {
    scenarioContext.setSavedEagerMindsShowcaseValueDto(eagerMindsShowcaseValueDto);
    requestSpecification.body(eagerMindsShowcaseValueDto);
  }

  @When("^(GET|POST) ([\\/a-zA-Z_-]+)$")
  public void call_rest_api_by_http_method(HttpMethod httpMethod, String path) {
    scenarioContext.setResponse(switch (httpMethod) {
      case GET -> requestSpecification.when().get(path);
      case POST -> requestSpecification.post(path);
      default -> throw new io.cucumber.java.PendingException();
    });
  }

  @When("^I get body from response of EagerMindsShowcaseKeyDto type$")
  public void get_body_from_response_of_eagerMindsShowcaseKey_type() throws JsonProcessingException {
    scenarioContext.setSavedEagerMindsShowcaseKeyDto(
        new ObjectMapper().readValue(scenarioContext.response().body().asString(), EagerMindsShowcaseKeyDto.class));
  }

  @Then("^I get response HTTP code ([0-9]+)(?: [a-zA-Z]+)?")
  public void i_get_response_http_code_created(Integer httpCode) {
    scenarioContext.response().then().assertThat().statusCode(httpCode);
  }

  @Then("^(?:I get a )response json that has field ([a-zA-Z]+) with value(?: equals to) \"(.*)\"")
  public void iGetAResponseJsonWithBuildInformation(String jsonField, String value) {
    scenarioContext.response().then().body(jsonField, equalTo(value));
  }

  @Then("I get a response text_plain with expected message {string}")
  public void i_get_response_text_plain_with_expected_message(String expectedMessage) {
    AssertionsForClassTypes.assertThat(scenarioContext.response().asString())
        .isEqualTo(expectedMessage);
  }

  @Then("^(?:I get )response body that has field ([a-zA-Z]+) with generated UUID$")
  public void i_get_response_body_with_generated_uuid(String fieldName) {
    scenarioContext.response().then()
        .body(fieldName, responseBody -> notNullValue())
        .body(fieldName, responseBody -> hasToString(responseBody.jsonPath().getUUID(fieldName).toString()))
        .log().all();
  }
}