#Code Details:
#Author Meenakshi Date: 6-Nov-2023

@openChrome
Feature: Open and Get Started dsalgoportal
  @chrome
  Scenario: For chrome browser
    Given open url with "chrome" browser
 #@firefox
   #Scenario: For firefox browser
   #Given open url with "firefox" browser
  @GetStarted
    Scenario: Get Started
    Given Click Get Started button
    Then Verify currentUrl "home" and "start"