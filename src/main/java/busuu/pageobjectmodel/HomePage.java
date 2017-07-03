package busuu.pageobjectmodel;

import busuu.driver.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    public static final String URL = "https://www.busuu.com/";
    private String loginBtnXPath = "//*[@id=\"main-wrapper\"]/div[1]/header/div/nav/div/div[1]/a[2]";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickLoginBtn() {
        waitAndClick(waitForLoginBtn(), "LoginButton");
    }

    public boolean isLoginBtnPresent() {
        return isPresentByXPath(loginBtnXPath);
    }

    public WebElement waitForLoginBtn() {
        return waitForElementByXPath(loginBtnXPath);
    }
}
