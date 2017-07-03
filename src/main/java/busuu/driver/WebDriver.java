package busuu.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriver {

    private ChromeDriver chromeDriver;
    private ChromeOptions chromeOptions;

    public WebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        chromeOptions = new ChromeOptions();
        //Fullscreen for chrome
        chromeOptions.addArguments("--kiosk");
    }

    public RemoteWebDriver getChromeDriver() {
        return this.chromeDriver;
    }

    private void initWebDriver() {
        chromeDriver = new ChromeDriver(chromeOptions);
    }

    public void goTo(String url) {
        chromeDriver.navigate().to(url);
    }

    public void launchBrowser() {
        initWebDriver();
        chromeDriver.manage().deleteAllCookies();
    }

    public void closeBrowser() {
        chromeDriver.quit();
    }

}
