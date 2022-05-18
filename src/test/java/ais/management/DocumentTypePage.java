package ais.management;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Document Type Page
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class DocumentTypePage extends PageObject {

    /**
     * Locate document type element
     * @return a xpath expression. It returns xpath of document type element
     */
    public static By documentType(){
        return By.xpath("//*[contains(@id, 'DocumentType_Name')]");
    }

    /**
     * Locate Textbox of document description
     * @return xpath expression. It returns xpath of document type description element
     */
    public static By documentDescription(){
        return By.xpath("//*[contains(@id, 'DocumentType_Description')]");
    }

    /**
     * Locate Edit row of document table
     * @return a xpath expression. It returns xpath of Edit row
     */
    public static By tableLastRow() {
        return By.xpath("//tr[last()]/td/a[contains(@title, 'Edit')]");
    }

}
