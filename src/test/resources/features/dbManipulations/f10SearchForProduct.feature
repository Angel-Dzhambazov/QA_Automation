@sprint3
Feature: 10) Search for a product/customer in the db - list in Examples search_term and table

  @products
  Scenario: Search for a product in the products datatable
    Given Total entries in "products" table should be greater or equal to 2
    When I pick a random entry from "products"
    And I print all information for this "products"

  @customers
  Scenario:  Search for a customer in the products datatable
    Given Total entries in "customers" table should be greater or equal to 2
    When I pick a random entry from "customers"
    And I print all information for this "customers"