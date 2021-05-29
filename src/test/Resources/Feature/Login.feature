@tag
Feature:Login feature

  
  Scenario: Login with Valid Credentials
    Given user is  navigated to homepage of the application
    When user enter the <Username> and <Password>
    | Username  | Password         |
    | admin     | admin123         |
    And click on the Login button
    Then user should be redirected to dashboard page
    And check the Admin message.

  @tag2
  Scenario: Login with invalid Credentials
    Given user is  navigated to homepage of the application
    When user enter the <Username> and <Password>
    | Username  | Password         |
    | admin     | admin            |
    And click on the Login button
    Then Application should prompt the valid error message to user

