Feature: Complete Purchase of Single Item

  Background:
    Given Open the Swag Labs Website
    When  Enter "standard_user" in the username field on Login Screen
    And   Enter "secret_sauce" in the password field on Login Screen
    And   Press the "login" button
    Then  Successful Login

  Scenario: User try to buy products after using sort from A to Z

    When  Press the sorting drop down
    And   choose Name "A to Z"
    Then  Products are sorted from "A to Z" successfully

    When  press Add to cart button for Sauce Labs Backpack
    Then  cart number changes to "1"

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

########################################################################################################################

  Scenario: User try to buy products after using sort from Z to A

    When  Press the sorting drop down
    And   choose Name "Z to A"
    Then  Products are sorted from "Z to A" successfully

    When  press Add to cart button for Sauce Labs Backpack
    Then  cart number changes to "1"

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
    ##################################################################################
  Scenario: User try to buy products after using sort from Low to High

    When  Press the sorting drop down
    And   choose Name "Low to High"
    Then  Products are sorted from "Low to High" successfully

    When  press Add to cart button for Sauce Labs Backpack
    Then  cart number changes to "1"

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
    #############################################################
  Scenario: User try to buy products after using sort from High to Low

    When  Press the sorting drop down
    And   choose Name "High to Low"
    Then  Products are sorted from "High to Low" successfully

    When  press Add to cart button for Sauce Labs Backpack
    Then  cart number changes to "1"

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
    ##################################################################################################
