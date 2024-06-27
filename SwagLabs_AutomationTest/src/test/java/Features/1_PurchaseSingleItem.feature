Feature: Complete Purchase of Single Item

  Scenario: User try to buy products after using sort from A to Z
    Given Open the Swag Labs Website
    When  Enter "standard_user" in the username field on Login Screen

    And   Enter "secret_sauce" in the password field on Login Screen
    And   Press the "login" button
    Then  Successful Login

#    When  Press the sorting drop down
#    And   choose "Name (A to Z)"
#    Then  Products are sorted from A to Z successfully
#
#    When  press Add to cart button for Sauce Labs Backpack
#    Then  cart number increases by 1
#
#    When  Press on the "cart" icon on the top right of the page
#    Then  Redirection to the cart page
#
#    When  Press Check out button
#    Then  Redirection to Checkout: Your Information
#
#    When  Insert first name "Mohamed" , Last name "Elattar" and Postal code "1234"
#    And   Click Contiune
#    Then  Redirection to Checkout: Overview
#    And   Check price 29.99
#
#    When  Press "Finish"
#    Then  Check Checkout: Complete!
#    And  check Thank you for your order!
#
