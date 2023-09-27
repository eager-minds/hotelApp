package tech.eagerminds.core.api.bdd.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterAll;
import tech.eagerminds.core.api.bdd.configuration.CucumberSpringConfiguration;
import tech.eagerminds.core.api.helper.HttpMethod;

public class ApiSteps extends CucumberSpringConfiguration {

  RequestSpecification requestSpecification;

  Response response;


  @AfterAll
  public static void tearDown() {
    reset();
  }

  @Given("^(?:[a-z]+ )?api service is running$")
  public void api_service_is_running() {
    requestSpecification = given().baseUri("http://localhost:" + port)
        // requestSpecification = given().baseUri("https://virtserver.swaggerhub.com/eagerminds/xyzXYZxyz/1.0.0")
        .contentType(ContentType.JSON)
        .log().all();
  }

  @And("^content type is \"([^\"]*)\"$")
  public void content_type_is(String contentType) {
    requestSpecification.contentType(contentType);
  }

  @When("^(GET|POST) (\\/[a-z_-]+)$")
  public void getBuildInfo(HttpMethod httpMethod, String path) {
    response = switch (httpMethod) {
      case GET -> requestSpecification.when().get(path);
      case POST -> requestSpecification.when().post(path);
      default -> throw new io.cucumber.java.PendingException();
    };
  }

  @Then("^I get response HTTP code ([0-9]+)(?: [a-zA-Z]+)?")
  public void response_http_code_created(Integer httpCode) {
    response.then().assertThat().statusCode(httpCode);
  }

  @Then("I get a response json with build information")
  public void responseJsonWithBuildInformation() {
    response.then()
        .body("applicationName", equalTo("eagerminds-core-starter-api-test"))
        .body("buildVersion", equalTo("1.0.0-DUMMY_TEST"))
        .body("buildTimestamp", equalTo("maven.build.timestamp"));
  }

  @Then("I get a response text_plain with {string}")
  public void responseText_plainWith(String expectedMessage) {
    assertThat(response.asString()).isEqualTo(expectedMessage);
  }
}