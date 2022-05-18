package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

/**
 * Hooks contains setup and teardown tasks. It can be implemented any other tasks
 * if needed. It is a demonstration for how to check a cucumber scenario failed
 */
public class Hooks {

    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Let's start bb!");

    }

    @After()
    public void cleanUp(Scenario scenario){
        if (scenario.isFailed()){
            // Do whatever you want in case any scenario is failed!
        }


    }
}
