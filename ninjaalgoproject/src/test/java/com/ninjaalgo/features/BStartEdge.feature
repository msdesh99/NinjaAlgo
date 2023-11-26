#Code Details:
#Author Meenakshi Date: 6-Nov-2023

@openEdge
Feature: Open and Get Started dsalgoportal
#@chrome
  #Scenario: For chrome browser
    #Given open url with "chrome" browser
  @edge
    Scenario: For edge browser
   Given open url with "edge" browser
  
  @GetStarted
    Scenario: Get Started
    Given Click Get Started button
    Then Verify currentUrl "home" and "start"