#Code Details:
#Author: Meenakshi Dated 7-Nov-2023
@data
Feature: DataStructure module
  @TimeComplexity
  Scenario:Introduction
  Given ClickOnDataModule "Data Structures-Introduction"
 		Then Verify datacurrentUrl "data-structures-introduction/" and "module"
 		Then Select DropDown
 		Then Click Header
 		
 		Then ClickInData "Time Complexity"
  	Then ClickOnDataTopic "Time Complexity"
  	Then Verify datacurrentUrl "data-structures-introduction/" and "time-complexity/"
  	Then Select DropDown 	
  	  	Then Click Header
  	
  	Then ClickOnDataTopic "Practice Questions"
  	Then Verify datacurrentUrl "data-structures-introduction/" and "practice"
  	Then Select DropDown
  	Then Click Header
  	
  	
 