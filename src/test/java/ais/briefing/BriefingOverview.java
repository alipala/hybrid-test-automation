package ais.briefing;

import ais.fbl.ContactMoment;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Briefing Overview page.
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */
public class BriefingOverview extends PageObject {

    /**
     * This method is used to locate error alert with message
     * @param message This is the message of alert
     * @return WebElementState. It returns the state of error alert
     */
    public WebElementState errorAlert(String message) {
        return $("//div[@class='Feedback_Message_Error']/span[text()[contains(.,'"+message+"')]]");
    }

    /**
     * This method is used to locate success alert without message
     * @return WebElementState. It returns the state of success alert
     */
    public WebElementState successAlert() {
        return $("//div[@class='Feedback_Message_Success']");
    }

    /**
     * This method is used to locate Page Heading
     * @return a xpath expression. It returns the heading locator of the page
     */
    public By pageHeading() {
        return By.xpath("//*[contains(@id, 'wtTitle')]");
    }

    /**
     * This method is used to locate import icons of all briefings in Briefing Table
     * @param iconColor This is the import icon color of the briefings
     * @return ListOfWebElementFacades.  It returns the list of import icons in the briefing overview table
     */
    public ListOfWebElementFacades importIcons(String iconColor){
        return findAll("//*[contains(@id, 'BriefingTable')]/tbody/tr/td[1]/div[contains(@class, '" + iconColor + "')]/following-sibling::a");
    }

    /**
     * This method is used to locate Import detail column of a briefing
     * @return a xpath expression. It returns the xpath of import detail column
     */
    public static By importDetailColumn() {
        return By.xpath("//*[contains(@id, 'BriefingTable')]/tbody/tr/td[1]/a");
    }

    /**
     * This method is used to locate the briefing type
     * @return ListOfWebElementFacades. It returns the briefing type list of the briefing table
     */
    public ListOfWebElementFacades briefingType(){
        return findAll("//*[contains(@id, 'BriefingTable')]/tbody/tr/td[6]");
    }

    /**
     * This method is used to locate code of briefings in Briefing Table.
     * @return ListOfWebElementFacades. It returns the briefing code list of the briefing table
     */
    public ListOfWebElementFacades briefingCode(){
        return findAll("//*[contains(@id, 'BriefingTable')]/tbody/tr/td[7]");
    }

    /**
     * This method is used to locate icon in Status row of briefings in Briefing Table
     * @param iconColor This is the icons in status row
     * @return ListOfWebElementFacades. It returns icon colors
     */
    public ListOfWebElementFacades statusOf(String iconColor){
        return $$("." + iconColor + ".OSInline");
    }

    /**
     * This method is used to locate filter dropbox
     * @param name This is the name of dropbox
     * @return WebElementState returns the state of alert window
     */
    //
    public static By dropBox(String name) {
        return By.xpath("//*[contains(@id, '"+ name +"')][contains(@class, 'select')]");
    }

    /**
     * This method is used to locate failed imports
     * @return ListOfWebElementFacades. It returns the state of alert window
     */
    public ListOfWebElementFacades briefingImportErrors() {
        return findAll("//*[contains(@id, 'BriefingImportLineErrorTable')]/tbody/tr");
    }

    /**
     * This method is used to locate Code column value of the Artikel
     * @return a css selector. It returns the briefing detail locator
     */
    public static By artikelLink(){
        return By.cssSelector("a[href*='DetailBriefingNew']");
        //return By.xpath("//td[7]/a[contains(@href,'DetailBriefingNew')]");
    }

    /**
     * This method is used to locate download csv link
     * @return a css selector. It returns the dowload csv locator
     */
    public static By downloadCSVLink(){
        return By.cssSelector("a[href*='DownloadCSVLink']");
    }

    /**
     * This method is used to locate is element visible
     * @param elementName This is the name of the element
     * @return WebElementState. It returns the state of the element
     */
    public WebElementState elementVisible(String elementName) {
        return $("//*[contains(@id, '" + elementName +"')]");
    }

    /**
     * This method is used to locate a button with its value
     * @param value This is the value of button
     * @return a xpath expression. It returns the xpath of the button with the value
     */
    public static By button(String value){
        return By.xpath("//input[@value='" + value + "']");
    }

    /**
     * This method is used to locate search box
     * @return a xpath expression. It returns the xpath of the searchbox
     */
    public static By searchBox(){
        return By.xpath("//*[contains(@id, 'TxtFilter')]");
    }

    /**
     * This method is used to locate delete briefing button
     * @return a xpath expression. It returns the xpath of the briefing delete button
     */
    public static By deleteBriefingButton() {
        return By.xpath("//td[12]/div/a[contains(@id, 'BtnDeleteBriefing')]/span");
    }

    /**
     * This method is used to locate contact moment buttons
     * @param contactType This is the contact type
     * @return a xpath expression. It returns the xpath of the contact moment button
     */
    public static By contactMomentButton(ContactMoment contactType) {
        return By.xpath("//td[11]/a[contains(@title, '"+contactType+"')]");
    }

    /**
     * This method is used to locate pagination button to navigate to the next page in briefing overview
     * @return a xpath expression. It returns the xpath of the navigation next button
     */
    public static By navigationNextButton() {
        return By.xpath("//a[contains(@class, 'ListNavigation_Next')]");
    }

}
