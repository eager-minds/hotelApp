Feature: Service to save hotel availability searches
  In order to retrieve hotel availability searches
  As a user
  I want to get a searchId of saved searches

  Background:
    Given search service is running on URL http://localhost:8080
    And kafka service is running

  Scenario: Save a new availability search
    Given kafka has a topic "hotel_availability_searches"
    And well formatted availability search
"""json
{
  "hotelId": "1234aBc",
  "checkIn": "29/12/2023",
  "checkOut": "31/12/2023",
  "ages": [3, 29, 30, 1]
}
"""
    When POST /search with availability search on body
    Then I get response HTTP code 201 CREATED
    And I get "searchId" response body with generated UUID
    And kafka topic contains message with saved search