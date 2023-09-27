Feature: Service to persist messages from kafka topic to mongoDB
  In order to persist messages to database
  As a user
  I want to have a batch that persists all messages from eagerminds-showcase topic to mongoDB

  Background:
    Given kafka service is running
    And kafka has a topic "eagerminds-showcase"
    And mongoDB service is running

  Scenario: Persist a new message on eagerminds-showcase topic to mongoDB
    Given eagerminds-showcase well formatted message key
"""eagerMindsShowcase_key_json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21"
}
"""
    And eagerminds-showcase well formatted message value
"""eagerMindsShowcase_value_json
{
  "entity": {
    "myString": "eagerMinds",
    "myInt": 3,
    "myIntArray": [1, 2, 3, 4]
  }
}
"""
    When message is sent to "eagerminds-showcase" topic
    Then entity of received topic message is persisted on mongoDB
"""eagerMindsShowcase_entity_json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21",
  "myString": "eagerMinds",
  "myInt": 3,
  "myIntArray": [1, 2, 3, 4]
}
"""
