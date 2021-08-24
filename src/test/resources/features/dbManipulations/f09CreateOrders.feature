@sprint3
Feature: 09) Create Orders DB table with columns: order_number, customer_number, product_code, quantity, total_price, date

  Background: Check if datatable "orders" exist
    Given Successful generation of table "orders";


  @orders
  Scenario: Fill orders table with some entries
    Given Total entries in "orders" table should be greater or equal to 0
    When I add 30 orders into data table
    Then data should be visible with manipulated table "orders"
    And I delete test data from "orders"


