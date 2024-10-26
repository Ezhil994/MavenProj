Feature: 
      Validate the Adactin Login Functionality

  Scenario: 
       To validate the login functionality with invalid username and invalid password

    Given User have to be in Login page
    And User maximize the window
    When User have to enter valid username and invalid password
      | Ajaykumar | Ajay@123 |
      | Ezhil     | Ezhil@33 |
      | Uday      | Uday&88  |
      | Peter     | Peter445 |
    And User have to click login button
    Then User have to receives a invalid credentials message

  Scenario: 
       To validate the login functionality with valid username and valid password

    Given User have to be in Login page
    And User maximize the window
    When User have to enter valid username and valid password
      | Ezhiljerry |
      | GBMHDF     |
    And User have to click login button
    Then User have to lands on the Adactin home page
