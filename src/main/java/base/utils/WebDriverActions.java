package base.utils;

import base.pages.BasePage;
import base.webdriver.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverActions {

    private static final Logger log = Logger.getLogger(BasePage.class);

    private WebDriverActions() {
    }


    public static void clickElement(final WebElement webElement) {
        log.info("Wait for element to be clickable : " + webElement);
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void clearAndInputText(final WebElement webElement, final String text) {
        log.info("Clear and send text '" + text + "' to a field");
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static Boolean isElementClickable(final By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement.isEnabled();
    }

    public static void waitForElementToBeVisible(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementToBeClickable(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofSeconds(1)).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
