Feature: Service to receive kafka message
  In order to receive a kafka message
  As a user
  I want to get a kafka message from my topic

  Background:
    Given kafka service is running

  Scenario: Receive a kafka message
    Given kafka has a topic "generic-test"
    When I send a kafka message
"""eagerminds_value_json
"eagerMinds"
"""
    And I get a kafka message from topic
    Then received kafka message is equals to sent message