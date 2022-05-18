Feature: INVALID data inject to tables
  Background:
    Given connect to database for invalid data

  Scenario Outline: The DB tables should not permit invalid data
    When try to update "<table>" set "<data>" where "<condition>"
    Then should see the error state "<sqlstate>" code "<errorcode>" message "<message>"
    Examples:
      | table                  | condition                                                                 | data                                          | sqlstate | errorcode  | message                                   |
      | L0COLLI                | NUMMER = 225                                                              | null                                          | 42000    | 920        | ORA-00920: Ongeldige relationele operator |
#      | l0VERKOOPARTIKELEN     | nasa_nummer = 884797                                                      | This is a very long string bigger than limit  | 42000    | 905         | ORA-00905: Ontbrekend sleutelwoord |
#      | l0BASIS_INK_VWDEN_TVN  | cllo_nummer = 448109 and levr_nummer = 363770 and begindatum = '01-06-21' | null                                          | 42000    | 920         | ORA-00920: Ongeldige relationele operator.|


#  update l0COLLO_VAN_LEVERANCIER SET BREEDTE = 10000,  HOOGTE = 20000, LENGTE = 30000 where cllo_nummer = 180815 and levr_nummer = 933598
#  ORA-01438: Waarde is groter dan de voor deze kolom opgegeven maximale precisie.