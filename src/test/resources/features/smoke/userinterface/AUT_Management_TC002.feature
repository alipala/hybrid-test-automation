#  Trigger different timers. Referential data from NASA is gathered every night by scheduled timer to be used in AIS. It is only for admin user.
#   Scenario Outline: The user triggers the timers manually instead of waiting till the next day
Feature: Trigger different timers
  As a admin user
  I want to trigger timer
  so that updating the referential data from NASA

  Background:
    Given Preparation steps of AIS_Management_TC002

  Scenario Outline: The user triggers the timers manually
    Given go to Timer page
    When try to trigger a "<Timer>" manually
    Then should see a started "<Popup>"
    Examples:
      |  Timer                                          |  Popup                 |
      |  Masked_timer_function1                         |  Masked_popup_message1 |
      |  Masked_timer_function2                         |  Masked_popup_message2 |
      |  Masked_timer_function3                         |  Masked_popup_message3 |