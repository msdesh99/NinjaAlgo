#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@linkedlist
Feature: Array module 
	@linkedListIntroduction
	Scenario:LinkedList-Introduction
   # Given open url with "chrome" browser
	 # Given open url with "firefox" browser
	 # Given open url with "edge" browser
	  	
	  Given GoTO DataHomePage
	  Given ClickOnArrayModule "Linked List"	
		Then Verify arraycurrentUrl "linked-list/" and "module"
		
		Then ClickInArray "Introduction"
		Then Verify arraycurrentUrl "linked-list/" and "introduction/"
		
		Then ClickOnArrayTopic "Try Here"
		Then Add Python code "print you are here" "Try Here>>>"
		Then GoTO ArrayPage and "/linked-list/introduction/"
    
    Then ClickPractice "Practice Questions"
  	Then Verify datacurrentUrl "linked-list/" and "practice"
    Then verifyBug "Empty Page" "On Editor of each Practice page" "Linked List" in common
    
		Then GoTO ArrayPage and "/linked-list"
		
		#Then GoTO ArrayPage and "/linked-list/introduction"
		#Given GoTO DataHomePage
		
#	@CreatingLinkedList	
  Scenario:Creating-Linked-LIst	   
  	Then ClickInArray "Creating Linked LIst"
  	Then Verify arraycurrentUrl "linked-list/" and "creating-linked-list/"
#		Then ClickOnArrayTopic "Try Here" 
#		Then Add Python code "print you are here" "Try Here>>>"
#		
		Then GoTO ArrayPage and "/linked-list"

	Scenario:Types-Of-Linked-List
 	  Then ClickInArray "Types of Linked List"
		Then Verify arraycurrentUrl "linked-list/" and "types-of-linked-list/"
#		Then ClickOnArrayTopic "Try Here"
#		Then Add Python code "print you are here" "Try Here>>>"
#		
		Then GoTO ArrayPage and "/linked-list"
#
	Scenario:Implement-Linked-List-in-Python
    Then ClickInArray "Implement Linked List in Python"
		Then Verify arraycurrentUrl "linked-list/" and "implement-linked-list-in-python/"
#		Then ClickOnArrayTopic "Try Here"
#		Then Add Python code "print you are here" "Try Here>>>"
#		
		Then GoTO ArrayPage and "/linked-list"
#
	Scenario:Traversal-Linked_List
    Then ClickInArray "Traversal"
		Then Verify arraycurrentUrl "linked-list/" and "traversal/"
#		Then ClickOnArrayTopic "Try Here"
#		Then Add Python code "print you are here" "Try Here>>>"
#		
  	Then GoTO ArrayPage and "/linked-list"
#
	Scenario:Insertion-In-LInked_List
    Then ClickInArray "Insertion"
  	Then Verify arraycurrentUrl "linked-list/" and "insertion-in-linked-list/"
#		Then ClickOnArrayTopic "Try Here"
#		Then Add Python code "print you are here" "Try Here>>>"
#		
		Then GoTO ArrayPage and "/linked-list"
#
 	Scenario:Deletion-In-LInked_List
    Then ClickInArray "Deletion"
		Then Verify arraycurrentUrl "linked-list/" and "deletion-in-linked-list/"
#		Then ClickOnArrayTopic "Try Here"
#		Then Add Python code "print you are here" "Try Here>>>"
#		
#		#Then GoTO ArrayPage and "/linked-list"
		Then GoTO DataHomePage
#		


#	
 #@signOut	
  #Scenario:SignOut
  #Given User Signing Off
  #Then VerifySignout "Logged out successfully"
#	Then Quit Driver
  