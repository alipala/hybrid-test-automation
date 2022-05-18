package aut.datachange;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

/**
 * DataChangeActions class mainly contains the steps are declared using
 * the Serenity @Step annotation, shown below:
 * It is an interaction class contains tasks for DW
 *
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class DataChangeActions extends UIInteractionSteps {

    DataChangeImport dataChange;

    @Step("Get header of the page")
    public String getHeader() {
        return $(dataChange.header()).getText();
    }

    @Step("Select an option from dropbox")
    public WebElementFacade selectOptionBy(String index) {
        return $(dataChange.selectDropBox()).selectByIndex(Integer.parseInt(index));
    }

    @Step("Open {0} directory to find correct file")
    public void openFor(String directoryName) {
        $(dataChange.dwFile()).sendKeys(directoryName);
    }

    @Step("Upload the .csv file")
    public void uploadFile() {
        $(dataChange.uploadButton()).click();
    }

    @Step("Success Alert")
    public WebElementState alertVisible() {
        return $(dataChange.successAlert()).shouldBeVisible();
    }



}
