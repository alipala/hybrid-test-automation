package testsuite;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "jira.listeners.JiraListener"},
        features = {"src/test/resources/features/smoke"},
        glue = "stepdefinitions"
)
public class TestSuite {
}
