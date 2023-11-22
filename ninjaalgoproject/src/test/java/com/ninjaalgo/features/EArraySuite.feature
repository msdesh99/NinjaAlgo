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
		Then ClickOnArrayTopic "Try Here"
		#Then verify "tryEditor" in Common
		Then Add Python code "print you are here"
    Then User Signing Off
    Then VerifySignout "Logged out successfully"
  
		Then Quit Driver
		#Then Verify Python output "564 is Number is Not Found" 
		
#		Then GoTO ArrayPage and "/array/"
		
#	@arraysUsingListSuite	
#	Scenario:Arrays-Using-ListSuite	
#		Then ClickInArray "Arrays Using List"
#		Then Verify arraycurrentUrl "array/" and "arrays-using-list/"
#		Then GoTO ArrayPage and "/array/"
#		Then GoTO ArrayHomePage
#		