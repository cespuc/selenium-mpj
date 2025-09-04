@smoke
Feature: Registration


  Scenario: Registration with Missing Mandatory Fields
    Given I open page
    And I click the link with text "Register"
    And I click on the "Register" button
    Then I should see error message for "First name" with text "First name is required."
    And I should see error message for "Last name" with text "Last name is required."
    And I should see error message for "Email" with text "Email is required."
    And I should see error message for "Password" with text "Password is required."
    And I should see error message for "Confirm password" with text "Password is required."

  Scenario: Register with Invalid Email Format
   Given  I enter "invalid-email" into the "Email" field
   And  I enter "123457" into the "ConfirmPassword" field
   Then I should see error message for "Confirm password" with text "The password and confirmation password do not match."

  Scenario: Password and Confirm Password Mismatch
    And  I enter "123456" into the "Password" field
    And  I should see error message for "Email" with text "Wrong email"


