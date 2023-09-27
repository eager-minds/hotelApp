Feature: Service to persist messages from kafka topic to mongoDB
  In order to persist messages to database
  As a user
  I want to have a batch that persists all messages from ${topicName} topic to mongoDB

  Background:
    Given kafka service is running
    And kafka has a topic "${topicName}"
    And mongoDB service is running

  Scenario: Persist a new message on ${topicName} topic to mongoDB
    Given ${topicName} well formatted message key
"""${topicEntityNameLowerCamelCase}_key_json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21"
}
"""
    And ${topicName} well formatted message value
"""${topicEntityNameLowerCamelCase}_value_json
{
  "entity": {
    "myString": "eagerMinds",
    "myInt": 3,
    "myIntArray": [1, 2, 3, 4]
  }
}
"""
    When message is sent to "${topicName}" topic
    Then entity of received topic message is persisted on mongoDB
"""${topicEntityNameLowerCamelCase}_entity_json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21",
  "myString": "eagerMinds",
  "myInt": 3,
  "myIntArray": [1, 2, 3, 4]
}
"""
