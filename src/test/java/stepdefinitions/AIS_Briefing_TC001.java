package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.briefing.BriefingActions;
import ais.briefing.BriefingOverview;
import ais.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static ais.menu.Items.BRIEFINGS;
import static ais.menu.SubItems.IMPORTEREN;
import static ais.utilities.Utilities.TEST_DATA_DIR;

/**
 * This job of this step definition class is preparation steps of the tests, and scenarios steps that stored in the feature file
 * The @Steps annotations tell to create a new instance of the related action class, and inject steps the test needs.
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class AIS_Briefing_TC001 {

    public static final String differentTypeOfFileDirectory = TEST_DATA_DIR + "test.pdf";
    public static final String emptyFileDirectory = TEST_DATA_DIR + "empty.csv";

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

    @Given("Preparation steps of TC001")
    public void preparation_steps_of_tc001() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(BRIEFINGS);
        topMenu.subItem(IMPORTEREN);
    }

    @When("upload different file than csv")
    public void upload_different_file_than_csv() {
        briefing.openFileIn(differentTypeOfFileDirectory);
        briefing.uploadFile();
    }

    @Then("should see the error message {string}")
    public void should_see_the_error_message(String message) {
        Serenity.reportThat("should see error",
                () -> Assertions.assertThat(briefingOverview.errorAlert(message).shouldBeVisible())
        );
    }

    @When("upload empty csv file")
    public void upload_empty_csv_file() {
        briefing.openFileIn(emptyFileDirectory);
        briefing.uploadFile();
    }

    @Then("should see the reading failed message {string}")
    public void should_see_the_reading_failed_message(String message) {
        Serenity.reportThat("should see error",
                () -> Assertions.assertThat(briefingOverview.errorAlert(message).shouldBeVisible())
        );
    }
}
