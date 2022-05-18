Feature: INSERT INTO operation for tables

  Background:
    Given connected to database for insert into

  Scenario Outline: The user should create an artikel
    When run the insert into query
    Then should see the results of select operation
    Examples:
      |  table |




# SELECT * FROM NASA_VERKOOPARTIKELEN where nasa_nummer = 884798
#     AIS                        | DATABASE MATCHED DATA
#  1. NASA_NUMMER
#  2. Afmetingen (b-d-h)         | BREEDTE, DIEPTE, HOOGTE
#  3. Ingangsdatum               | DATUM_1E_VERKOOP
#  4. Lange omschrijving         | LANGE_OMSCHR
#  5. Kassabon omschrijving      | KASSABON_OMSCHR
#  6. Referentie artikel         | REFERENTIE_AFZET_ARTIKEL
#  7. Minimum bewaar temperatuur | MIN_STORAGE_AND_HANDLING_TEMP
#  8. Maximum bewaar temperatuur | MAX_STORAGE_AND_HANDLING_TEMP
#  9. Referentie factor          | REFERENTIE_AFZET_FACTOR