#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@array
Feature: Array module 
	@arraysinPython
	Scenario:ArraysinPython
   # Given open url with "chrome" browser
	 # Given open url with "firefox" browser
	 # Given open url with "edge" browser
	  	
	  Given GoTO DataHomePage
	  Given ClickOnArrayModule "Array"	
		Then Verify arraycurrentUrl "array/" and "module"
		Then ClickInArray "Arrays in Python"
		Then Verify arraycurrentUrl "array/" and "arrays-in-python/"
		Then ClickOnArrayTopic "Try Here"
		#Then verify "tryEditor" in Common
		Then Add Python code "print you are here"
		Then GoTO ArrayPage and "/array/"
		
	@arraysUsingList	
   Scenario:Arrays-Using-List	   
    Given ClickOnArrayModule "Array"	
		Then Verify arraycurrentUrl "array/" and "module"
		Then ClickInArray "Arrays Using List"
		Then Verify arraycurrentUrl "array/" and "arrays-using-list/"
		Then GoTO ArrayPage and "/array/"
		Then GoTO ArrayHomePage
	
 @signOut	
  Scenario:SignOut
  Given User Signing Off
  Then VerifySignout "Logged out successfully"
	Then Quit Driver
  