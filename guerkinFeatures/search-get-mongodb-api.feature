Feature: Service to retrieve hotel availability searches
  In order to retrieve a count of similar hotel availability searches
  As a user
  I want to retrieve search object with count of similar searches passing a searchId

  Background:
    Given search service is running on URL http://localhost:8080
    And mongoDB service is running
    And mongoDB has "hotel_availability" database
    And mongoDB has "search" collection

  Scenario Outline: Retrieve an existing availability search by id
    Given well formatted mongodb document id
"""json
{
  "id": "2db8db9a-391a-4c25-8edb-98450d9f9f21"
}
"""
    And well formatted mongodb document value
"""json
{
  "hotelId": "1234aBc",
  "checkIn": "29/12/2023",
  "checkOut": "31/12/2023",
  "ages": [3, 29, 30, 1]
}
"""
    When  GET /search with returned searchId
    Then I get saved search with <times> times count of similar searches
"""json
{
  "searchId": "<consultedId>",
  "search": {
    "hotelId": "1234aBc",
    "checkIn": "29/12/2023",
    "checkOut": "31/12/2023",
    "ages": [3, 29, 30, 1]
  },
  "count": "<times>"
}
"""
    Examples:
      | times |
      | 3     |