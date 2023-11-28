#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@array
Feature: Array module 
	#@arraysinPython
	Scenario:ArraysinPython

	  Given GoTO DataHomePage
	  Given ClickOnArrayModule "Array"	
		Then Verify arraycurrentUrl "array/" and "module"
	
		Then ClickInArray "Arrays in Python"
		Then Verify arraycurrentUrl "array/" and "arrays-in-python/"
		
		Then ClickOnArrayTopic "Try Here"
		Then Add Python code "print you are here" "Try Here>>>"
	  Then GoTO ArrayPage and "/array/arrays-in-python/"
	  
	  Then ClickOnArrayTopic "Try Here"
		Then Add Python-CSV code "print you are here" "Try Here>>>"
		
#		Then ClickPractice "Practice Questions"
  #	Then Verify datacurrentUrl "array/" and "practice"
  	
  #	Then ClickPracticeTopic "Squares of  a Sorted Array"
  #	Then verify "question/4" in Common
  #	Then PracticeTest "print('Squares Of a sorted array')" result "Squares Of a sorted array" 	
  #Then GoTO ArrayPage and "/array/practice"  	
  
		Then GoTO ArrayPage and "/array"
		
	#@arraysUsingList	
   Scenario:Arrays-Using-List	   
		Then ClickInArray "Arrays Using List"
		Then Verify arraycurrentUrl "array/" and "arrays-using-list/"
		
		Then ClickPractice "Practice Questions"
  	Then Verify datacurrentUrl "array/" and "practice"
  
  	Then ClickPracticeTopic "Search the array"
  	Then verify "question/1" in Common
    Then PracticeWithDataTable
    | print you are here | alert |
    Then verifyBug "Error occured During Submission." "Not working Properly" "SubmitButtonOnEveryPracticePage" in common
  	
	
		Then GoTO ArrayPage and "/array"

  Scenario:Basic-Operations-in-Lists	   
	  Then ClickInArray "Basic Operations in Lists"
		Then Verify arraycurrentUrl "array/" and "basic-operations-in-lists/"
		
		Then ClickPractice "Practice Questions"
  	Then Verify datacurrentUrl "array/" and "practice"
  
		Then ClickPracticeTopic "Max Consecutive Ones"
  	Then verify "question/2" in Common
  	Then PracticeTest "print('hello')" result "hello"
		
		Then GoTO ArrayPage and "/array"

  Scenario:Applications-Of-Array	   
 
    Then ClickInArray "Applications of Array"
		Then Verify arraycurrentUrl "array/" and "applications-of-array/"
		
		Then ClickPractice "Practice Questions"
  	Then Verify datacurrentUrl "array/" and "practice"
  
		Then ClickPracticeTopic "Find Numbers with Even Number of Digits"
  	Then verify "question/3" in Common
  	Then PracticeTest "print you are here" result "alert"
		
	  Given GoTO DataHomePage

 #@signOut	
  #Scenario:SignOut
  #Given User Signing Off
  #Then VerifySignout "Logged out successfully"
#	Then Quit Driver
  