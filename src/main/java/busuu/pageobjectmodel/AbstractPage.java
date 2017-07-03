package busuu.pageobjectmodel;

import busuu.driver.WebDriver;
import busuu.utils.Timer;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {

    protected static final int ELEMENT_WAIT_TIME_IN_SECS = 5;
    protected WebDriver webDriver;

    protected void waitAndClick(WebElement element, String elementName) {
        waitForDisplayed(element, elementName);
        element.click();
    }

    protected void waitForDisplayed(WebElement element, String elementName) {
        Timer timer = new Timer(ELEMENT_WAIT_TIME_IN_SECS);
        while(!timer.expired()) {
            if(element.isDisplayed()) {
                return;
            }
        }
        System.out.println("Warning, element with the name [" + elementName +
                "] was not displayed after [" + ELEMENT_WAIT_TIME_IN_SECS + "] seconds");
    }

    protected boolean isPresentById(String id) {
        try {
            webDriver.getChromeDriver().findElementById(id);
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isPresentByXPath(String xPath) {
        try {
            webDriver.getChromeDriver().findElementByXPath(xPath);
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    protected WebElement waitForElementById(String id) {
        Timer timer = new Timer(ELEMENT_WAIT_TIME_IN_SECS);
        WebElement element;
        while(!timer.expired()) {
            try {
                element = webDriver.getChromeDriver().findElementById(id);
                return element;
            } catch(NoSuchElementException e) {

            }
        }
        System.out.println("Warning, element with id [" + id +
                "] could not be found after [" + ELEMENT_WAIT_TIME_IN_SECS + "] seconds");
        return null;
    }

    protected WebElement waitForElementByXPath(String xPath) {
        Timer timer = new Timer(ELEMENT_WAIT_TIME_IN_SECS);
        WebElement element;
        while(!timer.expired()) {
            try {
                element = webDriver.getChromeDriver().findElementByXPath(xPath);
                return element;
            } catch(NoSuchElementException e) {

            }
        }
        System.out.println("Warning, element with xpath [" + xPath +
                "] could not be found after [" + ELEMENT_WAIT_TIME_IN_SECS + "] seconds");
        return null;
    }
}
