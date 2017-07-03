package busuu;

import busuu.driver.WebDriver;
import busuu.pageobjectmodel.HomePage;
import busuu.pageobjectmodel.InitialSplashPage;
import busuu.pageobjectmodel.LoginPage;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class AbstractTestCase {

    protected final Logger logger = Logger.getLogger(getClass());
    protected static WebDriver webDriver;

    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static InitialSplashPage initialSplashPage;

    static {
        webDriver = new WebDriver();
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        initialSplashPage = new InitialSplashPage(webDriver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("Executing Test Case: [" + method.getName() + "]");
        webDriver.launchBrowser();
    }

    @AfterMethod
    public void afterMethod(Method method) {
        logger.info("Ending Test Case: [" + method.getName() + "]");
        webDriver.closeBrowser();
    }
}
