Feature: Service to persist messages from hotel_availability_searches topic to mongoDB
  In order to persist hotel availability searches to database
  As a user
  I want to have a batch that persists all messages on hotel_availability_searches to mongoDB

  Background:
    Given kafka service is running
    And kafka has a topic "hotel_availability_searches"
    And mongoDB service is running
    And mongoDB has "hotel_availability" database
    And mongoDB has "search" collection

  Scenario: Persist a new message on hotel_availability_searches topic to mongoDB
    Given "hotel_availability_searches" well formatted message key
"""json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21"
}
"""
    And "hotel_availability_searches" well formatted message value
"""json
{
  "entity": {
    "hotelId": "1234aBc",
    "checkIn": "29/12/2023",
    "checkOut": "31/12/2023",
    "ages": [3, 29, 30, 1]
  }
}
"""
    When message is sent to "hotel_availability_searches" topic
    Then key-entity of received topic message are persisted on mongoDB
      | {"id": "2db8db9a-391a-4c25-8edb-98450d9f9f21"}                                                 |
      | {"hotelId": "1234aBc","checkIn": "29/12/2023","checkOut": "31/12/2023","ages": [3, 29, 30, 1]} |
