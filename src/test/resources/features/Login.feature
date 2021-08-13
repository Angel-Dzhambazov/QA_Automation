Feature: LoginFeature

  Scenario: Login with correct credentials.
    Given I navigate to the login page
    And I enter credentials
    And I click login button
    Then I should see user page