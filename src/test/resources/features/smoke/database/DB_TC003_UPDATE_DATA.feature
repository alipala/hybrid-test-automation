Feature: UPDATE operation for tables

  Background:
    Given connect to database for updating data

  Scenario: The user should update some fields of tables
    When send an update query
      | table                  | condition                                                                  | first_column           | second_column          | third_column  |
      | l0VERKOOPARTIKELEN     | nasa_nummer = 884797                                                       | 236                    | 5454                    | 767           |
      | l0COLLO_VAN_LEVERANCIER| cllo_nummer = 180815 and levr_nummer = 933598                              | 10                   | 20                   | 30          |
#      | l0PALLET_VAN_LEVCRS    | cllo_nummer = 708                                                          | 3                      | 3                      | 3             |
#      | l0BASIS_INK_VWDEN_TVN  | cllo_nummer = 448109 and begindatum = '01-06-21'                           | 10                     | 10                     | 10           |
#      | L0COLLI                | NUMMER = 225 and VART_NASA_NUMMER = 86874                                  | 86874                  | 10                     | 10            |
    Then should see the correct results
      | table                  | condition                                                                  | first_column          | second_column          | third_column   |
      | l0VERKOOPARTIKELEN     | nasa_nummer = 884797                                                       | 236                    | 5454                    | 767           |
      | l0COLLO_VAN_LEVERANCIER| cllo_nummer = 180815 and levr_nummer = 933598                              | 10                   | 20                  | 30          |
#      | l0PALLET_VAN_LEVCRS    | cllo_nummer = 708                                                          | 3                      | 3                      | 3             |
#      | l0BASIS_INK_VWDEN_TVN  | cllo_nummer = 448109 and begindatum = '01-06-21'                           | 10                     | 10                     | 10           |
#      | L0COLLI                | NUMMER = 225                                                               | 86870                  | 868                    | 10            |

