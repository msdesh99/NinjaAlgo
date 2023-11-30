#Author: swathi
#Date: Nov 27 2023

@graphmodule
Feature: Graphmodule

#Background: user Registered and logged  into HomePage
    #Given user Launch the Browser
    #When user open the Homepage of dsportal and click get started button
    #When user Navigate to Sign in button
    #When user enters the Valid Username
    #And enter Valid Password
    #And user click the login button
    #Given user is on Homepage

  @Graph
  Scenario: Open the Graphpage from homepage
    When user click on getstarted graph module
    Then graph page is opened
    Then click on graph Topics Covered
    When user clickon Tryhere button
    Then tryeditor page is displayed

  @graphPythonTryEditorValidSyntax
  Scenario Outline: Open the Implementation of Graph in Python page
    When user click on getstarted graph module
    Then graph page is opened
    Then click on graph Topics Covered
    When user clickon Tryhere button
    When user enters the code "<input>" in the graph page
    When user clicks on Run  on try editor page
  
    Then user should see the code output   
    Then user see the code output

    Examples: 
      | input          |
      | print('hello') |

  @GraphRepresentations
  Scenario: Open the GraphRepresentations  from homepage
    When user click on getstarted graph module
    Then graph page is opened
    Then click on graphRepresentations Topics Covered
    When user clickon Tryhere button
    Then tryeditor page is displayed

  #@graphRepresentationsPythonTryEditorInValidSyntax
  #Scenario Outline: Open the Implementation of Graph in Python page
    #When user click on getstarted graph module
    #Then graph page is opened
    #Then click on graphRepresentations Topics Covered
    #When user clickon Tryhere button
    #When user enters the code "<input>" in the graph page
    #When user clicks on Run  on try editor page
    #Then user see the code output
#
    #Examples: 
      #| input |
      #| int O |
      #| int n |

  @Practicequestions
  Scenario: open the Practice questions link
    When user click on getstarted graph module
    Then graph page is opened
    Then click on graphRepresentations Topics Covered
    Then click on practice questions link
    Then practice page will be displayed