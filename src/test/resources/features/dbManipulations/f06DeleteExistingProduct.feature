@sprint3
Feature:  6) Delete existing product - Use the DB table from the previous scenario

  Scenario: Pick a random entry and delete it
    Given Total entries in "products" table should be greater or equal to 2
    When I pick a random product from "products"
    And I get quantity and price from next item
    And I delete this product
    Then This product should not exist anymore
