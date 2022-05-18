Feature: DELETE operation for tables

  Background:
    Given connect to database for deleting data

  Scenario: The user should delete data of an article
    When send a delete query
      | table             | condition              |
      | masked_table1     | masked_nummer = 501637   |
      | masked_table2     | masked_nummer = 86775   |
    Then should not see the deleted rows anymore
      | table             | condition              |
      | masked_table1     | masked_nummer = 501637    |
      | masked_table2     | masked_nummer = 86775   |

