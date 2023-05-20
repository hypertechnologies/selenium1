Feature: Saucedemo login functionality

  @login
  Scenario: User should be able to login with valid credentials
    # Steps are written using Gherkin commands, e.g, Given, When, And, Then

    Given I navigate to "http://saucedemo.com"
    When I enter valid username and password
    And I click on login button
    Then I should be successfully logged in
    And I quit the browser