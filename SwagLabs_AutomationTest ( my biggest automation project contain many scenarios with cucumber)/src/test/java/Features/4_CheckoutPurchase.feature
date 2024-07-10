Feature: Check out purchases
  Background:
    Given Open the Swag Labs Website
    When  Enter "standard_user" in the username field on Login Screen
    And   Enter "secret_sauce" in the password field on Login Screen
    And   Press the "login" button
    Then  Successful Login

  Scenario: Verify that attempting to checkout with an empty cart
    When  Press on the cart icon on the top right of the page
    Then  Redirection to the cart page

    When  Press Check out button
    Then  Refuse Redirection to Checkout: Your Information


  Scenario: Verify that entering invalid shipping information during checkout
    When  press Add to cart button for Sauce Labs Backpack
    Then  cart number changes to "1"

    When  Press on the cart icon on the top right of the page
    Then  Redirection to the cart page

    When  Press Check out button
    Then  Redirection to Checkout: Your Information

    When  Insert first name "" , Last name "" and Postal code ""
    And   Click Contiune
    Then  Check the error message is "Error: First Name is required"

