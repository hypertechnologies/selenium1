Feature:Verify GURU99 checkout

  Scenario: User should be able to successfully pay for the product
    Given I navigate to "https://demo.guru99.com/payment-gateway/purchasetoy.php"
    When I select quantity
    And I click on BUY NOW option
    Then I need to fill payment process form
    When I click PAY option
    Then I should see payment success screen
    And I quit the browser