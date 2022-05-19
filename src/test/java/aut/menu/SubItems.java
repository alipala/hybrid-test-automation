package aut.menu;

public enum SubItems {
    IMPORT("Import"),
    REPORT("AUT Report"),
    BATCHES("Batch funstions"),
    OVERVIEW("Overview"),
    DOCUMENT_TYPE("Document Type");

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
