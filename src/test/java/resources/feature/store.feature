Feature: Testing different request on the store information

  Scenario: Check if the store information can be accessed by users
    When User sends a Get request to store endpoint
    Then User must get back a valid status code 200

  Scenario Outline: Create a new store & verify if the store is added
    When I create a new store by providing the information name "<name>" type "<type>" address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    Then I verify that the store with "<name>" is created
    Examples:
      | name  | type | address         | address2 | city   | state | zip   | lat | lng | hours |
      | Shubh | Bum  | 12003 Ridgeback | Hunch    | London | GB    | 29992 |     |     |       |













