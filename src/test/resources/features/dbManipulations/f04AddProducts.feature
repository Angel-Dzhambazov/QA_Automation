Feature: Add products to our database

  Scenario: Adding 10 products into table "products"

    Given Successful generation of table "products";
    And Table "products" is created and I see some records
    And Total entries in "students" table should be greater or equal to 0
    When I add "products" into data table
      | Banana  | Fruit to eat                  | 256  | 2.69  |
      | Apple   | Fruit to eat                  | 16   | 0.99  |
      | Steak   | Beautiful beef                | 7    | 22.19 |
      | Rice    | You need to cook this         | 1024 | 1.35  |
      | Bologna | The cheapest salami out there | 24   | 2.04  |

    Then data should be visible with manipulated table "products"
#    And I delete test data from "students"