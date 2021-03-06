package aut.menu;

public enum Items {
    BRIEFINGS("Briefings"),
    DATACHANGE("Datachange"),
    CONTACT("Contact"),
    MONITOR("Monitor"),
    BEHEER("Beheer");

    private final String topMenuItem;

    Items(String topMenuItem) {
        this.topMenuItem = topMenuItem;
    }

    public String getTopMenuItem() {
        return topMenuItem;
    }

    @Override
    public String toString() {
        return topMenuItem;
    }
}
