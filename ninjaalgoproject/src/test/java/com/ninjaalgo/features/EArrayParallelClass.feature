#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
#@arrayClassParallel
Feature: ArrayParallel module

  @arrayClass
  Scenario:ArrayClass
   Then ClickOnArrayModule "Array"	
		#Then Verify arraycurrentUrl "array/" and "module"
		Then ClickInArray "Arrays in Python"
		Then Verify arraycurrentUrl "array/" and "arrays-in-python/"
		Then ClickOnArrayTopic "Try Here"
		#Then verify "tryEditor" in Common
		Then Add Python code "print you are here" "Try Here>>>"
		Then GoTO ArrayPage and "/array/"
 	  Then GoTO DataHomePage
		Then Quit Driver
 