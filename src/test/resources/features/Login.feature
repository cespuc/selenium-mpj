@login
Feature: Login


  Scenario: Login with Missing Mandatory Fields
    Given I open page
    And I click the link with text "Log in"
    And I click on the "Log in" button
    Then an error message should be displayed

  Scenario: Successful login with valid credentials
    Given  I enter "cespuc@gmail.com" into the "Email" field
    And I enter "123456" into the "Password" field
    And I click on the "Log in" button
    Then I click the link with text "cespuc@gmail.com"
    And user navigates to My account page

