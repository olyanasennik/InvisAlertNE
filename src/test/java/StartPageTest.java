
import base.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import jdk.jfr.Description;

public class StartPageTest extends BaseTest {
    public StartPage startPage;


    @Test
    @Description("Check Start page is opened")
    public void loginSwagLabs() {

        startPage = new StartPage();
        Assert.assertEquals(startPage.getPageTitle(), startPage.HOME_PAGE_TITLE);
    }
}