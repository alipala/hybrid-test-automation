package aut.fbl;

public enum ContactMoment {
        FIRST_CONTACT("Maak contactmomenten"),
        FIRST_CONTACT_SUCCESS("Eerste contactmomenten succesvol verzonden"),
        SECOND_CONTACT("Maak tweede contactmomenten"),
        SHOW_CONTACT("Toon contactmomenten"),
        SHOW_SECOND_CONTACT("Toon tweede contactmoment");


    private final String contactMoment;

    ContactMoment(String contactMoment) {
        this.contactMoment = contactMoment;
    }

    public String getContact() {
        return contactMoment;
    }

    @Override
    public String toString() {
        return contactMoment;
    }
}
