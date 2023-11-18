#Author: Meenakshi

@DataBug
Feature: Title of your feature
  databugreport
  Scenario: Data Bug reporting 
    Given User is on Home Page
    And Click SignIn "NinjaAlgo" "@Algo123"
    

  @registerCred
  Scenario Outline: RegisterCred
    Given Username "<name>" Password1 "<password1>" Password2 "<password2>"
    When Click "Register"
    Then verifyBug "<actual>" "<expected>" in common
    #Add "<actual>" "<expected>" in Log4j

    Examples: 
      | name  | password1 | password2 | actual | Expected |
      | name1 | passwor | passwor | password_mismatch:The two password fields didn’t match. | Password should be at least 8 character long |
      | NinjaAlgo | password  | password | password_mismatch:The two password fields didn’t match. | Username already exist |
  
 
  