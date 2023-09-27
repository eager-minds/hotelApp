Feature: Service to [send kafka message]
  In order to [send a kafka message]
  As [a user]
  I want to [get a kafka message from my api POST]

  Background:
    Given api service is running
    And kafka service is running

  Scenario: [Send a kafka message from received rest API body]
    Given kafka has a topic "${topicName}"
    And I have a kafka consumer service
    And content type is "JSON"
    And request body is
"""eagerminds_${topicEntityNameLowerCamelCase}_value_dto_json
{
  "myString": "eagerMinds",
  "myInt": 3,
  "myIntArray": [1, 2, 3, 4]
}
"""
    Then POST /kafka-${topicEntityNameLowerCamelCase}/send
    Then I get response HTTP code 201 CREATED
    And I get body from response of ${topicEntityName}KeyDto type
    And I get response body that has field id with generated UUID
    And I get a kafka message from topic
    Then received kafka message is equals to sent message