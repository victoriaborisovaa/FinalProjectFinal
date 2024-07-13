Feature: Adding product to cart and completing order
  As a shopper
  I want to add product to the cart and complete the order
  So that I can purchase the selected item

  @Smoke

  Scenario: Add Item to the Cart and Complete the Order
    Given the user is on the Product page
    When the user clicks on the "Add to cart" button
    Then the user should see a confirmation message that the product has been added to the cart
    And the user should see the updated cart icon with the item count

    When the user clicks on the cart icon to view the cart
    Then the user should see the added product in the cart with the correct details

    When the user click on the "Checkout" button
    Then the user should be directed to the checkout page

    When the user provides valid shipping information
    And clicks the "Place Order" button
    Then the user should see an order confirmation message

