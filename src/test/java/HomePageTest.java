import base.pages.*;
import constants.LoginNames;
import constants.Variables;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    public StartPage startPage;

    public HomePage homePage;

    @Test
    @Description("Check if standard_user is able to login and interact with shopping cart")
    public void loginTest() {

        startPage = new StartPage();
        startPage.loginSwagLabs(LoginNames.STANDARD_USER.getValue());
        homePage = new HomePage();

        Assert.assertTrue(homePage.isShoppingCartClickable(), "Error:Shopping Cart is not clickable");
    }

    @Test
    @Description("Check if locked_out_user is able to login")
    public void errorMessageLoginTest() {

        startPage = new StartPage();
        startPage.loginSwagLabsWithLockedOutUser();

        Assert.assertEquals(startPage.getLoginErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    @Description("Check if problem_user is able to see correct images for items, description vs image")
    public void imageVisibilityTest() {

        startPage = new StartPage();
        startPage.loginSwagLabs(LoginNames.PROBLEM_USER.getValue());
        homePage = new HomePage();
        String imageFirstText = homePage.getAttributeText();
        String imageSecondText = homePage.getAttributeTextSecond();

        Assert.assertEquals(imageFirstText, imageSecondText, "Images are not equal");
    }

    @Test
    @Description("Check the time of loading pages for perfomance_user/Check each second within 5 second period if the user is logged in")
    public void loadTimeTest() {

        startPage = new StartPage();
        startPage.loginSwagLabs(LoginNames.PERFOMANCE_GLITCH_USER.getValue());
        homePage = new HomePage();

        Assert.assertTrue(homePage.isShoppingCartClickable(), "Error:Shopping Cart is not clickable");
    }

    @Test
    @Description("Check if values for first/last name and postal code are editable")
    public void valuesNameFieldsTest() {

        startPage = new StartPage();
        startPage.loginSwagLabs(LoginNames.ERROR_USER.getValue());
        homePage = new HomePage();
        homePage.addItemToCart();
        homePage.openCart();
        homePage.checkOut();
        homePage.fillOutWithSpecificCredentials(Variables.USER_FIRSTNAME_ONE.getValue(), Variables.USER_LASTNAME_ONE.getValue(), Variables.ZIP_CODE_ONE.getValue());

        Assert.assertTrue(homePage.isFirstNameEditable(), "User is Not able to edit FirstName field");
        Assert.assertTrue(homePage.isLastNameNotEditable(), "User is able to edit LastName field");
        Assert.assertTrue(homePage.isZipCodeEditable(), "User is Not able to edit ZIPcode field");
    }

    @Test
    @Description("Check the location of the checkout Button on the page")
    public void visualUserTest() {

        startPage = new StartPage();
        startPage.loginSwagLabs(LoginNames.STANDARD_USER.getValue());
        homePage = new HomePage();
        homePage.addItemToCart();
        homePage.openCart();
        int s1 = homePage.verifyCheckoutButtonLocation();
        homePage.logOut();

        startPage.loginSwagLabs(LoginNames.VISUAL_USER.getValue());
        homePage = new HomePage();
        homePage.addItemToCart();
        homePage.openCart();
        int v2 = homePage.verifyCheckoutButtonLocation();

        Assert.assertNotEquals(s1, v2, "Location of checkout buttons for standard and visual users is equal");
    }

    @Test
    @Description("Complete the purchase")
    public void completePayment() {

        startPage = new StartPage();
        startPage.loginSwagLabs(LoginNames.STANDARD_USER.getValue());
        homePage = new HomePage();
        homePage.addItemToCart();
        homePage.openCart();
        homePage.checkOut();
        homePage.fillOutWithStandardCredentials();
        homePage.selectContinue();
        homePage.finishCheckout();
        String expectedHeaderText = "Thank you for your order!";
        String actualHeaderText = homePage.getHeaderText();

        Assert.assertEquals(actualHeaderText, expectedHeaderText, "The purchase is Not completed");
    }
}
