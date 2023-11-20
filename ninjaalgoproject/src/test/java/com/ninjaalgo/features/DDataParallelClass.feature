#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
#@dataParallelClass
Feature: DataParallel module

  @dataClass
  Scenario:DataClass 
    Given Click Get Started button
    Then Click SignIn   
    Given Send Login "NinjaAlgo" with password "@Algo123"
    Then  click Login Password Submit
    And   verify "home" in Common
		#And Quit Driver
    Then Verify currentUrl "home" and "start"
    #Given ClickOnHomePage "Data Structures-Introduction"
    Given ClickOnDataModule "Data Structures-Introduction"   
 		Then Verify currentUrl "Data Structures-Introduction" and "module"
 		Then ClickInData "Time Complexity"
  	Then ClickOnDataTopic "Time Complexity"
  	Then Verify currentUrl "Data Structures-Introduction" and "time-complexity/"
  	Then ClickOnDataTopic "Practice Questions"
  	Then Verify currentUrl "Data Structures-Introduction" and "practice"
	  Then Quit Driver
