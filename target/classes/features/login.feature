@hepsiburada @login
Feature: Hepsiburada - Login

  Scenario: Login Test
    Given User of Hepsiburada an existing user
    When User on the login page
    And User enters "username" information
    And  user "hits" the Login
    Then PasswordPage Opened
    And User enters "password" information
    Then user login sucessfully