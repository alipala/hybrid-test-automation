package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.briefing.BriefingActions;
import ais.briefing.BriefingOverview;
import ais.fbl.FBLActions;
import ais.menu.TopMenuActions;
import ais.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static ais.fbl.ContactMoment.SHOW_CONTACT;
import static ais.menu.Items.BRIEFINGS;
import static ais.menu.SubItems.OVERZICHT;
import static org.assertj.core.api.Assertions.assertThat;

public class AIS_FBL_TC003 {

    public static final String select_status = "Column1_wtCmb_Status";

    public static final String importFileDirectory = Utilities.TEST_DATA_DIR + "Worp_WVVConserven_WK10.csv";

    @Managed
    WebDriver driver;

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

    @Given("Preparation steps of AIS_FBL_TC003")
    public void preparation_steps_of_ais_fbl_tc003() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERZICHT);
    }

    @When("delete contact moment")
    public void delete_contact_moment() {
        briefing.pickSelectMenuAndItsOption(select_status, "Gearchiveerd");
        fbl.contactMomentFor(SHOW_CONTACT);
        fbl.deleteContactMoment();
    }

    @Then("confirm {string} message")
    public void confirm_message(String message) {
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).isEqualTo(message);
        alert.accept();
    }
}
