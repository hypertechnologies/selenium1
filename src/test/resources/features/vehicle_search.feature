Feature: Vehicle search functionality

  Scenario: User should be able to search for vehicle
    Given I navigate to "http://google.com"
    When I search for "Accord"
    Then I verify number of search result is visible
    And I quit the browser


