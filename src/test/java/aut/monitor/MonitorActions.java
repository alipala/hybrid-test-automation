package aut.monitor;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import static aut.monitor.AUTRapport.downloadRapportButton;

/**
 * MonitorActions class mainly contains the steps are declared using
 * the Serenity @Step annotation, shown below:
 * It is an interaction class contain task for downloading report
 * It can be extended by adding further tasks related to monitoring
 *
 *
 * @author  Ali Pala
 * @version 1.0
 */

public class MonitorActions extends UIInteractions {

    @Step("Download report")
    public void downloadReport() {
        $(downloadRapportButton()).click();
    }

}
