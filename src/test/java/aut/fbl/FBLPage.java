package aut.fbl;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Feedback Loop Page
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class FBLPage extends PageObject {

    /**
     * Locate Soort Contact
     * @param contactType contact type of the person. For example: Eerste Contact
     * @return a linktext expression. It returns lintext of contact type
     */
    public static By contactTypeLink(String contactType) {
        return By.linkText(contactType);
    }

    /**
     * Locate any button with a value
     * @param value value of the button
     * @return a xpath expression. It returns xpath of button
     */
    public static By actionButton(String value){
        return By.xpath("//input[@value='" + value + "']");
    }

    /**
     * Locate the success alert with related message
     * @param message message of success alert
     * @return a xpath expression. It returns xpath of success alert
     */
    public static By successAlert(String message) {
        return By.xpath("//div[@class='Feedback_Message_Success']/span[text()[contains(.,'"+message+"')]]");
    }

    /**
     * Locate Contact moment status in the table
     * @param status icon of contact moment in the table
     * @return xpath expression. It returns xpath of status icon
     */
    public static By contactMomentStatusRow(String status) {
        return By.xpath("//td[3][text()[contains(.,'"+status+"')]]");
    }

    /**
     * Locate delete icon of partikular briefing in contact moment table
     * @return css selector. It returns css selector of delete icon
     */
    public static By deleteIcon() {
        return By.cssSelector(".fa-trash-o");
    }

    // Aan field in Contactmoment page

    /**
     * Locate Aan field in Contactmoment page
     * @return xpath expression. It returns xpath of Aan field(Email To)
     */
    public static By emailTo() {
        return By.xpath("//input[contains(@id, 'ContactDetail_To')]");
    }

    /**
     * Locate CC field in Contactmoment page
     * @return xpath expression. It returns xpath of Aan field(Email Cc)
     */
    public static By emailCc() {
        return By.xpath("//input[contains(@id, 'ContactDetail_Cc')]");
    }
}
