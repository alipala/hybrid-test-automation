package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.LoginForm;
import ais.briefing.BriefingOverview;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AIS_Authentication_TC001 {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    // Page Object
    LoginForm loginForm;

    // Page Object
    BriefingOverview briefingOverview;

    @Given("go to url {string}")
    public void go_to_url(String string) {
        login.pageUrl();
    }

    @When("provide invalid credentials {string}, {string}")
    public void provide_invalid_credentials(String username, String password) {
        login.with(username, password);
    }

    @Then("should see {string} error")
    public void should_see_error(String message) {
        Serenity.reportThat("should see error",
                () -> Assertions.assertThat(loginForm.alert(message).shouldBeVisible())
        );
    }

    @When("provide valid credentials {string}, {string}")
    public void provide_valid_credentials(String username, String password) {
        login.with(username, password);
    }

    @Then("should see the page title {string}")
    public void should_see_the_page_title(String heading) {
        WebElement pageHeading = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(briefingOverview.pageHeading()));
        Serenity.reportThat("Page heading should be correct",
                () -> Assertions.assertThat(pageHeading.getText()).isEqualTo((heading)));
    }
}
