@sprint3
Feature:  08) Update customer from datatable

  Background: Check if datatable "customers" exist
    Given Table "customers" is created

  Scenario: Pick a random product from table and update it with information from next product in line
    Given Total entries in "customers" table should be greater or equal to 2
    When I pick a random entry from "customers"
    And I get quantity and price from next "customers"
    And I update the random "customers" with the next one's information;
    Then the needed item should have the update information in "customers"
