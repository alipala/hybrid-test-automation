package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.management.ManagementActions;
import ais.menu.TopMenuActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static ais.menu.Items.BEHEER;
import static ais.menu.SubItems.DOCUMENT_TYPEN;

public class AIS_Management_TC001 {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    ManagementActions management;

    @Given("Preparation steps of AIS_Management_TC001")
    public void preparation_steps_of_ais_management_tc001() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
    }

    @Given("go to Document Types page")
    public void go_to_document_types_page() {
        topMenu.item(BEHEER);
        topMenu.subItem(DOCUMENT_TYPEN);
    }

    @When("add document")
    public void add_document() {
        management.clickFor("Add Document Type");
        management.setDocumentName("Test Document");
        management.setDocumentDescription("Test Description");
        management.clickFor("Save");
    }

    @Then("should see new document in the list")
    public void should_see_new_document_in_the_list() {
        Assertions.assertThat(management.getDocumentTypeName()).isEqualTo("Test Document");
    }
}
