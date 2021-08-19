@sprint3
Feature: 7) Insert a new customer in a table with next columns
    customer_number, first_name, last_name, phone, address_line1, address_line2, city, postcode
        - Create test DB table

  Background: Initial check for successful generation of data tables.
    Given Successful generation of table "customers";
    And Table "customers" is created and I see some records

  Scenario: Insert customers to table.
    Given Total entries in "customers" table should be greater or equal to 0
    When I add "customers" into data table
      | mavenProject | 2002 |
      | mySQL        | 1995 |
      | intelliJ     | 2001 |
      | math         | 1    |
      | english      | 2001 |
    Then data should be visible with manipulated table "customers"
#    And I delete test data from "customers"
