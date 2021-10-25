Feature: register and login into bard.bg

  @bardbg
  Scenario: Open bard.bg and register a new user
    Given "Local" Browser is open on Bard
    And user is on bard page
    When I click on registration page
    And I create a test user
#      | email            | password  | phone         | name | surname | familyName | postCode | town  | address                    |
      | estafet2@test.com | Estafet#1 | +359878545212 | Ivan | Ivanov | Georgiev | 1407 | Sofia | Vitosha Business Center 47 |
    Then homepage should be shown

  Scenario: Log in with created test user
    Given "Local" Browser is open on Bard
    And user is on bard page
    When  created user logs in
    Then  user page is shown
