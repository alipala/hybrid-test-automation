package oracle;

public enum TableColumns {
    FAKE_TABLE_1("LANGE_OMSCHR", "SCHAPSTICKER_OMSCHR", "KASSABON_OMSCHR"),
    FAKE_TABLE_2("BREEDTE", "HOOGTE", "LENGTE"),
    FAKE_TABLE_3("AFROEP_EENHEID", "AANTAL_PER_LAAG", "LAGEN_PER_PALLET"),
    FAKE_TABLE_4("KODE_LEVERINGSKONDITIES", "NETTO_INKPR_IN_VALUTA", "VALU_VALUTAKODE"),
    FAKE_TABLE_5("VART_NASA_NUMMER", "AANTAL_PER_SA_COLLO", "VARIANT_NUMMER");

    private final String firstColumn;
    private final String secondColumn;
    private final String thirdColumn;


    TableColumns(String firstColumn, String secondColumn, String thirdColumn) {
        this.firstColumn = firstColumn;
        this.secondColumn = secondColumn;
        this.thirdColumn = thirdColumn;
    }

    public String getFirstColumn() {
        return firstColumn;
    }

    public String getSecondColumn() {
        return secondColumn;
    }

    public String getThirdColumn() {
        return thirdColumn;
    }
}
