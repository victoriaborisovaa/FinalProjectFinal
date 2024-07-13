Feature: Product Filtering
  As a shopper
  I want to filter products on the e-commerce website
  So that I can easily find the items that match my preferences

  @Smoke
  Scenario: Filter Products by Name (A to Z)
    Given the user is on the product listing page
    When the user selects a specific filter from the filter options
    Then the user should see the filtered products

#  Scenario: Filter Products by Price (low to high)
#    Given the user is on the product listing page
#    When the user sets a price filter (low to high)
#    Then the user should see a list of products ordered from the lowest till the highest price
#    And all displayed products should have prices
#
#  Scenario: Clearing Filters
#    Given the user has applied filters on the product listing page
#    When the user clicks on the selected filter button
#    Then the user should see the full list of products
#    And no filters should be applied
#
#  Scenario: Persisting Filters on Navigation
#    Given the user has applied filters on the product listing page
#    When the user navigates to a different page and returns
#    Then the applied filters should persist
#    And the user should see the filtered list of products