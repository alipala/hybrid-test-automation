package stepdefinitions;

import aut.authentication.LoginActions;
import aut.authentication.User;
import aut.briefing.BriefingOverview;
import aut.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static aut.menu.Items.BRIEFINGS;
import static aut.menu.SubItems.OVERVIEW;

public class AUT_Briefing_TC003 {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    // Page Object
    BriefingOverview briefingOverview;

    @Given("Preparation steps of TC003")
    public void preparation_steps_of_tc003() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERVIEW);
    }

    @When("pick a failed import")
    public void pick_a_failed_import() {
        ListOfWebElementFacades failedImports = briefingOverview.importIcons("text-red");
        failedImports.get(0).click();
    }

    @Then("should see the history of a briefing")
    public void should_see_the_history_of_a_briefing() {
        ListOfWebElementFacades numberOfErrors = briefingOverview.briefingImportErrors();
        Serenity.reportThat("Number of briefing history should be more than zero",
                () -> Assertions.assertThat(numberOfErrors.size()).isGreaterThan(0)
        );

    }

}
