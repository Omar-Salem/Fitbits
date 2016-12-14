Feature: Fitbits

  Scenario:Basic case 1
    Given boundaries are 5,5
    And trainee position is 1,2,"N"
    And coach instructs trainee
      | L |
      | M |
      | L |
      | M |
      | L |
      | M |
      | L |
      | M |
      | M |

    And trainee position is 3,3,"E"
    And coach instructs trainee
      | M |
      | M |
      | R |
      | M |
      | M |
      | R |
      | M |
      | R |
      | R |
      | M |

    When trainee 1 is finished
    Then output is "1 3 N"

    When trainee 2 is finished
    Then output is "5 1 E"