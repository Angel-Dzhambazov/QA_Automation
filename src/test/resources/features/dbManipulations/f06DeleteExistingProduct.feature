@sprint3
Feature:  6) Delete existing product - Use the DB table from the previous scenario

  @products
  Scenario: Pick a random entry and delete it
    Given Total entries in "products" table should be greater or equal to 1
    When I pick a random entry from "products"
    And I delete this product
    Then This product should not exist anymore
