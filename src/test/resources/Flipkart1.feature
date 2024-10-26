Feature: 
         To validate Flipkart homepage
         
 Background:
          Given User have to be in flipkart homepage
@smoke
  Scenario: 
         To validate the product search text box and add a product to cart

   
    When User have to enter product name and press enter button
    And User have to select the product
    And User have to enter pincode to check the availability
    And User have to click add to cart button
    Then The product should get added to a cart
@Regression
  Scenario: 
       To validate the product search functionality by searching a particular product

    
    When User have to enter product name "iphone" and press enter button
    Then User have to check the products list
  @smoke @sanity  
  Scenario:
      To validate all the elements present in bottom of home page
      And User have to scrolldown the page to bottom
      When User have to click the links in the bottom of home page
      Then User should get the related screen of the particular link
