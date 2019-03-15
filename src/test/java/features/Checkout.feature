Feature: Checkout
  As a user I want to be able to successfully checkout selected product

  Scenario: Successful checkout
    Given user is logged in
    When user navigates to women tab
    And user clicks on details button of a random item
    And user adds the item to the cart
    And user notices total item price in the popup window
    And user proceeds to checkout in popup window
    And user proceeds to checkout on summary page
    And user checks delivery and billing addresses
    And user agrees with terms and proceeds to checkout on shipping page
    And user click on check payment option on payment page
    And user confirms the order on order confirmation page
    And user verifies that oder has been submitted
    And user navigates back to orders
    Then user verifies that the total price of placed order is right
    And user logs out



