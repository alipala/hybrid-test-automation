Feature: SELECT operation for tables

  Background:
    Given connected to database for reading data

  Scenario: The user should read data from table
    When select all from table with a condition
      | table             | where               |
      | p1i005.table1     | masked_condition1   |
      | p1i005.table2     | masked_condition2   |
      | p1i005.table3     | masked_condition3   |
      | p1i005.table4     | masked_condition4   |
      | p1i005.table5     | masked_condition5   |
      | p1i005.table6     | masked_condition6   |
      | p1i005.table7     | masked_condition7   |
    Then should see the correct results of select
      | first_column  | second_column | third_column              | fourth_column           | fifth_column        |
      |               |  884798       | 1359063                   | Hawaii shirt man L      | hawaii shirt man l  |
      | 534           |  506600       | 1995-10-30 00:00:00       | 2022-04-22 00:54:24     | 1995-10-27 00:00:00 |
      | 1821          |  320200       | 1996-08-12 00:00:00       | 2022-10-20 00:00:00     | 3                   |
      | 448109        |  363770       | 2018-09-30 00:00:00       |  DC                     | 5.533               |
      | 225           |  S            | duizendblad               | 86870                   |  868                |
      | 795147        |  6            | 2018-01-29 00:00:00       | 0                       |  0                  |
      |               |  70767        | 691155                    | Lavendel echte          |  lavendel echte     |


