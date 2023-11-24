#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@dataSuite
Feature: DataStructure module
  @TimeComplexitySuite
  Scenario:IntroductionSuite
    Given ClickOnHomePage "Data Structures-Introduction"
 		Then Verify currentUrl "Data Structures-Introduction" and "module"
 		Then ClickInData "Time Complexity"
  	Then ClickOnDataTopic "Time Complexity"
  	Then Verify currentUrl "Data Structures-Introduction" and "time-complexity/"
  	Then ClickOnDataTopic "Practice Questions"
  	Then Verify currentUrl "Data Structures-Introduction" and "practice"
  	Then verifyBug "Empty Page" "Editor for Practice" in common
  		
  	