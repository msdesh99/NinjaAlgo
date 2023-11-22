#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
#@dataParallelClass
Feature: DataParallel module
  @dataClass
  Scenario:DataClass 
    #Given GetStarted
    #Then SignIn   
    #Given Login "NinjaAlgo" password "@Algo123"
    #Then  Submit
    Given verify "home"
    Given ClickOnDataModule "Data Structures-Introduction"   
 		Then verify "data-structures-introduction/"
 		Then ClickInData "Time Complexity"
 		Then ClickOnDataTopic "Time Complexity"
  	Then verify "data-structures-introduction/time-complexity/"
  	Then ClickOnDataTopic "Practice Questions"
  	Then verify "data-structures-introduction/practice"
	  Then Quit Driver