#Code Details:
#Author: Meenakshi Dated 7-Nov-2023

@module
Feature: Home page of DSalgo
  @DataStructure
  Scenario:Get Data Structure module
    Given User Loged in and Home page is displayed
  	Then Click "Data Structures-Introduction"
 		Then Verify currentUrl "Data Structures-Introduction" and "module"
  #@Topics
  #Scenario:Topic covered section
    #Given User Loged in and on data structure introduction page
    #Then Click on "Time Complexity"
