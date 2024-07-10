Feature: Check product images

  Background:
    Given Open the Swag Labs Website
    When  Enter "standard_user" in the username field on Login Screen
    And   Enter "secret_sauce" in the password field on Login Screen
    And   Press the "login" button
    Then  Successful Login

  Scenario: Verify if the product images are being presented accurately
    When  press Add to cart button for Sauce Labs Backpack
    Then  cart number changes to "1"
    And   Sauce Labs Backpack image is correct

    When  Press on the cart icon on the top right of the page
    Then  Redirection to the cart page

    When  Press Check out button
    Then  Redirection to Checkout: Your Information

    When  Insert first name "Mohamed" , Last name "Elattar" and Postal code "1234"
    And   Click Contiune
    Then  Redirection to Checkout: Overview
    And   Check price 29.99

    When  Press Finish
    Then  Check Checkout: Complete!
    And  check Thank you for your order!