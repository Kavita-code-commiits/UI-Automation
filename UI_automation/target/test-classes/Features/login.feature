@tag
Feature: Login to the application
  Here we are verifying login functionality
  
  @authorized
  Scenario: Authorized user should be able to login
    Given User launch chrome browser
    When User open web url "https://admin-demo.nopcommerce.com/"
    And Enters email as "admin@yourstore.com" and password as "admin"
    And Click on login button
    Then User should be redirected to home page having url as "https://admin-demo.nopcommerce.com/admin/"
    And user click on logout button
  
  @unauthorized
  Scenario Outline: Unauthorized user should not be able to login
    Given User launch chrome browser
    When User open web url "https://admin-demo.nopcommerce.com/"
    And Enters email as "<nameq>" and password as "<passwordq>"
    And Click on login button
    Then Validate error message obtained 
    

    Examples:
      | nameq              | passwordq |
      | 22e3@gmail.com | admon2   |
      | ddff@gamil.com   | admortn2 |
      |   |  |
      
