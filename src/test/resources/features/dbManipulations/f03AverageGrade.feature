@sprint3
Feature: 03) Calculate average grades in given subject

#  This table is created manually as per instructions
#  Background: Initial check for successful generation of data tables.
#    Given Successful generation of table "grades";

  @grades
  Scenario: Fill 15 grades into grades datatable
    Given Table "grades" is created
    And Total entries in "grades" table should be greater or equal to 0
#    When Fill "grades" table with random grades between 2 and 6 for each student for each subject
    Then I can calculate the average grade for "math" class
#    And I delete test data from "grades"