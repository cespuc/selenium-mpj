@smoke
Feature: Search page
  Scenario: Open Bing homepage
    When I open Bing homepage
    Then the Bing title should contain "Bing"
