package busuu.pageobjectmodel;

import busuu.driver.WebDriver;
import org.openqa.selenium.WebElement;

public class InitialSplashPage extends AbstractPage {

    public static final String URL = "https://www.busuu.com/dashboard#/placement/splash";
    private String splashTitleXPath = "//*[@id=\"main-layout\"]/div/main/ui-view/div/h1";

    public InitialSplashPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isSplashTitlePresent() {
        return isPresentByXPath(splashTitleXPath);
    }

    public String getSplashTitleText() {
        return waitForSplashTitle().getText();
    }

    public WebElement waitForSplashTitle() {
        return waitForElementByXPath(splashTitleXPath);
    }
}
