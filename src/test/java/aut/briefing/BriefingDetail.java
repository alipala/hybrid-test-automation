package aut.briefing;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Briefing detail page
 * of a particular artikel.
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class BriefingDetail extends PageObject {

    /**
     * Locate briefing item detail
     * @return item detail link
     */
    public static By itemDetail(){
        return By.cssSelector("a[href*='/AISItems/ItemDetailNew']");
    }

    /**
     * Locate any button in briefing detail page
     * @param buttonTitle title of the button
     * @return a xpath expression. It returns the xpath of the button with the value
     */
    public static By briefingActionButton(String buttonTitle) {
        return By.xpath("//a[@title='" + buttonTitle + "']");
    }

    /**
     * Locate the artikel packshot photo link
     * @return a css selector. It returns the css selector of the link
     */
    public static By artikelPackshotPhotoLink() {
        return By.cssSelector("a[href*='PackshotDetailPopup']");
    }

    /**
     * Locate the artikel packshot popup
     * @return a xpath expression. It returns the xpath of the popup
     */
    public static By packShotPopup() {
            return By.xpath("//span[text()[contains(.,'Packshot')]]");
    }

    /**
     * Locate the image of the artikel popup
     * @return a xpath expression. It returns the xpath of the image
     */
    public static By img() {
        return By.xpath("//*[contains(@id,'tColumn1')]/div/img");
    }

    /**
     * Locate the photo checkbox in the artikel detail to update the photo of artikel
     * @return a xpath expression. It returns the xpath of the checkbox of photo
     */
    public static By photoCheckbox(){
        return By.xpath("//div[text()[contains(., 'FOTO')]]/input[@type='checkbox']");
    }

    // TODO
    public static By iframe(){
        return By.xpath("//iframe[contains(@src, 'PackshotDetailPopup')]");
    }
}
