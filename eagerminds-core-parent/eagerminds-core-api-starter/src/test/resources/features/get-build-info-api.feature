Feature: Service to [expose rest api]
  In order to [send rest calls]
  As [a developer]
  I want to [get a api rest working]

  Background:
    Given api service is running

  Scenario: Get build microservice information
    When GET /build-info
    Then I get response HTTP code 200 OK
    And I get a response json with build information