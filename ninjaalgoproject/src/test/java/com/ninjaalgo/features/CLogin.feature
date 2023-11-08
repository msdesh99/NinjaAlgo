#Code Details:
#Author: Meenakshi Date: 6-Nov-2023

@loginPage
Feature: Open and Login on dsalgoportal
  @signIn
  Scenario:Clicking signIn
  Given Click SignIn
  
  @login
  Scenario Outline: Login Credentials
    Given Send Login "<name>" with password "<password>"
    Then  click Login Password Submit
    And   verify "<status>" in Common
		#And Quit Driver
  @valid
  Examples: Data for DSAlgo login
   | name  | password | status |
   | NinjaAlgo | @Algo123 | home |

  #@invalid 
 # Scenarios: Check -ve scenario
  #Examples: Invalid data for juice shop login
   #| name  | password | status |
   #| test1 | test123 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login |
   #
 