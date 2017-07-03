package busuu.pageobjectmodel;

import busuu.driver.WebDriver;
import busuu.utils.Timer;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

    public static final String URL = "https://www.busuu.com/en/login";
    private String emailFieldId = "login-form-email";
    private String passwordFieldId = "login-form-password";
    private String loginBtnId = "login-form-submit";
    private String loginErrorXPath = "//*[@id=\"error-generic\"]/span[2]";

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void populateEmailField(String string) {
        WebElement emailField = waitForEmailField();
        waitForDisplayed(emailField, "emailField");
        emailField.sendKeys(string);
    }

    public WebElement waitForEmailField() {
        return waitForElementById(emailFieldId);
    }

    public boolean isEmailFieldPresent() {
        return isPresentById(emailFieldId);
    }

    public void populatePasswordField(String string) {
        WebElement passwordField = waitForPasswordField();
        waitForDisplayed(passwordField, "passwordField");
        passwordField.sendKeys(string);
    }

    public boolean isPasswordFieldPresent() {
        return isPresentById(emailFieldId);
    }

    public WebElement waitForPasswordField() {
        return waitForElementById(passwordFieldId);
    }

    public void clickLoginBtn() {
        waitAndClick(waitForLoginBtn(), "LoginButton");
    }

    public boolean isLoginBtnPresent() {
        return isPresentById(loginBtnId);
    }

    public WebElement waitForLoginBtn() {
        return waitForElementById(loginBtnId);
    }

    public String getLoginErrorText() {
        return waitForLoginError().getText();
    }

    public void waitForLoginTextToBe(String expectedText) {
        Timer timer = new Timer(ELEMENT_WAIT_TIME_IN_SECS);
        while(!timer.expired() && !getLoginErrorText().equals(expectedText)) {
            Timer.pause(500);
        }

        if(timer.expired()) {
            System.out.println("Login text was not [" + expectedText + "] after ["
                    + ELEMENT_WAIT_TIME_IN_SECS + "] seconds");
        }
    }

    public boolean isLoginErrorPresent() {
        return isPresentByXPath(loginErrorXPath);
    }

    public WebElement waitForLoginError() {
        return waitForElementByXPath(loginErrorXPath);
    }
}
