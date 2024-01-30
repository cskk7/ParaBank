Feature: TestLogin
  Scenario: PTA-login
    Given user on loginpage
    When user enetered username
    And user entered password
    And user clicked submit
    Then user login successfully
#
  Scenario: PTA-logout
    Given user on homepage
    When user clicked logout
    Then user logout successfully