Feature: LoginFeature
  This feature deals with the login functionality of the application

  @Critical
  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the following details for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the user form page


  @NonCritical
  Scenario: Login with correct username and password
    Given I navigate to the login page

#  Scenario Outline: Login with correct username and password using scenario outline
#    Given I navigate to the login page
#    And I enter the <username> and <password>
#    And I click login button
#    Then I should see the user form page
#
#    Examples:
#      | username | password   |
#      | execute  | automation |
#      | admin    | admin      |
#      | test     | qa         |
#
#
#  Scenario: Login with correct username and password with email transformation
#    Given I navigate to the login page
#    And I enter the users email address as Email:admin
#    And I enter the following details for login
#      | username | password      |
#      | admin    | adminpassword |
#    And I click login button
#    Then I should see the user form page