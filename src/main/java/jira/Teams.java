package jira;

/**
 * This enum contains IDs of the custom field Teams
 * You can fetch the items from this URL
 * https://jira-eu-aholddelhaize.atlassian.net/rest/api/3/field
 */

public enum Teams {
    // Add other teams based on Jira Rest API IDs
    TEAM_NAME("10819");

    private final String teamName;

    Teams(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return teamName;
    }
}
