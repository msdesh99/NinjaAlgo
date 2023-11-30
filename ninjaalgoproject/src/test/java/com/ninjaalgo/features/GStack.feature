@stack
Feature: StackPage

  #Background: user Registered and logged In into HomePage
#
  #Background: user Registered and logged In into HomePage
#
    #Given user Launch the Browser
    #When user open the Homepage of dsportal and click get started button
    #When user Navigate to Sign in button
    #When user enters the Valid Username
    #And enter Valid Password
    #And user click the login button
    #Given user is on Homepage


  @stackPage
  Scenario: Open the Stack page from the Data-Structures Dropdown
  	Given GoTO DataHomePage    
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page


  @stackTryHerePage

  Scenario: Redirect to try editor on Implementation of Stack in Python page
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user click on Implementation of Stack

    When user click the try here button on stack page

    Then user should be redirected to the try editor stack page

  @stackPythonTryEditorValidSyntax

  Scenario Outline: Open the Implementation of Stack in Python page
    #When user click on dropdown on get started page
    #When user click the stack button
    #Then User should redirected to Stack page
#
    #When user click on Implementation of Stack
#
    #When user click the try here button on stack page
#
    #Then user should be redirected to the try editor stack page

    When user enters the code "<input>" in the stack page

    When user clicks on Run button on try editor page

    Then user should see the code output

    Examples:

      | input          |

      | print('hello') |


  @stackPythonTryEditorInvalidSyntax

  Scenario Outline: Display Syntx Error Message
    #When user click on dropdown on get started page
    #When user click the stack button
    #Then User should redirected to Stack page
#
    #When user click on Implementation of Stack
#
    #When user click the try here button on stack page
#
    #Then user should be redirected to the try editor stack page
#
    When user enters the code "<input>" in the stack page

    When user clicks on Run button on try editor page

    Then user should get an Syntax error message

    Then user clicks ok Button on stack syntax error on stack try editor page

    Examples:

      | input |

      | int O |

      | int n |

  @stackOperation

  Scenario: User opens editor on Stack operations page
    Given GoTO DataHomePage   
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user clicks on Stack Operations

    Then user should land on Stack Operations


  @stackOperationTryEditor

  Scenario: User opens editor on Stack operations page and get output
    Given GoTO DataHomePage   
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user clicks on Stack Operations

    Then user should land on Stack Operations

    When user click the try here button on stack page

    Then user will land on TryEditor page on stack page

    When user enters the code "print('hello')" in the stack page

    When user clicks on Run button on try editor page

    Then user should see the code output

  @stackApplication

  Scenario: User opens editor on Stack Application page
    Given GoTO DataHomePage   
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user clicks on Stack Application

    Then user should land on Stack Application


  @stackApplcationTryEditor

  Scenario: User opens editor on Stack Application page and get output
    Given GoTO DataHomePage   
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user clicks on Stack Application

    Then user should land on Stack Application

    When user click the try here button on stack page

    Then user will land on TryEditor page on stack page

    When user enters the code "print('hello')" in the stack page

    When user clicks on Run button on try editor page

    Then user should see the code output

  @stackpracticeHere
  Scenario: Open the practice here page
    Given GoTO DataHomePage   
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user click on Implementation of Stack

    When user clicks to the Practice Questions Button on Stack page

    Then user redirected to the practice questions page on stack page

  @stackPageSignOut
  Scenario: Open the practice here page and sign out
    Given GoTO DataHomePage   
    When user click on dropdown on get started page
    When user click the stack button
    Then User should redirected to Stack page

    When user click on Implementation of Stack

    When user clicks to the Practice Questions Button on Stack page

    Then user redirected to the practice questions page on stack page

    Then user will Sign out from stack page
    
    Then user will see logout message after signing out

  #@stackPageSignOutMsg
  #Scenario: Open the practice here page, sign out and get logged out message
    #Given GoTO DataHomePage   
    #When user click on dropdown on get started page
    #When user click the stack button
    #Then User should redirected to Stack page
#
    #When user click on Implementation of Stack
#
    #When user clicks to the Practice Questions Button on Stack page
#
    #Then user redirected to the practice questions page on stack page
#
    #Then user will Sign out from stack page
    #Then user will see logout message after signing out