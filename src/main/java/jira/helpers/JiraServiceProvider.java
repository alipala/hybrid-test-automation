package jira.helpers;


import jira.PortfolioLane;
import jira.Priority;
import jira.Teams;
import net.rcarz.jiraclient.*;
import java.util.ArrayList;

/**
 * JiraServiceProvider authenticates to the Jira server and provides issue creator
 * if the same issue not already in the backlog
 *
 * @author  Ali Pala
 */
public class JiraServiceProvider {

    private JiraClient jira;
    private String project;
    private String jiraURL;

    // This fields for CI/CD
    public static final String JIRA_URL = System.getenv("JIRA_URL");
    public static final String PASSWORD = System.getenv("JIRA_PASSWORD");
    public static final String USER = System.getenv("JIRA_USER_NAME");
    private static final String PROJECT = "CRFC";
    private static final String JQL_BASE_QUERY = "project = \"CRFC\" and type IN (Bug) and summary ~ \"";
    private static final String BUILD_TEST = "Take into build";

    /**
     * Initialize the Jira Client with credentials
     * @throws JiraException throws an exception in case of authentication problem
     */
    public JiraServiceProvider() throws JiraException {
        this.jiraURL = JIRA_URL;
        // Create basic authentication object
        BasicCredentials creds = new BasicCredentials(USER, PASSWORD);
        // Initialize the Jira client
        jira = new JiraClient(jiraURL, creds);
        this.project = PROJECT;
    }

    /**
     * Create a Jira issue based on information come from tests
     * @param issueType Jira issue type. Bug, story or feature
     * @param issueSummary Jira issue title or summary
     * @param description Jira issue description field to put detailed explanation
     * @param comment Jira issue comment field
     * @param component Jira issue components. For example, Outsystems, OracleDB, MulesoftAPI
     */
    public void createJiraIssue(String issueType, String issueSummary, String description, String comment, String component) {

        try {
             // Look for the same issue exists already
             // Avoid creating duplicate issue
            Issue.SearchResult sr = jira.searchIssues(JQL_BASE_QUERY + issueSummary + "\"");
            if (sr.total != 0) {
                System.out.println("Not created issue in Jira since the same issue already exist!");
                return;
            }

            // Fill the required fields of Jira item
            Issue.FluentCreate fluentCreate = jira.createIssue(project, issueType);
            fluentCreate.field(Field.SUMMARY, issueSummary);
            fluentCreate.field(Field.DESCRIPTION, description);
            fluentCreate.field(Field.PRIORITY, Field.valueByName(String.valueOf(Priority.MINOR)));
            fluentCreate.field("customfield_13301", Field.valueById(String.valueOf(PortfolioLane.MAINTENANCE)));
            fluentCreate.field(Field.COMPONENTS, new ArrayList() {{add(component);}});
            fluentCreate.field("customfield_10013", Field.valueById(String.valueOf(Teams.TEAM_ROOD)));
            Issue newIssue = fluentCreate.execute();
            newIssue.addComment(comment);

            // Update the issue status
            newIssue.transition().execute(BUILD_TEST);

            System.out.println("********************************************");
            System.out.println("New issue created in Jira with ID: " + newIssue);
            System.out.println("New issue URL is :"+jiraURL+"/browse/"+newIssue);
            System.out.println("*******************************************");

        } catch (JiraException e) {
            e.printStackTrace();
        }
    }
}
