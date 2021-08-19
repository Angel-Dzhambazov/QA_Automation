Feature:  Update product from datatable

  Background: Check if datatable "products" exist
    Given Table "products" is created and I see some records

  Scenario: Pick a random product from table and update it with information from next product in line
    Given Total entries in "products" table should be greater or equal to 2
    When I pick a random product from "products"
    And I get quantity and price from next item
    And I update products;
    Then the needed item should have the update information
