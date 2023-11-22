#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@dataarrayParallel
Feature: DataparallelSce module

  @dataParallelSce
  #@TimeComplexitySuite
  Scenario:dataparallelsce1
    #Given Click Get Started button
    #Then Click SignIn   
    #Then Send Login "NinjaAlgo" with password "@Algo123"
    #Then  click Login Password Submit
    #And   verifyparallel "home" in Common
#		#And Quit Driver
   # Then Verify currentUrl "home" and "start"
    #Given ClickOnHomePage "Data Structures-Introduction"
    Then ClickOnDataModule "Data Structures-Introduction"   
 		Then Verify currentUrl "Data Structures-Introduction" and "module"
 		Then ClickInData "Time Complexity"
  	Then ClickOnDataTopic "Time Complexity"
  	Then Verify currentUrl "Data Structures-Introduction" and "time-complexity/"
  	Then ClickOnDataTopic "Practice Questions"
  	Then Verify currentUrl "Data Structures-Introduction" and "practice"
	  Then GoTO DataHomePage

  @arrayParallelSce
  Scenario:arrayparallelsce1
    #Given Click Get Started button
    #Then Click SignIn   
    #Then Send Login "NinjaAlgo" with password "@Algo123"
    #Then  click Login Password Submit
   # And   verify "home" in Common
    Then ClickOnArrayModule "Array"	
		Then Verify arraycurrentUrl "array/" and "module"
	  Then ClickInArray "Arrays in Python"
		Then Verify arraycurrentUrl "array/" and "arrays-in-python/"
		
   	Then ClickOnArrayTopic "Try Here"
		Then Add Python code "print you are here"
 		Then GoTO ArrayPage and "/array/"
 	  Then GoTO DataHomePage
 		
 	
 