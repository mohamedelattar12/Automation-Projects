Feature: Complete Purchase of Multiple Items

  Background:
    Given Open the Swag Labs Website
    When  Enter "standard_user" in the username field on Login Screen
    And   Enter "secret_sauce" in the password field on Login Screen
    And   Press the "login" button
    Then  Successful Login

  Scenario: User try to purchase 3 products
    When  press Add to cart button for Sauce Labs Backpack
    And   press Add to cart button for Sauce Labs Bike Light
    And   press Add to cart button for Sauce Labs Bolt T-Shirt
    Then  cart number changes to "3"

    When  Press on the cart icon on the top right of the page
    Then  Redirection to the cart page

    When  Press Check out button
    Then  Redirection to Checkout: Your Information

    When  Insert first name "Mohamed" , Last name "Elattar" and Postal code "1234"
    And   Click Contiune
    Then  Redirection to Checkout: Overview
    And   Check price 55.97

    When  Press Finish
    Then  Check Checkout: Complete!
    And  check Thank you for your order!
#####################################################################################
  Scenario: User try to purchase 4 products
    When  press Add to cart button for Sauce Labs Backpack
    And   press Add to cart button for Sauce Labs Bike Light
    And   press Add to cart button for Sauce Labs Bolt T-Shirt
    And   press Add to cart button for Sauce Labs Fleece Jacket
    Then  cart number changes to "4"

    When  Press on the cart icon on the top right of the page
    Then  Redirection to the cart page

    When  Press Check out button
    Then  Redirection to Checkout: Your Information

    When  Insert first name "Mohamed" , Last name "Elattar" and Postal code "1234"
    And   Click Contiune
    Then  Redirection to Checkout: Overview
    And   Check price 105.96000000000001

    When  Press Finish
    Then  Check Checkout: Complete!
    And  check Thank you for your order!
    ##############################################################################################
Scenario: User try to purchase 3 Quantity of the same product
  When  press Add to cart button for Sauce Labs Backpack
  And   press Add to cart button for Sauce Labs Backpack
  And   press Add to cart button for Sauce Labs Backpack
  Then  cart number changes to "3"

  When  Press on the cart icon on the top right of the page
  Then  Redirection to the cart page

  When  Press Check out button
  Then  Redirection to Checkout: Your Information

  When  Insert first name "Mohamed" , Last name "Elattar" and Postal code "1234"
  And   Click Contiune
  Then  Redirection to Checkout: Overview
  And   Check price 89.97

  When  Press Finish
  Then  Check Checkout: Complete!
  And  check Thank you for your order!