package base.pages;

import base.utils.WebDriverActions;
import constants.LoginNames;
import constants.PasswordData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {
    public HomePage homePage;
    public final String HOME_PAGE_TITLE = "Swag Labs";

    public StartPage() {
        waitForLoad();
    }

    @Override
    public void waitForLoad() {
        WebDriverActions.waitForElementToBeVisible(homeButton);
    }


    @FindBy(xpath = ".//div[@class = 'login_logo']")
    private WebElement homeButton;


    @FindBy(id = "user-name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = ".//h3[@data-test = 'error']")
    private WebElement loginErrorMessage;

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public HomePage loginSwagLabs(final String user) {

        WebDriverActions.clearAndInputText(loginField, user);
        WebDriverActions.clearAndInputText(passwordField, PasswordData.PASSWORD.getValue());
        WebDriverActions.clickElement(loginButton);
        return new HomePage();
    }

    public StartPage loginSwagLabsWithLockedOutUser() {

        WebDriverActions.clearAndInputText(loginField, LoginNames.LOCKED_OUT_USER.getValue());
        WebDriverActions.clearAndInputText(passwordField, PasswordData.PASSWORD.getValue());
        WebDriverActions.clickElement(loginButton);
        return new StartPage();
    }
}
