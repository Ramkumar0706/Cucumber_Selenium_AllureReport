@SignupFeature
Feature: Signup Feature

  Scenario: Successful Signup on AllBirds
    Given the user is on the Signup Page
    When the user enters valid details in the Signup form
    And clicks on the Register button
    Then the user is redirected to the Home Page
    
    
