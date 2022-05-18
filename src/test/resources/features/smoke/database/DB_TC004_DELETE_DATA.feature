Feature: DELETE operation for tables

  Background:
    Given connect to database for deleting data

  Scenario: The user should delete data of an artikel
    When send a delete query
      | table                       | condition              |
      | l0COLLO_VAN_LEVERANCIER     | cllo_nummer = 501637   |
      | l0VERKOOPARTIKELEN          | nasa_nummer = 86775   |
    Then should not see the deleted rows anymore
      | table                       | condition              |
      | l0COLLO_VAN_LEVERANCIER     | cllo_nummer = 501637    |
      | l0VERKOOPARTIKELEN          | nasa_nummer = 86775   |

