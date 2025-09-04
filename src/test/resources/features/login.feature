@smoke
Feature: Login page

  Scenario: Open page
    Given I open page
    Then  I click the link with text "Register"
    When I enter "Marko" into the "FirstName" field
    And I enter "Novak" into the "LastName" field
    And I enter a random email into the Email field
    And I enter "Test1234!" into the "Password" field
    And I enter "Test1234!" into the "ConfirmPassword" field
    And I click on the "Register" button
    Then I should see the registration success message


