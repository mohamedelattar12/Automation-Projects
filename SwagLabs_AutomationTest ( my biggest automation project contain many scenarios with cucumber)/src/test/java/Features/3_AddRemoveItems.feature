Feature: Adding and Removing Items from Cart
  Background:
    Given Open the Swag Labs Website
    When  Enter "standard_user" in the username field on Login Screen
    And   Enter "secret_sauce" in the password field on Login Screen
    And   Press the "login" button
    Then  Successful Login

  Scenario: User wants to buy 3 products then wants to remove 1 from the cart
    When  press Add to cart button for Sauce Labs Backpack
    And   press Add to cart button for Sauce Labs Bike Light
    And   press Add to cart button for Sauce Labs Bolt T-Shirt
    Then  cart number changes to "3"

    When  Press on the cart icon on the top right of the page
    Then  Redirection to the cart page

    When  Press on the remove for "Sauce Labs Bolt T-Shirt"
    Then  cart number changes to "2"
    And   Assert "Sauce Labs Bolt T-Shirt" disappeared

    When  Press Check out button
    Then  Redirection to Checkout: Your Information

    When  Insert first name "Mohamed" , Last name "Elattar" and Postal code "1234"
    And   Click Contiune

    Then  Redirection to Checkout: Overview
    And   Check price 39.98

    When  Press Finish
    Then  Check Checkout: Complete!
    And  check Thank you for your order!
