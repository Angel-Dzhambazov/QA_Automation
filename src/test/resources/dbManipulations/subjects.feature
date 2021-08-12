Feature: Insert entries into table `subjects`

  Scenario:
    Given Table is created and I see some records
    And Total entries in "subjects" table should be 0
    When I insert subjectName with year
      | mavenProject | 2002 |
      | mySQL        | 1995 |
      | intelliJ     | 2001 |
    Then data should be visible with select from datatable
    And I delete test data from "subjects"




