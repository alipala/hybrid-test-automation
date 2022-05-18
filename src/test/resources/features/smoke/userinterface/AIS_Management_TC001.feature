Feature: Create a new document type
  As a super user
  I want to add new document type
  so that adding to the email

  Background:
    Given Preparation steps of AIS_Management_TC001

  Scenario: The user adds new document type
    Given go to Document Types page
    When add document
    Then should see new document in the list