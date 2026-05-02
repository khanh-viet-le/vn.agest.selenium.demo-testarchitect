package Common;

import Constants.AppConstant;
import Constants.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * This class includes all common actions using inside the application
 */
public class WebDriverUtilities {
    //SECTION Elements
    /**
     * Find the element with its locator
     * @param locator
     * @return WebElement
     */
    public static WebElement findElement(By locator) {
        return AppConstant.WEBDRIVER.findElement(locator);
    }

    /**
     * Find all elements with its locator
     * @param locator
     * @return WebElement
     */
    public static List<WebElement> findElements(By locator) {
        return AppConstant.WEBDRIVER.findElements(locator);
    }

    /**
     * Find the element with its xpath and arguments
     * The xpath will be recreated with arguments and the xpath pattern
     * @param xpathPatern String
     * @param args Objects
     * @return WebElement
     */
    public static WebElement findElement(String xpathPatern, Object... args) {
        return findElement(getElementLocator(xpathPatern, args));
    }

    /**
     * Find the list of elements with its xpath and arguments
     * The xpath will be recreated with arguments and the xpath pattern
     * @param xpathPatern String
     * @param args Objects
     * @return WebElement
     */
    public static List<WebElement> findElements(String xpathPatern, Object... args) {
        return findElements(getElementLocator(xpathPatern, args));
    }

    /**
     * Get the locator of the element by its xpath and arguments
     * The xpath will be recreated with arguments and the xpath pattern
     * @param xpathPatern
     * @param args
     * @return
     */
    public static By getElementLocator(String xpathPatern, Object... args) {
        return By.xpath(String.format(xpathPatern, args));
    }

    //SECTION Page & browser actions

    /**
     * Navigate to tha target url
     * @param url String
     */
    public static void open(String url) {
        AppConstant.WEBDRIVER.get(url);
    }


    /**
     * Reload the current page
     */
    public static void reload() {
        AppConstant.WEBDRIVER.navigate().refresh();
    }

    //SECTION Form actions

    /**
     * Clear the current value of the element
     * @param locator By
     */
    public static void clear(By locator) {
        waitForVisible(locator);
        scrollToElement(locator);
        findElement(locator).clear();
    }

    /**
     * Clear the current value of the element then enter the provided value
     * @param locator By
     * @param value string
     */
    public static void enter(By locator, String value) {
        clear(locator);
        findElement(locator).sendKeys(value);
    }


    /**
     * Click the element
     * @param locator By
     */
    public static void click(By locator) {
        waitForVisible(locator);
        scrollToElement(locator);
        waitForClickable(locator);
        findElement(locator).click();
    }

    /**
     * Click the element
     * @param locator By
     */
    public static void clickByJS(By locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) AppConstant.WEBDRIVER;
        jsExecutor.executeScript("arguments[0].click();",findElement(locator));
    }

    public static void selectByDisplayText(By locator, String text) {

    }

    public static void selectByIndex(By locator, int index) {

    }

    //SECTION Wait actions

    /**
     * Wait until the element is clickable
     * @param locator By
     * @param timeout int, in seconds
     * @return By
     */
    public static By waitForClickable(By locator, int timeout) {
        new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(timeout))
        .until(ExpectedConditions.elementToBeClickable(locator));

        return locator;
    }

    /**
     * Wait until the element is clickable with default timeout
     * @param locator By
     * @return By
     */
    public static By waitForClickable(By locator) {
        return waitForClickable(locator, Timeout.ELEMENT_CLICKABLE);
    }

    /**
     * Wait until the element is visible
     * @param locator By
     * @param timeout int, in seconds
     * @return By
     */
    public static By waitForVisible(By locator, int timeout) {
        new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(locator));

        return locator;
    }

    /**
     * Wait until the element is visible with default timeout
     * @param locator By
     * @return By
     */
    public static By waitForVisible(By locator) {
        return waitForVisible(locator, Timeout.ELEMENT_VISIBLE);
    }


    //SECTION Scroll actions

    /**
     * Scroll to the element
     * @param locator By
     */
    public static void scrollToElement(By locator) {
        scrollToElement(findElement(locator));
    }

    /**
     * Scroll to the element
     * @param element WebElement
     */
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecuter = (JavascriptExecutor) AppConstant.WEBDRIVER;
        jsExecuter.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
}
