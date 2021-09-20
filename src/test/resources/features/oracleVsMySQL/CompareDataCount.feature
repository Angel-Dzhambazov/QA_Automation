@SQLvsORACLE
Feature: Compare tables and entries count

  Scenario: Connect to MySQL & Oracle. Collect table information. Then compare.
    Given Established connection to MySQL and Oracle databases.
    When Information about tables is collected.
    Then Count of tables and rows should be equal.