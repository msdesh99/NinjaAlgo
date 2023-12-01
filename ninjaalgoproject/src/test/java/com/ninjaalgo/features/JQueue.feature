#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@queue
Feature: Linked List module 
	@QueueSubMenu
	Scenario Outline:LinkedList 

	  Given GoTO DataHomePage
	  Given ClickOnArrayModule "Queue"	
		Then Verify arraycurrentUrl "queue/" and "module"
	
		Then ClickInArray "<SubMenu>"
		Then Verify arraycurrentUrl "queue/" and "<url>"
		
		Then ClickOnArrayTopic "Try Here"
		Then Add Python code "print you are here" "Try Here>>>"
   
    Then GoTo SubMenu Page "/queue/" and "<url>" and logged status
     
	Examples:	
		| SubMenu	| url	|
		| Implementation of Queue in Python | implementation-lists/ |
		| Implementation using collections.deque | implementation-collections/ |
		| Implementation using array | Implementation-array/ |
		| Queue Operations | QueueOp/ |

 #@signOut	
  #Scenario:SignOut
  #Given User Signing Off
  #Then VerifySignout "Logged out successfully"
#	Then Quit Driver
  