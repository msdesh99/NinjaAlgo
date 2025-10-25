#Author: swathi
#Date: Nov 28 2023
@treemodule
Feature: Treemodule

  #Background: user Registered and logged  into HomePage
    #Given user Launch the Browser
    #When user open the Homepage of dsportal and click get started button
    #When user Navigate to Sign in button
    #When user enters the Valid Username
    #And enter Valid Password
    #And user click the login button
    #Given user is on Homepage
#
  #
 # @OverviewofTree
  Scenario: Open the treepage from homepage
  When user click on getstarted tree module
  Then tree page is opened
  Then click on overviewofTrees
  When user clickon Tryhere button
  Then tryeditor page is displayed
  
  #@treePythonTryEditorValidSyntax
  #Scenario Outline: Open the Implementation of Tree in Python page
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on overviewofTrees
  #When user clickon Tryhere button
  #When user enters the code "<input>" in the graph page
  #When user clicks on Run  on try editor page
  #Then user see the code output
  #
  #Examples:
  #| input          |
  #| print('hello') |
  #
  #@Termimologies
  #Scenario: Open the Terminologies from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on Terminologies
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #
  #@treePythonTryEditorValidSyntax
  #Scenario Outline: Open the Implementation of Tree in Python page
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on Terminologies
  #When user clickon Tryhere button
  #When user enters the code "<input>" in the graph page
  #When user clicks on Run  on try editor page
  #Then user see the code output
  #
  #Examples:
  #| input         |
  #| print('text') |
  #
  #@TypesofTrees
  #Scenario: Open the Types of Trees from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on Types of Trees
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #
  #@treePythonTryEditorValidSyntax
  #Scenario Outline: Open the Implementation of Tree in Python page
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on Types of Trees
  #When user clickon Tryhere button
  #When user enters the code "<input>" in the graph page
  #When user clicks on Run  on try editor page
  #Then user see the code output
  #
  #Examples:
  #| input         |
  #| print('text') |
  
  #@TreeTraversals
  #Scenario: Open the Types of Trees from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on Tree Traversals
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #
  #@treePythonTryEditorValidSyntax
  #Scenario Outline: Open the Implementation of Tree in Python page
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on  Tree Traversals
  #When user clickon Tryhere button
  #When user enters the code "<input>" in the graph page
  #When user clicks on Run  on try editor page
  #Then user see the code output
  #
  #Examples:
  #| input         |
  #| print('text') |
  #
  #@Traversalsillustration
  #Scenario: Open the Types of Trees from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on traversal illustrations
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #
  #@BinaryTrees
  #Scenario: Open the Types of Trees from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on binarytrees
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #
  #@Typesofbinarytrees
  #Scenario: Open the Types of Trees from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on types of binary trees
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #
  #@treePythonTryEditorValidSyntax
  #Scenario Outline: Open the Implementation of Tree in Python page
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on types of binary trees
  #When user clickon Tryhere button
  #When user enters the code "<input>" in the graph page
  #When user clicks on Run  on try editor page
  #Then user see the code output
  #
  #Examples:
  #| input         |
  #| print('text') |
  #
  #@Implementaioninpython
  #Scenario: Open the Types of Trees from treepage
  #When user click on getstarted tree module
  #Then tree page is opened
  #Then click on implementationinpython
  #When user clickon Tryhere button
  #Then tryeditor page is displayed
  #@ImplementaionofBST
  #Scenario: Open the Types of Trees from treepage
    #When user click on getstarted tree module
    #Then tree page is opened
    #Then click on implementationofBST
    #When user clickon Tryhere button
    #Then tryeditor page is displayed
#
  #@treePythonTryEditorValidSyntax
  #Scenario Outline: Open the Implementation of Tree in Python page
    #When user click on getstarted tree module
    #Then tree page is opened
    #Then click on implementationofBST
    #When user clickon Tryhere button
    #When user enters the code "<input>" in the graph page
    #When user clicks on Run  on try editor page
    #Then user see the code output
#
    #Examples: 
      #| input         |
      #| print('text') |
#
  #@PracticeQuestions
  #Scenario: implementation of practicequestions from treepage
    #When user click on getstarted tree module
    #Then tree page is opened
    #Then click on implementationofBST
    #Then click on practicequestions
    #Then tryeditor page is displayed