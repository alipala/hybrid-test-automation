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
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static aut.menu.Items.BRIEFINGS;
import static aut.menu.SubItems.OVERVIEW;
import static aut.utilities.Utilities.TEST_DATA_DIR;
import static aut.utilities.Utilities.waitFor;
import static org.assertj.core.api.Assertions.assertThat;

public class AUT_Packshot_TC001 {

    public static final String importFileDirectory = TEST_DATA_DIR + "Mutatie_RedBulll_WK14.csv";
    public static final String select_status = "Column1_wtCmb_Status";

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

    @Given("Preparation steps of AUT_Packshot_TC001")
    public void preparation_steps_of_ais_packshot_tc001() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
    }

    @When("open the packshot detail popup")
    public void open_the_packshot_detail_popup() {
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERVIEW);
        briefing.pickSelectMenuAndItsOption(select_status, "Open");
        waitFor(2000);
        briefing.openBriefingDetail();
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        briefing.openPackShot();
    }

    @Then("should see the packshot information")
    public void should_see_the_packshot_information() {
        waitFor(2000);
        Serenity.reportThat("Packshot popup is visible",
                () -> assertThat(briefing.packShotPopupVisible())
        );
    }

    @When("disable the foto of the artikel")
    public void disable_the_foto_of_the_artikel() {
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERVIEW);
        briefing.pickSelectMenuAndItsOption(select_status, "Open");
        waitFor(2000);
        briefing.openBriefingDetail();
        ArrayList<String> w =
                new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        briefing.disablePackShot();
    }

    @When("try to refresh the foto")
    public void try_to_refresh_the_foto() {
        briefing.actionFor("Ververs Foto");
        briefing.openPackShot();
        waitFor(2000);
    }

    @Then("should see the packshot information and foto")
    public void should_see_the_packshot_information_and_foto() {
        assertThat(briefing.packShotPopupVisible());

        WebElement iframe = driver.findElement(By.xpath(
                "//iframe[contains(@src, 'PackshotDetailPopup')]"));

        driver.switchTo().frame(iframe);
        assertThat(briefing.getSourceOfImg());
    }

}
