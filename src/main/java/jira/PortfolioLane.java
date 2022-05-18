package jira;

/**
 * This enum contains IDs of the custom field Portfolio Lane
 * You can fetch the items from this URL
 * https://jira-eu-aholddelhaize.atlassian.net/rest/api/3/field
 */
public enum PortfolioLane {
    CUSTOMER_VALUE_DRIVER("14527"),
    NONSTRATEGIC_PRODUCT_MANAGEMENT("14528"),
    TECH_ENABLER("18122"),
    MAINTENANCE("14529");

    private final String portfolioLaneItem;

    PortfolioLane(String portfolioLaneItem) {
        this.portfolioLaneItem = portfolioLaneItem;
    }

    @Override
    public String toString() {
        return portfolioLaneItem;
    }
}
