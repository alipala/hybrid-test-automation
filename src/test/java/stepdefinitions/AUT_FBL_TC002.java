package stepdefinitions;

import aut.authentication.LoginActions;
import aut.authentication.User;
import aut.briefing.BriefingActions;
import aut.fbl.FBLActions;
import aut.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import static aut.fbl.ContactMoment.FIRST_CONTACT_SUCCESS;
import static aut.menu.Items.BRIEFINGS;
import static aut.menu.SubItems.OVERVIEW;
import static org.assertj.core.api.Assertions.assertThat;

public class AUT_FBL_TC002 {

    public static final String select_status = "Column1_wtCmb_Status";

    @Managed
    public static WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    FBLActions fbl;

    @Steps
    BriefingActions briefing;

    @Given("Preparation steps of AUT_FBL_TC002")
    public void preparation_steps_of_ais_fbl_tc002() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERVIEW);
    }

    @When("enter to blue envelope of a briefing")
    public void enter_to_blue_envelope_of_a_briefing() {
        briefing.pickSelectMenuAndItsOption(select_status, "Open");
        fbl.contactMomentFor(FIRST_CONTACT_SUCCESS);
    }

    @Then("should see the Status is {string}")
    public void should_see_the_status_is(String status) {
        Serenity.reportThat("Contact Moment Status",
                () -> assertThat(fbl.contactMomentStatus(status)).isEqualTo("Verzonden")
        );

    }
}
