Feature: Assign students to our university

  Scenario: Adding 5 students into table "testdatabase.students"
    Given Table "students" is created and I see some records
    And Total entries in "students" table should be greater or equal to 0
    When I add "students" into students table
      | Angel  | 1987 |
      | Evgeni | 1997 |
      | Mitko  | 1994 |
      | Ivan  | 1994 |
      | Georgi  | 1994 |
    Then data should be visible with manipulated table "students"
#    And I delete test data from "students"

