#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@arraySuite
Feature: Array module

	@arraysinPythonSuite
	Scenario:ArraysinPythonSuite
   # Given open url with "chrome" browser
	 # Given open url with "firefox" browser
	 # Given open url with "edge" browser
	
	  Given ClickOnArrayModule "Array"	
		Then Verify arraycurrentUrl "array/" and "module"
		Then ClickInArray "Arrays in Python"
		Then Verify arraycurrentUrl "array/" and "arrays-in-python/"
		
		Then ClickPractice "Practice Questions"
  	Then Verify datacurrentUrl "array/" and "practice"
  
  	Then ClickPracticeTopic "Search the array"
  	Then verify "question/1" in Common
    Then PracticeWithDataTable
    | print you are here | alert |
    |   print second line  | alert two |
    
    Then verifyBug "Error occured During Submission." "Not working Properly" "SubmitButtonOnEveryPracticePage" in common
  	

    Then User Signing Off
    Then VerifySignout "Logged out successfully"
  
		Then Quit Driver
