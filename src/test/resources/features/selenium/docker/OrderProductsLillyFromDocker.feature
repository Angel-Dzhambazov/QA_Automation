@lilly
Feature: Login in shop.lillydrogerie.bg and implement two scenarios

  Scenario Outline: Login, change product page order some products for less than 49E
    Given "Docker" Browser is open on Lilly
    And user successfully logs in
    When user clicks on category <category>
    And user arranges the items by price <order>
    And user buys the first 4 items
    Then total price of the order should be <moreOrLess> than <totalPrice>
    And delivery cost should be <deliveryCost>
    And delete all items from shopping cart

    Examples:
      | category | order      | moreOrLess | totalPrice | deliveryCost |
      | man care | ascending  | less       | 98         | 5.50         |
      | perfume  | descending | more       | 98         | 0.00         |

