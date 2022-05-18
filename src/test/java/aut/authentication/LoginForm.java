package aut.authentication;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

/**
 * LoginForm Page Object class mainly contains the page elements of Login page.
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class LoginForm extends PageObject {
    static By USER_NAME = By.xpath("//input[contains(@id, 'wtUserNameInput')]");
    static By PASSWORD = By.xpath("//input[contains(@id, 'wtPasswordInput')]");
    static By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");

    /**
     * This method is used to locate error alert with message
     * @param message in alert dialog
     * @return visibility state of the alert dialog
     */
    public WebElementState alert(String message) {
        return $("//div[@class='Feedback_Message_Error'][.='" + message +"']");
    }

}
