package jira;

/**
 * This enum contains IDs of the custom field Priority
 * You can fetch the items from this URL
 * https://jira-eu-aholddelhaize.atlassian.net/rest/api/3/field
 */

public enum Priority {
    BLOCKER("Blocker"),
    CRITICAL("Critical"),
    MAJOR("Major"),
    MINOR("Minor"),
    NORMAL("Normal");

    private final String priorityLevel;

    Priority(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return priorityLevel;
    }

}
