package aut.briefing;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Item Detail Page
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class ItemDetailPage extends PageObject {

    /** DON'T USE IT SUCH EXPRESSIONS!
     * It is a bad sample for you to guide of locating an element.
     */
    public String status() {
        return $("#AIS_wt597_block_OutSystemsUIWeb_wt10_block_wtContent_wtActions_wtCnt_Status .background-green").getText();
    }

    /**
     * Locate datatimepicker object
     * @return a xpath expression. It returns xpath of datatimepicker object
     */
    public static By dateTimePicker(){
        return By.xpath("//*[contains(@id, 'ItemChange_EffectiveDate')]");
    }
}
