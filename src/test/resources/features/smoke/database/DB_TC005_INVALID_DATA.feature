Feature: INVALID data inject to tables
  Background:
    Given connect to database for invalid data

  Scenario Outline: The DB tables should not permit invalid data
    When try to update "<table>" set "<data>" where "<condition>"
    Then should see the error state "<sqlstate>" code "<errorcode>" message "<message>"
    Examples:
      | table          | condition                                                                      | data                                          | sqlstate | errorcode   | message       |
      | masked_table1  | masked_nummer = 225                                                            | null                                          | 42000    | 920         | ORA-0001: xxx |
      | masked_table2  | masked_nummer = 884797                                                         | This is a very long string bigger than limit  | 42000    | 905         | ORA-0002: xxx |
      | masked_table3  | masked_nummer = 448109 and masked_nummer = 363770 and masked_date = '01-06-21' | null                                          | 42000    | 920         | ORA-0003: xxx |
