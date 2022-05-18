package aut.management;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains common the page elements of Management Page
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class ManagementCommon extends PageObject {

    /**
     * Locate any button with regarding title
     * @param value button value
     * @return a xpath expression. It returns xpath of button
     */
    public static By button(String value){
        return By.xpath("//input[@value='" + value + "']");
    }

    /**
     * Locate web element state of the alert box dialog regarding message
     * @param message message of alert dialog
     * @return a xpath expression. It returns xpath of alert dialog
     */
    public WebElementState alert(String message) {
        return $("//div[@class='Feedback_Message_Success'][.='" + message +"']");
    }


}
