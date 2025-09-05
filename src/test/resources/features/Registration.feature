@smoke
@registration
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
    Given  I enter "123456" into the "Password" field
    And  I should see error message for "Email" with text "Wrong email"


  Scenario: Attempt to register with weak password
    Given I click the link with text "Register"
    And  I enter "123" into the "Password" field
    And  I enter "123" into the "ConfirmPassword" field
    And I should see error message for "Password" with text "The password should have at least 6 characters."


  Scenario: Register with valid details
    Given I click the link with text "Register"
    And I enter "Jure" into the "FirstName" field
    And I enter "Novak" into the "LastName" field
    And I enter a random email into the Email field
    And I enter "1233456" into the "Password" field
    And I enter "1233456" into the "ConfirmPassword" field
    And I click on the "Register" button
    Then I should see the registration success message
    And I click the Continue button




