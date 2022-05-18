Feature: UPDATE operation for tables

  Background:
    Given connect to database for updating data

  Scenario: The user should update some fields of tables
    When send an update query
      | table             | condition                                                                  | first_column           | second_column          | third_column  |
      | masked_table1     | masked_nummer = 884797                                                       | 236                    | 5454                    | 767           |
      | masked_table2     | masked_nummer = 180815 and levr_nummer = 933598                              | 10                   | 20                   | 30          |
      | masked_table3     | masked_nummer = 708                                                          | 3                      | 3                      | 3             |
      | masked_table4     | masked_nummer = 448109 and begindatum = '01-06-21'                           | 10                     | 10                     | 10           |
      | masked_table5     | masked_nummer = 225 and VART_NASA_NUMMER = 86874                                  | 86874                  | 10                     | 10            |
    Then should see the correct results
      | table             | condition                                                                  | first_column          | second_column          | third_column   |
      | masked_table1     | masked_nummer = 884797                                                       | 236                    | 5454                    | 767           |
      | masked_table2     | masked_nummer = 180815 and levr_nummer = 933598                              | 10                   | 20                  | 30          |
      | masked_table3     | masked_nummer = 708                                                          | 3                      | 3                      | 3             |
      | masked_table4     | masked_nummer = 448109 and begindatum = '01-06-21'                           | 10                     | 10                     | 10           |
      | masked_table5     | masked_nummer = 225                                                               | 86870                  | 868                    | 10            |

