package jira.listeners;

import jira.helpers.JiraServiceProvider;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import net.rcarz.jiraclient.JiraException;

/**
 * JiraListener contains methods to be invoked in case of test finishes
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-05-10
 */

public class JiraListener implements ConcurrentEventListener {

    JiraServiceProvider jiraServiceProvider = null;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    /**
     * This method uses for creating Jira issue after testcase finished failed
     * @param event This is the event to listen the testcase whether finished
     */
    private void handleTestCaseFinished(TestCaseFinished event) {

        // Properties come once TestCaseFinished event triggers
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        String components = null;

        // If the test fails
        if(status.is(Status.FAILED)) {
            Throwable error = result.getError();
            String scenarioName = testCase.getName();
            String featurePath = "" + testCase.getUri();

            // Decide to component of tests whether Outsystems or Oracle
            if (featurePath.contains("userinterface")) {
                components = "Outsystems";

            } else if (featurePath.contains("database")) {
                components = "Oracle";
            } else {
                System.out.println("Invalid test suite. Check the logs.");
            }

            String issueSummary = "AUTOMATED TEST FAIL: " + scenarioName;
            String issueDescription = error.getMessage();

            // Create a Jira issue with required information
            try {
                jiraServiceProvider = new JiraServiceProvider();
                jiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription, featurePath, components);
            } catch (JiraException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("No need to create JIRA issue since the test result: " + Status.PASSED);
        }
    }
}
