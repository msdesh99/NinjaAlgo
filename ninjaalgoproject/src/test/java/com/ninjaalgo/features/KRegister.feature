#Author: Meenakshi

@registerBug
Feature: Title of your feature
  @register
  Scenario: Bug reporting 
    Given User is on Home Page
    And Click register
  
  @registerCred
  Scenario: RegisterCred
   Given Username "name1" Password1 "passwor" Password2 "passwor"
    When Click "Register"
    Then verifyBug "password_mismatch:The two password fields didn’t match." "Password should be at least 8 character long" "register" in common
    
    Given Username "NinjaAlgo" Password1 "password" Password2 "password"
    When Click "Register"
    Then verifyBug "password_mismatch:The two password fields didn’t match." "Username already exist" "register" in common
 
  
   @dropdown  
   Scenario: dropdownmenu
    Then GoTO DataHomePage   
    Then Click SignIn    
    And Send Login "NinjaAlgo" with password "@Algo123"
    And  click Login Password Submit
    Then verify "home" in Common    
    Then Select DropDown
 		Then Click Header
   
   #Then Verify currentUrl "Data Structures-Introduction" and "module"
   
  