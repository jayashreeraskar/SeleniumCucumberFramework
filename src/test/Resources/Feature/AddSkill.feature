 @Skill
 Feature:Skill Feature
 Background:
    Given user is  navigated to homepage of the application
    When user enter the <Username> and <Password>
    | Username  | Password         |
    | admin     | admin123         |
    And click on the Login button
    Then user should be redirected to dashboard page
    
 
   
  Scenario: Add the Valid Skill
    Given User navigated to Admin tab and Qualification
    And Select the Skills from the menubar
    When user clicks on the Add button
    And User enters the valid <Skillname > and <Skill Description>
    | Skillname  | Description                 |
    | java       | Best Java Developer         |
    And user click on the Save  button
    Then Newly added skill should be displayed on the viewSkill page 

  @tag2
  Scenario:Add the Duplicate Skill 
    Given User navigated to Admin tab and Qualification
    And Select the Skills from the menubar
    When user clicks on the Add button
    And User enters the valid <Skillname > and <Skill Description>
    | Skillname  | Description                 |
    | java       | Best Java Developer         |
    And user click on the Save  button
    Then inline error message should be displayed
    And Verify the error message

