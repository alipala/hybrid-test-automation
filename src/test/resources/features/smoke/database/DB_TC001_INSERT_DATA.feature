Feature: INSERT INTO operation for tables

  Background:
    Given connected to database for insert into

  Scenario Outline: The user should create an artikel
    When run the insert into query
    Then should see the results of select operation
    Examples:
      |  table |
