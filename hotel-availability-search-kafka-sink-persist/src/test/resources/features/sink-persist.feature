Feature: Service to persist messages from kafka topic to mongoDB
  In order to persist messages to database
  As a user
  I want to have a batch that persists all messages from hotel_availability_searches topic to mongoDB

  Background:
    Given kafka service is running
    And kafka has a topic "hotel_availability_searches"
    And mongoDB service is running

  Scenario: Persist a new message on hotel_availability_searches topic to mongoDB
    Given hotel_availability_searches well formatted message key
"""availabilitySearch_key_json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21"
}
"""
    And hotel_availability_searches well formatted message value
"""availabilitySearch_value_json
{
  "entity": {
    "hotelId": "1234aBc",
    "checkIn": "29/12/2023",
    "checkOut": "31/12/2023",
    "ages": [30, 29, 1, 3]
  }
}
"""
    When message is sent to "hotel_availability_searches" topic
    Then entity of received topic message is persisted on mongoDB
"""availabilitySearch_entity_json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21",
  "hotelId": "1234aBc",
  "checkIn": "29/12/2023",
  "checkOut": "31/12/2023",
  "ages": [30, 29, 1, 3]
}
"""
