Feature: Service to [access mongodb from api rest]
  In order to [retrieve mongodb documents]
  As [a user]
  I want to [query mongodb from my api GET request]

  Background:
    Given api service is running
    And mongoDB service is running

  Scenario: [Retrieve mongoDb document by Id from rest API query]
    Given mongoDB has a document
"""${entityNameLowerCamelCase}_entity_json
{
  "id": "3207b26d-6c9a-4da9-bc06-6bcf0e138ab0",
  "myString": "eagerMinds",
  "myInt": 3,
  "myIntArray": [1, 2, 3, 4]
}
"""
    And content type is "JSON"
    Then GET /${entityNameLowerCamelCase}/find/3207b26d-6c9a-4da9-bc06-6bcf0e138ab0
    Then I get response HTTP code 200 OK
    And response body content is equal to mongoDb document