package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.briefing.BriefingActions;
import ais.briefing.BriefingOverview;
import ais.fbl.FBLActions;
import ais.management.ManagementCommon;
import ais.menu.TopMenuActions;
import ais.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static ais.fbl.ContactMoment.FIRST_CONTACT;
import static ais.menu.Items.BRIEFINGS;
import static ais.menu.SubItems.OVERZICHT;
import static ais.utilities.Utilities.waitFor;
import static org.assertj.core.api.Assertions.assertThat;

public class AIS_FBL_TC001 {

    public static final String importFileDirectory = Utilities.TEST_DATA_DIR + "Worp_WVVConserven_WK10.csv";
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

    // Page Object
    BriefingOverview briefingOverview;

    @Given("Preparation steps of AIS_FBL_TC001")
    public void preparation_steps_of_ais_fbl_tc001() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERZICHT);
        briefing.pickSelectMenuAndItsOption(select_status, "Open");
        waitFor(2000);

    }

    @When("generate a contact moment for FBL1")
    public void generate_a_contact_moment_for_fbl1() {
        fbl.contactMomentFor(FIRST_CONTACT);

        // Remove the codes since AIS implementation
        // send all reports to business in ACC environment

//        fbl.selectContactType("Eerste Contact");
//        fbl.setValidEmailTo("ali.pala@ah.nl");
//        fbl.setValidEmailCc("ali.pala@ah.nl");
//        fbl.sendMessage("Versturen");
    }

    @Then("should see message {string}")
    public void should_see_message(String message) {
        Serenity.reportThat("should see success alert",
                () -> Assertions.assertThat(fbl.alertVisible(message))
        );
    }
}
