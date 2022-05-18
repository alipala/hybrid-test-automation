package ais.authentication;

public enum User {

    STANDARD_USER("" + System.getenv("AIS_LOGIN_USER") + "", "" + System.getenv("AIS_LOGIN_PASSWORD") + "", "a standard user"),
    ADMIN_USER("PutAdminUser", "PutAdminPass", "an admin user");

    private final String username;
    private final String password;
    private final String description;

    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "username: " + username + "\n" + "password: " + password;
    }
}
