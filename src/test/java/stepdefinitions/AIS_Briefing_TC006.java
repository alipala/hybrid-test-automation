package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.briefing.BriefingActions;
import ais.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static ais.menu.Items.BRIEFINGS;
import static ais.menu.SubItems.OVERZICHT;
import static ais.utilities.Utilities.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AIS_Briefing_TC006 {

    public static final String fileName = "Mutatie_RedBulll_WK14.csv";
    public static final String importDirectory = TEST_DATA_DIR + fileName;

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    BriefingActions briefing;

    @Given("Preparation steps of TC006")
    public void preparation_steps_of_tc006() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERZICHT);
    }

    @Given("go to detail of a briefing")
    public void go_to_detail_of_a_briefing() {
        briefing.openBriefingImportDetail();
    }

    @When("export")
    public void export() {
        briefing.downloadImportedFile();
        waitFor(2000);
    }

    @Then("a csv file should be downloaded")
    public void a_csv_file_should_be_downloaded() {
        File getLatestFile = getLatestFilefrom(System.getProperty("user.dir"));
        String latestFileName = getLatestFile.getName();
        assertThat(latestFileName).isEqualTo(briefing.getBriefingFileName());
    }
}
