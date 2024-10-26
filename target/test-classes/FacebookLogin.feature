Feature: 
      Validate the Login Functionality in facebook app

  Scenario: 
       To validate the login functionality with invalid email and invalid password

    Given User have to be in Facebook login page
    And User can maximize the window
    When User enters the invalid email and invalid password
      | email           | password  |
      | abcd@gmail.com  | abcd@222  |
      | xyz@gmail.com   | Ttsdf@121 |
      | ezhil@gmail.com | Ezhil@321 |
    And User clicks login button
    Then User should be in the invalid credentials page

  Scenario: 
      To validate the login functionality with valid email and invalid password

    Given User have to be in Facebook login page
    And User can maximize the window
    When User enters the valid email and invalid password
      | email    | ajith2212@gmail.com |
      | password | Ajith@323           |
    And User clicks login button
    Then User should be in the invalid credentials page
