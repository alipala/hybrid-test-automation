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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static aut.menu.Items.BRIEFINGS;
import static aut.menu.SubItems.OVERZICHT;
import static aut.utilities.Utilities.waitFor;
import static org.assertj.core.api.Assertions.assertThat;

public class AUT_Articel_Date_TC001 {

    private static final Logger logger
            = LoggerFactory.getLogger(AUT_Articel_Date_TC001.class);

    public static final String select_status = "Column1_wtCmb_Status";


    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    BriefingActions briefing;

    //Page Object
    BriefingOverview briefingOverview;

    @Given("Preparation steps of AUT_Articel_Date_TC001")
    public void preparation_steps_of_ais_artikelingangdatum_tc001() {
        logger.info("Go to page URL and login as a standard user");
        login.pageUrl();
        login.as(User.STANDARD_USER);
        logger.info("Navigate the Briefing Overview menu");
        topMenu.item(BRIEFINGS);
        topMenu.subItem(OVERZICHT);
    }

    @When("go to detail of an artikel")
    public void go_to_detail_of_an_artikel() {
        briefing.pickSelectMenuAndItsOption(select_status, "Open");
        waitFor(2000);
        briefing.openBriefingDetail();
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        briefing.openItemDetail();
    }

    @Then("should see the {string} field disable")
    public void should_see_the_field_disable(String elementName) {
        Serenity.reportThat("Ingangsdatum field should be disable",
                () -> assertThat(briefingOverview.elementVisible(elementName).shouldNotBeSelected())
        );
    }
}
