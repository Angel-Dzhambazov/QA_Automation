@SQLvsORACLE
Feature: Compare data in MySQL and Oracle databases

  Scenario: Connect to MySQL & Oracle. Collect table information. Then compare.
    Given Established connection to "MySQL" and "Oracle" databases.
    When Information about tables is collected.
    Then Count of tables and rows should be equal.


    Scenario: Pick 5 random IDs from each table in MySQL and select the same IDs from Oracle. Then compare
      Given Established connection to MySQL and Oracle databases.
      When Information about tables is collected.
      And 5 random IDs are chosen
      Then data from MySQL and Oracle should be the same