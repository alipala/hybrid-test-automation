package aut.fbl;

public enum ContactMoment {
    // This enum can be implemented based on your contacts
        FIRST_CONTACT("First contacts"),
        FIRST_CONTACT_SUCCESS("First contacts success"),
        SECOND_CONTACT("Second contacts"),
        SHOW_CONTACT("Show contacts"),
        SHOW_SECOND_CONTACT("Show second contact");


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
