package ais.menu;

public enum SubItems {
    IMPORTEREN("Importeren"),
    AIS_RAPPORT("AIS Rapport"),
    BATCH_FUNCTIES("Batchfuncties (NASA/DP)"),
    OVERZICHT("Overzicht"),
    DOCUMENT_TYPEN("Document Typen");

    private final String subMenuItem;

    SubItems(String subMenuItem) {
        this.subMenuItem = subMenuItem;
    }

    public String getSubMenuItem() {
        return subMenuItem;
    }

    @Override
    public String toString() {
        return subMenuItem;
    }
}
