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
import org.openqa.selenium.WebDriver;

import static aut.menu.Items.BRIEFINGS;
import static aut.menu.SubItems.OVERZICHT;
import static aut.utilities.Utilities.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AUT_Briefing_TC004 {

    public static final String select_briefing_type = "wtColumn3_wt50";
    public static final String select_status = "Column1_wtCmb_Status";
    public static final String select_filter = "Column2_wtCmb_Filter";

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

    @Given("Preparation steps of TC004")
    public void preparation_steps_of_tc004() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERZICHT);
    }

    @Then("should see a filter called {string}")
    public void should_see_a_filter_called(String filterName) {
        Serenity.reportThat("Dropbox is visible",
                () -> assertThat(briefingOverview.elementVisible(filterName).shouldBeVisible())
        );
    }

    @When("pick options from {string}")
    public void pick_options_from(String option) {
        briefing.pickSelectMenuAndItsOption(select_status, option);
    }

    @Then("should see the related briefings via {string} icon")
    public void should_see_the_related_briefings_via_icon(String icon) {
        waitFor(2000);
        Serenity.reportThat("Selected items",
                () -> assertThat(briefingOverview.statusOf(icon).size()).isEqualTo(50)
        );
    }

    @When("pick {string} and {string} and {string}")
    public void pick_and_and(String statusOption, String filterOption, String filter2Option) {
        briefing.pickSelectMenuAndItsOption(select_status, statusOption);
        briefing.pickSelectMenuAndItsOption(select_filter, filterOption);
        briefing.pickSelectMenuAndItsOption(select_briefing_type, filter2Option);
        briefing.clickButton("Zoek");
    }

    @Then("should see correct briefings {string}")
    public void should_see_correct_briefings(String briefingType) {
        Serenity.reportThat("Should be seen 50 items",
                () -> assertThat(briefingOverview.statusOf("red").size()).isEqualTo(50)
        );

        Serenity.reportThat("Should be seen correct briefing type",
                () -> assertThat(briefingOverview.briefingType().textContents()).containsAnyOf(briefingType)
        );
    }

    @When("write {string} into searchbox")
    public void write_into_searchbox(String searchTerm) {
        briefing.searchKeyword(searchTerm);
        briefing.clickButton("Zoek");
        waitFor(2000);
    }

    @Then("should see the briefings contain {string}")
    public void should_see_the_briefings_contain(String briefingCode) {
        assertThat(briefingOverview.briefingCode().textContents().get(1)).containsAnyOf(briefingCode);
    }
}
