Feature: Calculate average grades in given subject

  Scenario: Fill 15 grades into grades datatable
    * Table "grades" is created and I see some records
    * Total entries in "grades" table should be greater or equal to 0
    * Fill "grades" table with random grades between 2 and 6 for each student for each subject
    * I can calculate the average grade for "math" class
    * I delete test data from "grades"