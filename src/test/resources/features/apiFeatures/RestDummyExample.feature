@rest
Feature: Rest tests

  @DummyApiExample
  Scenario: POST Create new record in database (employee)
    Given the user creates a new record in database
    Then verify status of get request is 200


  @DummyApiExample
  Scenario: GET Get all employee data
    Given the user gets all employees
    Then verify status of get request is 200

  @DummyApiExample
  Scenario: GET Get a single employee data
    Given the user gets random employee data

  @DummyApiExample
  Scenario: Update an employee record

  @DummyApiExample
  Scenario: Delete an employee record
