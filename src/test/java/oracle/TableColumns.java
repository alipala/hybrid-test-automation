package oracle;

public enum TableColumns {
    l0VERKOOPARTIKELEN("LANGE_OMSCHR", "SCHAPSTICKER_OMSCHR", "KASSABON_OMSCHR"),
    l0COLLO_VAN_LEVERANCIER("BREEDTE", "HOOGTE", "LENGTE"),
    l0PALLET_VAN_LEVCRS("AFROEP_EENHEID", "AANTAL_PER_LAAG", "LAGEN_PER_PALLET"),
    l0BASIS_INK_VWDEN_TVN("KODE_LEVERINGSKONDITIES", "NETTO_INKPR_IN_VALUTA", "VALU_VALUTAKODE"),
    L0COLLI("VART_NASA_NUMMER", "AANTAL_PER_SA_COLLO", "VARIANT_NUMMER");

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
