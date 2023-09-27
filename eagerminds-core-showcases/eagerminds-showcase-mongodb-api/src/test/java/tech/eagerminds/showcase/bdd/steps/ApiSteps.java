package tech.eagerminds.showcase.bdd.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.AssertionsForClassTypes;
import org.springframework.beans.factory.annotation.Autowired;
import tech.eagerminds.core.api.helper.HttpMethod;
import tech.eagerminds.showcase.bdd.configuration.CucumberSpringConfiguration;

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
        // use given().baseUri("https://your.mock.server/path") instead to test with a mock server
        // requestSpecification = given().baseUri("https://virtserver.swaggerhub.com/eagerminds/xyzXYZxyz/1.0.0")
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

  @When("^(GET|POST) ([\\/0-9a-zA-Z_-]+)$")
  public void call_rest_api_by_http_method(HttpMethod httpMethod, String path) {
    scenarioContext.setResponse(callByHttpMethod(httpMethod, path));
  }

  private Response callByHttpMethod(HttpMethod httpMethod, String path) {
    return switch (httpMethod) {
      case GET -> requestSpecification.when().get(path);
      case POST -> requestSpecification.post(path);
      default -> throw new io.cucumber.java.PendingException();
    };
  }

  @Then("^I get response HTTP code ([0-9]+)(?: [a-zA-Z]+)?")
  public void response_http_code_created(Integer httpCode) {
    scenarioContext.response().then().assertThat().statusCode(httpCode);
  }

  @Then("^(?:I get a )response json that has field ([a-zA-Z]+) with value(?: equals to) \"(.*)\"")
  public void responseJsonWithBuildInformation(String jsonField, String value) {
    scenarioContext.response().then().body(jsonField, equalTo(value));
  }

  @Then("I get a response text_plain with expected message {string}")
  public void response_text_plain_with_expected_message(String expectedMessage) {
    AssertionsForClassTypes.assertThat(scenarioContext.response().asString())
        .isEqualTo(expectedMessage);
  }

  @And("response body content is equal to mongoDb document")
  public void responseBodyContentIsEqualToMongoDbDocument() {
    scenarioContext.response().then()
        .body("id", equalTo(scenarioContext.eagerMindsShowcaseEntity().id()));
    scenarioContext.response().then()
        .body("myString", equalTo(scenarioContext.eagerMindsShowcaseEntity().myString()));
    scenarioContext.response().then()
        .body("myInt", equalTo(scenarioContext.eagerMindsShowcaseEntity().myInt()));
    scenarioContext.response().then()
        .body("myIntArray", equalTo(scenarioContext.eagerMindsShowcaseEntity().myIntArray()));
  }
}