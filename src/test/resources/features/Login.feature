@LoginFeature
Feature: User Login Functionality
  As a registered user
  I want to be able to log into the AllBirds website
  So that I can access my account and purchase items

  @login
  Scenario: Successful login with valid credentials
    Given the user is on the Login Page
    When the user enters valid login credentials
    Then the user should be redirected to the Home Page
    And the title of the Login Page should be validated
    And the Log out button should be displayed after successful login

  @login
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the Login Page
    When the user enters invalid login credentials
    Then an error message should be displayed for invalid login
    And the title of the Login Page should be validated
    And the email and password fields should be enabled
    And the Sign-in button should be enabled