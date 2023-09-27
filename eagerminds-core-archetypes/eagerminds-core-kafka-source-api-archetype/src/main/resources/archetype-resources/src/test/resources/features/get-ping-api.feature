Feature: Service to check app health status
  In order to know if the app is running
  As a developer
  I want to get a pong when I GET ping

  Background:
    Given api service is running

  Scenario: Get pong from running microservice
    When GET /ping
    Then I get response HTTP code 200 OK
    And I get a response text_plain with expected message "pong"