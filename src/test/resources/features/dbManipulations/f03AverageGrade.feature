@sprint3
Feature: 03) Calculate average grades in given subject

  @grades
  Scenario: Fill 15 grades into grades datatable
    Given Table "grades" is created
    And Total entries in "students" table should be greater or equal to 1
    And Total entries in "subjects" table should be greater or equal to 1
    When Fill "grades" table with random grades between 2 and 6 for each student for each subject
    Then I can calculate the average grade for "math" class
#    And I delete test data from "grades"