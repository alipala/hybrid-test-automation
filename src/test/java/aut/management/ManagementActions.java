package aut.management;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

/**
 * ManagementActions class mainly contains the steps are declared using
 * the Serenity @Step annotation, shown below:
 * For the time being, it contains tasks for creating document tasks in Beheer Menu.
 * Can be extended by other actions
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class ManagementActions extends UIInteractionSteps {

    DocumentTypePage documentType;

    ManagementCommon managementCommon;

    @Step("Click {0} button")
    public void clickFor(String buttonName) {
        $(managementCommon.button(buttonName)).click();
    }

    @Step("Set document name {0}")
    public void setDocumentName(String name) {
        $(documentType.documentType()).sendKeys(name);
    }

    @Step("Set document description {0}")
    public void setDocumentDescription(String description) {
        $(documentType.documentDescription()).sendKeys(description);
    }

    @Step("See the Document type")
    public String getDocumentTypeName() {
        return $(documentType.tableLastRow()).getText();
    }
}
