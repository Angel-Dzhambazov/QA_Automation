@sprint3
Feature: 01) Assign students to our university

#    This table is created manually as per instructions
#  Background: Initial check for successful generation of data tables.
#    Given Successful generation of table "products";

  @students
  Scenario: Adding 5 students into table "testdatabase.students"
    Given Table "students" is created
    And Total entries in "students" table should be greater or equal to 0
    When I add "students" into data table
      | Angel  | 1987 |
      | Evgeni | 1997 |
      | Mitko  | 1994 |
      | Ivan   | 1994 |
      | Georgi | 1994 |
    Then data should be visible with manipulated table "students"
#    And I delete test data from "students"





