Feature: Insert entries into table `subjects`

  Scenario: Adding 5 subjects into table "testdatabase.subjects"
    Given Table "subjects" is created and I see some records
    And Total entries in "subjects" table should be greater or equal to 0
    When I add "subjects" into data table
      | mavenProject | 2002 |
      | mySQL        | 1995 |
      | intelliJ     | 2001 |
      | math         | 1    |
      | english      | 2001 |
    Then data should be visible with manipulated table "subjects"
#    And I delete test data from "subjects"




