Feature: User Login
  As a user
  I want to login to the e-commerce website
  So that I can shop on the website

  @Smoke
  Scenario Outline: Registered user logging in with valid username and password
    Given the user is on the login page
    When the user enters valid data "<username>" and "<password>"
    Then the login will be successful with title "Swag Labs"
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
