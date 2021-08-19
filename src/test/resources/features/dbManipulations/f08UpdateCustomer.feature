@sprint3
Feature:  Update customer from datatable

  Background: Check if datatable "customers" exist
    Given Table "customers" is created and I see some records

  Scenario: Pick a random product from table and update it with information from next product in line
    Given Total entries in "customers" table should be greater or equal to 2
    When I pick a random product from "customers"
    And I get quantity and price from next item
    And I update "customers";
    Then the needed item should have the update information
