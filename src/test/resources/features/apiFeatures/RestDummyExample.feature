@rest
Feature: Rest tests
  @DummyApiExample
  Scenario: POST Create new record in database (employee)
    Given the user creates a new record in database
    Then verify return message is "Successfully! Record has been added"

  @DummyApiExample
  Scenario: GET Get all employee data
    Given the user gets all employees
    Then verify status of get request is 200

  @DummyApiExample
  Scenario: GET Get a single employee data
    Given the user gets random employee data
    Then confirm employee has name and surname

  @DummyApiExample
  Scenario: Update an employee record
    Given the user gets random employee data
    Then user updates employee's salary

  @DummyApiExample
  Scenario: Delete an employee record
    Given user deletes random employee
    Then verify return message is "Successfully! Record has been deleted"
