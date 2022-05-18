package aut.menu;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

/**
 * TopMenuActions class mainly contains the steps are declared using
 * the Serenity @Step annotation, shown below:
 * It is an interaction class needs to interact with
 * Top menu and sub menu items.
 *
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class TopMenuActions extends UIInteractionSteps {

    @Step("Open {0} in the top menu")
    public void item(Items itemName) {
        $(TopMenuPage.topMenuItemFor(itemName)).click();
    }

    @Step("Open {0} item belongs to the top menu")
    public void subItem(SubItems itemName) {
        $(TopMenuPage.subMenuItemFor(itemName)).click();
    }

    @Step("Open sub menu {0} item")
    public void difSubItem(String itemName) {
        $(TopMenuPage.difSubMenuItemFor(itemName)).click();
    }

}
