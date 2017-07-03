package busuu;

import busuu.pageobjectmodel.HomePage;
import busuu.pageobjectmodel.InitialSplashPage;
import busuu.pageobjectmodel.LoginPage;
import org.testng.annotations.Test;

import static busuu.utils.TestStep.*;
import static org.testng.AssertJUnit.assertEquals;

@Test(groups = {"login"})
public class LoginTest extends AbstractTestCase {

    @Test
    public void homepage_shows_login_button() {

        WHEN("Home page is loaded");
        webDriver.goTo(HomePage.URL);

        THEN("Login button is present");
        assertEquals("Verifying that login button is present", true, homePage.isLoginBtnPresent());

        AND("Login button is displayed");
        assertEquals("Verifying that login button is visible", true, homePage.waitForLoginBtn().isDisplayed());

        AND("Login button is enabled");
        assertEquals("Verifying that login button is enabled", true, homePage.waitForLoginBtn().isEnabled());
    }

    @Test
    public void clicking_on_login_btn_goes_to_login_page() {

        GIVEN("Home page is loaded");
        webDriver.goTo(HomePage.URL);

        WHEN("Login button is clicked");
        homePage.clickLoginBtn();
        loginPage.waitForEmailField();

        THEN("Email field is present");
        assertEquals("Verifying that email field is present", true, loginPage.isEmailFieldPresent());

        AND("Password field is present");
        assertEquals("Verifying that password field is present", true, loginPage.isPasswordFieldPresent());

        AND("Login button is present");
        assertEquals("Verifying that loggin button is present", true, loginPage.isPasswordFieldPresent());

        AND("URL is correct");
        assertEquals("Verifying URL is correct", LoginPage.URL, webDriver.getChromeDriver().getCurrentUrl());
    }

    @Test(enabled = false)
    public void first_time_valid_login_takes_user_to_splash_page() {
        GIVEN("Login page is loaded");
        webDriver.goTo(LoginPage.URL);

        WHEN("email field is populated correctly");
        //TODO: fill in valid username
        loginPage.populateEmailField("");

        //TODO: fill in valid password
        AND("password field is populated correctly");
        loginPage.populatePasswordField("");

        AND("user clicks on the login button");
        loginPage.clickLoginBtn();
        initialSplashPage.waitForSplashTitle();

        THEN("Splash page title is shown");
        assertEquals("Verifying splash title is present", true, initialSplashPage.isSplashTitlePresent());

        AND("Splash title text is correct");
        assertEquals("Verifying splash title text is correct", "Great! Let's get started", initialSplashPage.getSplashTitleText());

        AND("URL is correct");
        assertEquals("Verifying URL is correct", InitialSplashPage.URL, webDriver.getChromeDriver().getCurrentUrl());
    }

    @Test
    public void invalid_login_credentials_show_error() {
        GIVEN("Login page is loaded");
        webDriver.goTo(LoginPage.URL);

        WHEN("email field is populated incorrectly");
        loginPage.populateEmailField("yolo@email.com");

        AND("password field is populated incorrectly");
        loginPage.populatePasswordField("faker");

        AND("user clicks on the login button");
        loginPage.clickLoginBtn();

        String expectedErrorText = "Sorry, unrecognized username or password [INVALID_CREDENTIALS]";
        loginPage.waitForLoginError();
        loginPage.waitForLoginTextToBe(expectedErrorText);

        THEN("Login error text is shown");
        assertEquals("Verifying login error is present", true, loginPage.isLoginErrorPresent());

        AND("Login error text is correct");
        assertEquals("Verifying that login error text is correct",
                expectedErrorText,
                loginPage.getLoginErrorText());

    }
}
