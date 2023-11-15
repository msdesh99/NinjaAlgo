#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@data
Feature: DataStructure module
  @TimeComplexity
  Scenario:Introduction
  Given ClickOnHomePage "Data Structures-Introduction"
 		Then Verify currentUrl "Data Structures-Introduction" and "module"
 		Then ClickInData "Time Complexity"
  	Then ClickOnDataTopic "Time Complexity"
  	Then Verify currentUrl "Data Structures-Introduction" and "time-complexity/"
  	Then ClickOnDataTopic "Practice Questions"
  	Then Verify currentUrl "Data Structures-Introduction" and "practice"
  	