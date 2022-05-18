package aut.briefing;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Briefing Import page
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class BriefingImport extends PageObject {

    /**
     * Locate file upload box
     * @return a xpath expression. It returns the xpath of the file upload
     */
    public static By briefingFile() {
        return By.xpath("//*[contains(@id, 'UplFileUploadBriefing')]");
    }

    /**
     * Locate file upload button
     * @return a xpath expression. It returns the xpath of the upload button
     */
    public static By uploadButton() {
        return By.xpath("//*[contains(@id, 'BtnUpload')]");
    }


}
