@sprint3
Feature: 11) Get all orders of a certain customer - list in Examples customer and count

  Background: Check if datatable "orders" exist
    Given Successful generation of table "orders";

    @orders
    Scenario: Pick a random customer and find all his orders.
      Given Total entries in "orders" table should be greater or equal to 10
      When I pick a random "customers"
      Then I can count all his "orders"
      And I can print all his orders