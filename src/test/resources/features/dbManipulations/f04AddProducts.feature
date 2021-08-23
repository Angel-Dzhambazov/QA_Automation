@sprint3
Feature: 04) Add products to our database

  Background: Initial check for successful generation of data tables.
    Given Successful generation of table "products";

  @students
  Scenario: Adding 5 products into table "products"
    Given Total entries in "products" table should be greater or equal to 0
    When I add "products" into data table
      | Banana  | Fruit to eat                  | 256  | 2.69  |
      | Apple   | Fruit to eat                  | 16   | 0.99  |
      | Steak   | Beautiful beef                | 7    | 22.19 |
      | Rice    | You need to cook this         | 1024 | 1.35  |
      | Bologna | The cheapest salami out there | 24   | 2.04  |

    Then data should be visible with manipulated table "products"
#    And I delete test data from "products"