Feature: Service to perform mongoDb operations
  In order to work with mongoDb
  As a user
  I want to persist data to mongoDb and retrieve it

  Background:
    Given mongoDb service is running
    And mongoDb service does not contain "eagermindsMessages" collection
    And mongoDb service does not contain "eagermindsMetadatas" collection

  Scenario: Persist eagermindsMessage to mongoDb and retrieve it
    Given an eagermindsMessage object
"""eagerminds_message_value_json
{
  "id": "8f09110e-7498-461d-8e00-ae90f1f81946",
  "value": "example",
  "metadata": {
    "id": "49cf416a-fb39-4600-8f3a-8c713c9ce22e",
    "origin": "eagerminds-core-mongodb-starter-test",
    "traceId": "1",
    "user": "javier@eagerminds.tech"
  }
}
"""
    When I persist the eagermindsMessage to mongo
    And I get all eagermindsMessages
    Then There is only one item
    And received eagermindsMessage is equals to sent message field by field recursively