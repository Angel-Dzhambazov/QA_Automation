Feature:  Generate test data in mysql and oracle databases

  Scenario Outline: insert 10 records into  MySQL database
    Given successful connection to MySQL database <table>
    And number of entries is set
    When entry is inserted into <table>
    Then number of rows has risen.
    Examples:
      | table      | todo_description | cost | initiated_on | is_completed |
      | checklists | change oil       | 25   | 2021-9-10    | 0            |

