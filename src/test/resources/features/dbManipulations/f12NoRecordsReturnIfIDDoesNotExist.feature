@sprint3
Feature: 12) No records returned if product does not exist - Use the DB table from the previous scenario
  Background: Check if datatable "orders" exist
    Given Successful generation of table "products";

    Scenario: Pick a random number and look in for it in the DB Table. When entry exist - show the result, if not
    show a message that this record does not exist.
      Given Total entries in "products" table should be greater or equal to 1
      When I pick a random number between 15 and 55
      Then Then I select this random "products".

