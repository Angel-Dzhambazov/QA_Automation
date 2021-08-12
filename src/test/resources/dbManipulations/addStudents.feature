Feature: Assign students to our university

  Scenario: Fill university with students
    Given I have university with table "students"
    When I add students into students table
      | Angel  | 1987 |
      | Evgeni | 1997 |
      | Mitko  | 1994 |
    Then I check for successfully class full with "students"
    And I delete test data from "students"

