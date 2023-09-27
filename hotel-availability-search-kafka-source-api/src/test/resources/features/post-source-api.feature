Feature: Service to [send kafka message]
  In order to [send a kafka message]
  As [a user]
  I want to [get a kafka message from my api POST]

  Background:
    Given api service is running
    And kafka service is running

  Scenario: [Send a kafka message from received rest API body]
    Given kafka has a topic "hotel_availability_searches"
    And I have a kafka consumer service
    And content type is "JSON"
    And request body is
"""eagerminds_availabilitySearch_value_dto_json
{
  "hotelId": "1234aBc",
  "checkIn": "29/12/2023",
  "checkOut": "31/12/2023",
  "ages": [30, 29, 1, 3]
}
"""
    Then POST /kafka-availabilitySearch/search
    Then I get response HTTP code 201 CREATED
    And I get body from response of AvailabilitySearchKeyDto type
    And I get response body that has field searchId with generated UUID
    And I get a kafka message from topic
    Then received kafka message is equals to sent message