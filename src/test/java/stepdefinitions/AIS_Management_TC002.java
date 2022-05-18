package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.management.ManagementActions;
import ais.management.ManagementCommon;
import ais.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static ais.menu.Items.BEHEER;
import static ais.menu.SubItems.BATCH_FUNCTIES;

public class AIS_Management_TC002 {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    ManagementActions management;

    // Page Object
    ManagementCommon managementCommon;

    @Given("Preparation steps of AIS_Management_TC002")
    public void preparation_steps_of_ais_management_tc002() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
    }

    @Given("go to Timer page")
    public void go_to_timer_page() {
        topMenu.item(BEHEER);
        topMenu.subItem(BATCH_FUNCTIES);
    }

    @When("try to trigger a {string} manually")
    public void try_to_trigger_a_manually(String timer) {
        management.clickFor(timer);
    }

    @Then("should see a started {string}")
    public void should_see_a_started(String message) {
        Serenity.reportThat("should see error",
                () -> Assertions.assertThat(managementCommon.alert(message).shouldBeVisible())
        );
    }
}
