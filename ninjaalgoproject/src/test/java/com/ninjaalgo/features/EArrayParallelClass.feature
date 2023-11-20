#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
#@arrayClassParallel
Feature: ArrayParallel module

  @arrayClass
  Scenario:ArrayClass
    Given Click Get Started button
    Then Click SignIn   
    Given Send Login "NinjaAlgo" with password "@Algo123"
    Then  click Login Password Submit
    And   verify "home" in Common
		#And Quit Driver
    #Then Verify currentUrl "home" and "start"
   Given ClickOnArrayModule "Array"	
		Then Verify arraycurrentUrl "array/" and "module"
		Then ClickInArray "Arrays in Python"
		Then Verify arraycurrentUrl "array/" and "arrays-in-python/"
		Then ClickOnArrayTopic "Try Here"
		#Then verify "tryEditor" in Common
		Then Add Python code "print you are here"
		Then GoTO ArrayPage and "/array/"
 	  Then GoTO DataHomePage
		Then Quit Driver
 