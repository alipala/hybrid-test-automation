Feature: Authentication
  As a user
  I want to login to the AIS
  so that I can doing necessary operations

  Background: The user should be at login page
    Given go to url "/AIS/Login.aspx"

  Scenario Outline: The user should not login with invalid credentials
    When provide invalid credentials "<username>", "<password>"
    Then should see "<message>" error
    Examples:
      | username        | password  |   message                       |
      | pnl00112        | WrongPass |   Invalid username or password. |
      |                 |           |   Invalid username or password. |

  Scenario Outline: The user should login with valid credentials
    When provide valid credentials "<Username>", "<Password>"
    Then should see the page title "Briefingsvoortgang Monitor"
    Examples:
      | Username       | Password  |
      | pnl0q30z       | Test@1234 |

