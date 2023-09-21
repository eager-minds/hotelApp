Feature: Service to send kafka message
  In order to send a kafka message
  As a user
  I want to get a kafka message on my topic

  Background:
    Given kafka service is running

  Scenario: Send a kafka message
    Given kafka has a topic "eagerminds-core"
    When I send a kafka message
"""eagerminds_value_json
"eagerMinds"
"""
    And I get a kafka message from topic
    Then received kafka message is equals to sent message