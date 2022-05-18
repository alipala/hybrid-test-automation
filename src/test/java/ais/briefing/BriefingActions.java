package ais.briefing;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static ais.briefing.BriefingDetail.*;
import static ais.briefing.BriefingImport.briefingFile;
import static ais.briefing.BriefingImport.uploadButton;
import static ais.briefing.BriefingOverview.*;
import static ais.briefing.ItemDetailPage.dateTimePicker;

/**
 * This actions class mainly contains the steps are declared using the Serenity @Step annotation, shown below:
 * It is an interaction class needs to interact with Briefing pages. The class extend the Serenity UIInteractionSteps.
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */
public class BriefingActions extends UIInteractionSteps {

    @Step("Open the directory to find correct file")
    public void openFileIn(String directoryName) {
        $(briefingFile()).sendKeys(directoryName);
    }

    @Step("Upload the .csv file")
    public void uploadFile() {
        $(uploadButton()).click();
    }

    @Step("Open briefing detail in a new tab")
    public void openBriefingDetail(){
        $(artikelLink()).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
    }

    @Step("Open briefing import detail")
    public void openBriefingImportDetail() {
        $(importDetailColumn()).click();
    }

    @Step("Get briefing file name")
    public String getBriefingFileName() {
        return $(downloadCSVLink()).getText();
    }

    @Step("Go to briefing import detail")
    public void downloadImportedFile() {
        $(downloadCSVLink()).click();
    }

    @Step("Open item detail")
    public void openItemDetail(){
        $(itemDetail()).click();
    }

    @Step("Select and its option")
    public WebElementFacade pickSelectMenuAndItsOption(String select, String option) {
        return $(dropBox(select)).selectByVisibleText(option);
    }

    @Step("Search a keyword")
    public void searchKeyword(String term) {
        $(searchBox()).sendKeys(term);
    }

    @Step("Press Button")
    public void clickButton(String value){
        $(button(value)).click();
    }

    @Step("Delete briefing")
    public void deleteBriefing() {
        $(deleteBriefingButton()).click();
    }

    @Step("Click to {0} button")
    public void actionFor(String buttonTitle) {
        $(briefingActionButton(buttonTitle)).click();
    }

    @Step("Set date")
    public void setDate(String newDate) {
        $(dateTimePicker()).sendKeys(newDate);
    }

    @Step("Open Packshot")
    public void openPackShot() {
        $(artikelPackshotPhotoLink()).click();
    }

    @Step("Packshot Popup visible")
    public WebElementState packShotPopupVisible() {
        return $(packShotPopup()).shouldBeVisible();
    }

    @Step("Packshot image visible")
    public WebElementState getSourceOfImg() {
        return $(img()).shouldBeVisible();
    }

    @Step("Disable Foto")
    public void disablePackShot() {
        $(photoCheckbox()).click();
    }

}


