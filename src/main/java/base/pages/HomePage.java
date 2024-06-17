package base.pages;

import base.utils.WebDriverActions;
import constants.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public final String HOME_PAGE_TITLE = "Swag Labs";

    public HomePage() {
        waitForLoad();
    }

    @Override
    public void waitForLoad() {
        WebDriverActions.waitForElementToBeVisible(homeButton);
    }

    @FindBy(className = "app_logo")
    private WebElement homeButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(xpath = ".//img[@alt = 'Sauce Labs Backpack']")
    private WebElement imageProduct1;

    @FindBy(xpath = ".//img[@alt = 'Sauce Labs Bolt T-Shirt']")
    private WebElement imageProduct2;

    @FindBy(xpath = ".//div[@class='inventory_item']//button")
    private WebElement addItemToCartButton;

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    @FindBy(id = "first-name")
    private WebElement firstNAmeField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalcode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement openMenuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement completeHeaderText;


    public Boolean isShoppingCartClickable() {
        waitTimePage();
        return WebDriverActions.isElementClickable(By.className("shopping_cart_link"));
    }

    public String getAttributeText() {
        WebElement element = webDriver.findElement(By.xpath(".//img[@alt = 'Sauce Labs Backpack']"));
        return element.getAttribute("src");
    }

    public String getAttributeTextSecond() {
        WebElement element = webDriver.findElement(By.xpath(".//img[@alt = 'Sauce Labs Bolt T-Shirt']"));
        return element.getAttribute("src");
    }

    public void waitTimePage() {
        WebDriverActions.waitForElementToBeClickable(shoppingCart);
    }

    public void addItemToCart() {
        addItemToCartButton.click();
    }

    public void openCart() {
        shoppingCart.click();
    }

    public void checkOut() {
        checkOutButton.click();
    }

    public void fillOutWithSpecificCredentials(String name, String lastname, String zipcode) {
        firstNAmeField.sendKeys(name);
        lastNameField.sendKeys(lastname);
        postalcode.sendKeys(zipcode);
    }

    public void fillOutWithStandardCredentials() {
        firstNAmeField.sendKeys(Variables.USER_FIRSTNAME_ONE.getValue());
        lastNameField.sendKeys(Variables.USER_LASTNAME_ONE.getValue());
        postalcode.sendKeys(Variables.ZIP_CODE_ONE.getValue());
    }

    public Boolean isFirstNameEditable() {
        return !firstNAmeField.getAttribute("value").isEmpty();
    }

    public Boolean isLastNameNotEditable() {
        return lastNameField.getAttribute("value").isEmpty();
    }

    public Boolean isZipCodeEditable() {
        return !postalcode.getAttribute("value").isEmpty();
    }

    public Integer verifyCheckoutButtonLocation() {
        WebElement element = webDriver.findElement(By.id("checkout"));
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        System.out.println("x " + x);
        System.out.println("y " + y);
        System.out.println("x + y " + x + y);
        return x + y;
    }

    public void logOut() {
        openMenuButton.click();
        logOutButton.click();
    }

    public void selectContinue() {
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }

    public String getHeaderText() {
        return completeHeaderText.getText();
    }
}












