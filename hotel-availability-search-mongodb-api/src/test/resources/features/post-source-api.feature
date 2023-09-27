Feature: Service to [access mongodb from api rest]
  In order to [retrieve mongodb documents]
  As [a user]
  I want to [query mongodb from my api GET request]

  Background:
    Given api service is running
    And mongoDB service is running

  Scenario: [Retrieve mongoDb document by Id from rest API query]
    Given mongoDB has a document
"""availabilitySearch_entity_json
{
  "id": "3207b26d-6c9a-4da9-bc06-6bcf0e138ab0",
  "hotelId": "1234aBc",
  "checkIn": "29/12/2023",
  "checkOut": "31/12/2023",
  "ages": [3, 29, 30, 1]
}
"""
    And content type is "JSON"
    Then GET /availabilitySearch/count/3207b26d-6c9a-4da9-bc06-6bcf0e138ab0
    Then I get response HTTP code 200 OK
    And response body content is equal to mongoDb document