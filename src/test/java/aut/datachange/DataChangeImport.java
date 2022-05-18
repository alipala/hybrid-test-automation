package aut.datachange;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of DW import
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class DataChangeImport extends PageObject {

    /**
     * Locate the page header
     * @return a xpath expression. It returns xpath of header of page
     */
    public By header() {
        return By.xpath("//*[contains(@id, 'wtTitle')]");
    }

    /**
     * Locate Uploaden dropdown in Datawijziging uploaden page
     * @return xpath expression. It returns xpath of drop box
     * has id contains CategoryManagerId and class contains select
     */
    public By selectDropBox() {
            return By.xpath("//*[contains(@id, 'CategoryManagerId')][contains(@class, 'select')]");
    }

    /**
     * Locate Import DW file box
     * @return xpath expression. It returns xpath of DW file box
     */
    public static By dwFile() {
        return By.xpath("//*[contains(@id, 'Upl_File')]");
    }

    /**
     * Locate upload button in DW page
     * Note: value can be parametrized later
     * @return xpath expression. It returns xpath of button name is Verzend
     */
    public static By uploadButton(){
        return By.xpath("//input[@value='Verzend']");
    }

    /**
     * Locate Success alert
     * @return xpath expression. It returns xpath of success alert without a message
     */
    public static By successAlert() {
        return By.xpath("//div[@class='Feedback_Message_Success']");
    }

}
