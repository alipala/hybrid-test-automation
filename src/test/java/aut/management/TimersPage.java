package aut.management;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Timers Page
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class TimersPage extends PageObject {

    // Any Button to regarding title

    /**
     * Note: This button object is put here to give
     * a sample how to locate element in TimersPage
     * @param value value of the button
     * @return a xpath expression. It returns xpath of button
     */
    public static By button(String value){
        return By.xpath("//input[@value='" + value + "']");
    }
}
