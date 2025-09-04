@smoke
Feature: Registration

  Scenario: Successful user registration
    Given I open page
    Then  I click the link with text "Register"
    When I enter "Marko" into the "FirstName" field
    And I enter "Novak" into the "LastName" field
    And I enter a random email into the Email field
    And I enter "Test1234!" into the "Password" field
    And I enter "Test1234!" into the "ConfirmPassword" field



  Scenario: Successful user registration 1
    Then I click on the "Register" button
    And I should see the message "Your registration completed"
    And I click the Continue button