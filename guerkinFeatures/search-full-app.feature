Feature: App to save hotel availability searches and retrieve a count of similar ones
  In order to get a total of similar hotel availability searches
  As a user
  I want to have an application that saves a hotel availability search providing an ID on response that I can use to get a count of similar searches

  Background:
    Given running hotel availability searches application

  Scenario Outline: Save a well format availability search <times> times and check count when retrieve
    Given well formatted availability search
"""json
{
  "hotelId": "1234aBc",
  "checkIn": "29/12/2023",
  "checkOut": "31/12/2023",
  "ages": [3, 29, 30, 1]
}
"""
    And  POST /search with availability search on body <times> times
    When GET /search with returned searchId
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