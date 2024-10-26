Feature:
      Flipkart products page
Scenario:
    To validate the Electronics section and add a product to cart
Given User have to be in flipkart homepage
When User have to click electronics section 
And User mouse hovering to Laptop Accessories and click the Router
And User have to choose a particular product
And User redirects to a new window
And User click the add to cart button
Then the product should get added to a cart
    