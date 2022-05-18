package stepdefinitions;

import ais.authentication.LoginActions;
import ais.authentication.User;
import ais.menu.TopMenuActions;
import ais.monitor.MonitorActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static ais.menu.Items.MONITOR;
import static ais.menu.SubItems.AIS_RAPPORT;
import static ais.utilities.Utilities.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AIS_Report_TC001 {

    public static final String reportDirectory = System.getProperty("user.dir");

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    TopMenuActions topMenu;

    @Steps
    MonitorActions monitor;

    @Given("Preparation steps of AIS_Report_TC001")
    public void preparation_steps_of_ais_report_tc001() {
        login.pageUrl();
        login.as(User.STANDARD_USER);
    }

    @Given("go to AIS Rapport page")
    public void go_to_ais_rapport_page() {
        topMenu.item(MONITOR);
        topMenu.subItem(AIS_RAPPORT);
    }

    @When("download")
    public void download() {
        monitor.downloadReport();
        waitFor(2000);
    }

    @Then("should see an excel file name contains {string} downloaded")
    public void should_see_an_excel_file_name_contains_downloaded(String fileName) {
        File getLatestFile = getLatestFilefrom(reportDirectory);
        String latestFileName = getLatestFile.getName();
        Serenity.reportThat("Should see the report",
                () -> assertThat(latestFileName).contains(fileName));
    }

    @Then("should see the {string} sheet fulfilled")
    public void should_see_the_sheet_fulfilled(String sheetName) {
        File getLatestFile = getLatestFilefrom(reportDirectory);
        String latestFileName = getLatestFile.getName();
        Serenity.reportThat("Row count should be more than 0",
                () -> {
                    try {
                        assertThat(readExcelRowCount(reportDirectory, latestFileName, sheetName)).isGreaterThan(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
