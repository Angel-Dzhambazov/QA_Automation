@sprint3
Feature:  Update product from datatable

  Background: Initial check for successful generation of data tables.
    Given Successful generation of table "Students";

  Scenario: Pick a random product from table and update it with information from next product in line
    Given Total entries in "products" table should be greater or equal to 2
    When I pick a random entry from "products"
    And I get quantity and price from next "products"
    And I update "products";
    Then the needed item should have the update information in "products"
