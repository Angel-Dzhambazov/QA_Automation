Feature: Calculate average grades in given subject

  Scenario: Fill 15 grades into grades datatable
    Given Table "grades" is created and I see some records
    And Total entries in "grades" table should be greater or equal to 0
#    When Fill "grades" table with random grades between 2 and 6 for each student for each subject
    Then I can calculate the average grade for "math" class
#    And I delete test data from "grades"