package ais.fbl;

import ais.briefing.BriefingOverview;
import stepdefinitions.AIS_FBL_TC001;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Feedback Loop Action class mainly contains the steps are declared using
 * the Serenity @Step annotation, shown below:
 * It is an interaction class contains tasks for Feedback Loop
 *
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class FBLActions extends UIInteractionSteps {

    // Page Objects
    BriefingOverview briefing;

    FBLPage fbl;

    @Step("Create Contact Moment")
    public void contactMomentFor(ContactMoment contactType) {
        // Try to search until contact moment button found
        while(true) {
            if ($(briefing.contactMomentButton(contactType)).isCurrentlyVisible()) {
                WebElement ele = AIS_FBL_TC001.driver.findElement(briefing.contactMomentButton(contactType));
                JavascriptExecutor jse = (JavascriptExecutor)AIS_FBL_TC001.driver;
                jse.executeScript("arguments[0].click()", ele);
                break;
            } else {
                System.out.println("Not found contact moment button in this page! Going to next page");
                $(briefing.navigationNextButton()).click();
            }
        }
    }

    @Step("Select contact type")
    public void selectContactType(String contactType) {
        $(fbl.contactTypeLink(contactType)).click();
    }

    @Step("Send Message")
    public void sendMessage(String buttonName) {
        $(fbl.actionButton(buttonName)).click();
    }

    @Step("Success Alert")
    public WebElementState alertVisible(String message) {
        return $(fbl.successAlert(message)).shouldBeVisible();
    }

    @Step("Contact Moment Status")
    public String  contactMomentStatus(String status) {
        return $(fbl.contactMomentStatusRow(status)).getText();
    }

    @Step("Delete Contact Moment")
    public void deleteContactMoment() {
        $(fbl.deleteIcon()).click();
    }

    @Step("Set valid email To")
    public void setValidEmailTo(String validEmail) {
        $(fbl.emailTo()).clear();
        $(fbl.emailTo()).sendKeys(validEmail);
    }

    @Step("Set valid email Cc")
    public void setValidEmailCc(String validEmail) {
        $(fbl.emailCc()).clear();
        $(fbl.emailCc()).sendKeys(validEmail);
    }

}