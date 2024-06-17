
import base.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getInstance().getDriver();
        driver.navigate().to("https://qa-challenge.codesubmit.io/");

    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
