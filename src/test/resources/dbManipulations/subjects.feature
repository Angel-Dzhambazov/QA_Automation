Feature: Insert entries into table `subjects`

  Scenario Outline:
    Given Table is created and I see some records
    And Total entries in "subjects" table should be <totalEntries>
    When I insert "<subjectName>" with <year>
    Then data should be visible with select from datatable

    Examples:
      | subjectName  | year | totalEntries |
      | mavenProject | 2002 | 0            |
      | mySQL        | 1995 | 1            |
      | intelliJ     | 2001 | 2            |
