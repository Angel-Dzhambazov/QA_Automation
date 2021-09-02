Feature: Login in shop.lillydrogerie.bg and implement two scenarios


  Scenario: Login, change product page order some products for less than 49E
    Given Browser is open
    And user successfully logs in
    When user clicks on category man's care
    And user arranges the items by price order ascending
    And user buys the first 4 items
    Then total price of the order should be below 49Euro


  Scenario: Login, change product page order some products for more than 49E
    And user successfully logs in
    When user clicks on category perfume
    And user arranges the items by price order descending
    And user buys the first 4 items
    Then total price of the order should be above 49Euro
