#Code Details:
#Author Meenakshi Date: 6-Nov-2023

@openfirefox
Feature: Open and Get Started dsalgoportal
  @firefox
   Scenario: For firefox browser
   Given open url with "firefox" browser
  @GetStarted
    Scenario: Get Started
    Given Click Get Started button
    Then Verify currentUrl "home" and "start"