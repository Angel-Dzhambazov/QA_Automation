@SQLvsPOSTGRE
Feature: Compare data in MySQL and PostgreSQL databases

  Scenario: Connect to MySQL & PostgreSQL. Collect table information. Then compare.
    Given Established connection to MySQL and PostgreSQL databases.
    When Information about tables is collected.
    Then Count of tables and rows should be equal.


  Scenario: Pick 5 random IDs from each table in MySQL and select the same IDs from PostgreSQL. Then compare
    Given Established connection to MySQL and Oracle databases.
    When Information about tables is collected.
    And 5 random IDs are chosen
    Then data from MySQL and Oracle should be the same