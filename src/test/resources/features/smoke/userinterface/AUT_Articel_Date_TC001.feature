Feature: Does not change the Ingangsdatum value
  As a user
  I want to see Ingangsdatum field is disabled
  so that preventing to change the date

  Background:
    Given Preparation steps of AIS_ArtikelIngangDatum_TC001

#  @BriefingImport
  Scenario Outline: The user should not change Ingangsdatum
    When go to detail of an artikel
    Then should see the "<Ingangsdatum>" field disable
    Examples:
      |  Ingangsdatum         |
      |  EffectiveDate_From   |

