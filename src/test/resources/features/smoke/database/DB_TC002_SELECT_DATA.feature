Feature: SELECT operation for tables

  Background:
    Given connected to database for reading data

  Scenario: The user should read data from table
    When select all from table with a condition
      | table                         | where                                                                         |
      | p1i005.l0VERKOOPARTIKELEN     | nasa_nummer = 884798                                                          |
      | p1i005.l0COLLO_VAN_LEVERANCIER| cllo_nummer = 534 and levr_nummer = 506600                                    |
      | p1i005.l0PALLET_VAN_LEVCRS    | cllo_nummer = 1821 and levr_nummer = 320200 and begindatum = '12-08-96'       |
      | p1i005.l0BASIS_INK_VWDEN_TVN  | cllo_nummer = 448109 and levr_nummer = 363770 and begindatum = '30-09-18'     |
      | p1i005.L0COLLI                | NUMMER = 225                                                                  |
      | p1i005.L0ART_IN_FRM_TVN       | vart_nasa_nummer = 795147 and vkfr_nummer = 6 and BEGINDATUM = '29-01-18'     |
      | p1i005.L0VERKOOPARTIKELEN     | nasa_nummer = 70767                                                           |
    Then should see the correct results of select
      | first_column | second_column | third_column             | fourth_column           | fifth_column          |
      |            |  884798    | 1359063                | Hawaii shirt man L   | hawaii shirt man l  |
      | 534        |  506600    | 1995-10-30 00:00:00    | 2022-04-22 00:54:24  | 1995-10-27 00:00:00 |
      | 1821       |  320200    | 1996-08-12 00:00:00    | 2022-10-20 00:00:00  | 3                   |
      | 448109     |  363770    | 2018-09-30 00:00:00    |  DC                  | 5.533               |
      | 225        |  S         | duizendblad            | 86870                |  868                |
      | 795147     |  6         | 2018-01-29 00:00:00    | 0                    |  0                  |
      |            |  70767     | 691155                 | Lavendel echte       |  lavendel echte     |


