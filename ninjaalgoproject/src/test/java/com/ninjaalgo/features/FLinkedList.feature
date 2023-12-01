#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@linkedlist
Feature: Linked List module 
	@LinkedListSubMenu
	Scenario Outline:LinkedList 

	  Given GoTO DataHomePage
	  Given ClickOnArrayModule "Linked List"	
		Then Verify arraycurrentUrl "linked-list/" and "module"
	
		Then ClickInArray "<SubMenu>"
		Then Verify arraycurrentUrl "linked-list/" and "<url>"
		
		Then ClickOnArrayTopic "Try Here"
		Then Add Python code "print you are here" "Try Here>>>"
   
    Then GoTo SubMenu Page "/linked-list/" and "<url>" and logged status
     
	Examples:	
		| SubMenu	| url	|
		| Introduction | introduction/ |
		| Creating Linked LIst | creating-linked-list/ |
		| Types of Linked List | types-of-linked-list/ |
		| Implement Linked List in Python | implement-linked-list-in-python/ |
		| Traversal | traversal/ |
		| Insertion | insertion-in-linked-list/ |
		| Deletion | deletion-in-linked-list/ |
		

 #@signOut	
  #Scenario:SignOut
  #Given User Signing Off
  #Then VerifySignout "Logged out successfully"
#	Then Quit Driver
  