package aut.monitor;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of AIS Rapport page
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class AUTRapport extends PageObject {

    /**
     * Locate the button
     * @return xpath expression. It returns xpath of download rapport button
     */
    public static By downloadRapportButton() {
        return By.xpath("//a[text()[contains(., 'Download AIS Rapport')]]");
    }
}
