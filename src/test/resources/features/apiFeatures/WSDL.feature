Feature: Establish connection and test CountryInfoService.wso with WsdlProject
  Scenario: Get a list with countries
    Given Connection to API is established
    When user executes query
    Then user receives a list with continents