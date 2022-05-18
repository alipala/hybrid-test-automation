package stepdefinitions;

import aut.authentication.LoginActions;
import aut.authentication.User;
import aut.briefing.BriefingActions;
import aut.briefing.BriefingOverview;
import aut.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static aut.menu.Items.BRIEFINGS;
import static aut.menu.SubItems.IMPORTEREN;

public class AUT_Briefing_TC002 {

    public static final String correctFileDirectory = "";

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    BriefingActions briefing;

    // Page Object
    BriefingOverview briefingOverview;

    @Given("Preparation steps of TC002")
    public void preparation_steps_of_tc002() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(IMPORTEREN);
    }

    @When("I upload correct csv file")
    public void i_upload_correct_csv_file() {
        briefing.openFileIn(correctFileDirectory);
        briefing.uploadFile();

        Serenity.reportThat("should see the success message",
                () -> Assertions.assertThat(briefingOverview.successAlert().shouldBeVisible())
        );
        // Open briefing detail in a new tab
        briefing.openBriefingDetail();
        ArrayList<String> w =
                new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
    }

    @Then("I should see the status icons are tick in all lines")
    public void i_should_see_the_status_icons_are_tick_in_all_lines() {

    }

    @When("I upload correct csv file with invalid data")
    public void i_upload_correct_csv_file_with_invalid_data() {

    }

    @Then("I should see the status icons are exclamation mark in some lines")
    public void i_should_see_the_status_icons_are_exclamation_mark_in_some_lines() {

    }

}
