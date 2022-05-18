Feature: Test the csv file uploading functionality

  Scenario: The user should upload csv file
    Given the url
    When try to upload file
    Then I see success message