package ais.authentication;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

/**
 * LoginActions class mainly contains the steps are declared using
 * the Serenity @Step annotation, shown below:
 * It is an interaction class needs to interact with Login page.
 *
 *
 * @author  Ali Pala
 * @version 1.0
 * @since   2021-03-01
 */

public class LoginActions extends UIInteractions {

    private String endpointBaseUrl;
    private EnvironmentVariables environmentVariables;

    @Step("Go to login page")
    public void pageUrl() {
        endpointBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");
        openUrl(endpointBaseUrl);
    }

    @Step("Login as {0}")
    public void as(User user) {
        $(LoginForm.USER_NAME).sendKeys(user.getUsername());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }

    @Step("Login with username {0} and password {1}")
    public void with(String username, String password) {
        $(LoginForm.USER_NAME).sendKeys(username);
        $(LoginForm.PASSWORD).sendKeys(password);
        $(LoginForm.LOGIN_BUTTON).click();
    }


}
