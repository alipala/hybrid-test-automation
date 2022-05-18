package stepdefinitions;

import aut.authentication.LoginActions;
import aut.authentication.User;
import aut.datachange.DataChangeActions;
import aut.menu.Items;
import aut.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static aut.utilities.Utilities.TEST_DATA_DIR;

public class AUT_DW_TC001 {

    public static final String correctFileDirectory = TEST_DATA_DIR + "SAD_Inkoopprijsmutatie_kai.csv";

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    DataChangeActions dataChange;

    @Given("Preparation steps of AUT_DW_TC001")
    public void preparation_steps_of_ais_dw_tc001() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
        topMenu.item(Items.DATAWIJZIGINGEN);
        // TODO: Need to be refactoring later
        topMenu.difSubItem("UploadDataChange");
    }

    @Given("goto {string} screen")
    public void goto_screen(String header) {
        Serenity.reportThat("Page heading should be correct",
                () -> Assertions.assertThat(dataChange.getHeader()).isEqualTo((header)));
    }

    @When("upload DW file")
    public void upload_dw_file() {
        dataChange.selectOptionBy("1");
        dataChange.openFor(correctFileDirectory);
        dataChange.uploadFile();
    }

    @Then("should see the success message popup")
    public void should_see_the_success_message_popup() {
        Serenity.reportThat("should see success alert",
                () -> Assertions.assertThat(dataChange.alertVisible())
        );
    }
}
