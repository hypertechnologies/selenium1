Feature: Verify Demoqa checkboxes

  @demoqa
  Scenario: User should be able to expand all checkbox options
  and select public and private
    Given I navigate to "https://demoqa.com/checkbox"
    When I expand all checkboxes
    And I check public and private
    Then I should see a text called "You have selected :publicprivate"
    And I quit the browser
    