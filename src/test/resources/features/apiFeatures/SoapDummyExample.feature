@SOAPcalc
Feature: SOAP Calculator tests

  Scenario Outline: Test different functions of calculator
    Given user is testing <function> of calculator with <intA> and <intB>
    Then result should be as <expected>
    Examples:
      | function | intA | intB | expected |
      | Add      | 2    | 2    | 4        |
      | Divide   | 12   | 5    | 2        |
      | Multiply | 6    | 6    | 36       |
      | Subtract | 10   | 6    | 4        |

