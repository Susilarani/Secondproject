Feature: Customer can sign up succesfully


  @Register
  Scenario: New customer can register with valid credentials and sign up

    Given Customer is in homepage
    When he navigates to registration page
    And he enter his details
    Then he should sign up succesfully