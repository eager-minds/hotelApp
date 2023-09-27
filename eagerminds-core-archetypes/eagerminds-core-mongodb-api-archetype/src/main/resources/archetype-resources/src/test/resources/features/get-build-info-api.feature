Feature: Build information rest API from core-starter should be available when dependency is imported
  In order to know which microservice version is deployed and when was it built
  As a developer
  I want to get a rest API working

  Background:
    Given api service is running

  Scenario: Get build microservice information
    When GET /build-info
    Then I get response HTTP code 200 OK
    And I get a response json that has field applicationName with value equals to "${artifactId}-test"
    And I get a response json that has field buildVersion with value equals to "1.0.0-DUMMY_TEST"
    And I get a response json that has field buildTimestamp with value equals to "maven.build.timestamp"