#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@arraySuite
Feature: Array module

	@arraysinPythonSuite
	Scenario:ArraysinPythonSuite
   # Given open url with "chrome" browser
	 # Given open url with "firefox" browser
	 # Given open url with "edge" browser
	
	  Given ClickOnHomePage "Array"	
		Then Verify currentUrl "Array" and "module"
		Then ClickInArray "Arrays in Python"
		Then Verify currentUrl "Array" and "arrays-in-python/"
		Then ClickOnArrayTopic "Try Here"
		Then verify "tryEditor" in Common
		
	@arraysUsingListSuite	
	Scenario:Arrays-Using-ListSuite	
		Then ClickInArray "Arrays Using List"
		Then Verify currentUrl "Array" and "arrays-using-list/"
		