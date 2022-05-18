package aut.menu;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Page Object class mainly contains the page elements of Top menu items
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class TopMenuPage extends PageObject {

    /**
     * Locate top menu items by name
     * @param itemName name of the top menu item
     * @return xpath expression. It returns xpath of top menu item
     */
    public static By topMenuItemFor(Items itemName) {
        return By.xpath("//div[contains(@class, 'Menu_TopMenus')]//div[contains(text(), '" + itemName + "')]");
    }

    /**
     * Locate sub menu items by name
     * @param itemName name of the sub menu item
     * @return xpath expression. It returns xpath of sub menu item
     */
    public static By subMenuItemFor(SubItems itemName) {
        return By.xpath("//a[contains(text(),'" + itemName + "')]");
    }

    /**
     * Locate different sub menu items by name that was not located with function above
     * @param itemName name of the different sub menu item
     * @return xpath expression. It returns xpath of different sub menu item
     */
    public static By difSubMenuItemFor(String itemName){
        return By.cssSelector("a[href*='/"+itemName+"']");
    }
}
