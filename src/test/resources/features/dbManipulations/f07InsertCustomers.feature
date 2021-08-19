@sprint3
Feature: 7) Insert a new customer in a table with next columns
  customer_number, first_name, last_name, phone, address_line1, address_line2, city, postcode
  - Create test DB table

  Background: Initial check for successful generation of data tables.
    Given Successful generation of table "customers";
    And Table "customers" is created and I see some records

  @customers
  Scenario: Insert customers to table.
    Given Total entries in "customers" table should be greater or equal to 0
    When I add "customers" into data table
      | Angel    | Dzhambazov | +359894301801 | Pazardzhik | Sofia   | Sofia   | 1680 |
      | Ivan     | Georgiev   | +359878668432 | Plovdiv    | Varna   | Sofia   | 1000 |
      | Todor    | Shumanov   | +359878668841 | Sofia      | Druzhba | Sofia   | 1000 |
      | Svetlana | Dungarova  | +359896626279 | Pazardzhik | Sofia   | Sofia   | 1680 |
      | Hristo   | Stoichkov  | +359888888888 | Plovdiv    | Plovdiv | Plovdiv | 4000 |
    Then data should be visible with manipulated table "customers"
#    And I delete test data from "customers"
