Feature:  Test login functionality
#  user: estafet.234.sba@abv.bg
#  pass: Estafete#1

  Scenario Outline: Log in into abv.bg webMail
    Given Browser is open
    And user is on login page
    And user accepts cookies
    When user enters <username> and <password>
    And user clicks on login
#    Then user is navigated to the home page
    Examples:
      | username               | password   |
      | estafet.234.sba@abv.bg | Estafete#1 |
#      | estafet.234.sba@abv.bg | Estafete#1 |