package DemoTestArchitect;

import Constants.AppConstant;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

import java.time.LocalDateTime;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    //SECTION Declare page objects to use in tests

    //SECTION Declare business flows to use in tests

    //SECTION System methods

    /**
     * Set up the test environment before each test method
     *
     * @param browser String
     */
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser) {
        setBrowser(browser);

        if (AppConstant.SCREEN_SIZE != null) {
            setWindowSize(AppConstant.SCREEN_SIZE);
        } else {
            maximizeWindow();
        }
    }

    /**
     * Teardown the test environment after each test method
     */
    @AfterMethod
    public void afterMethod() {
        quitBrowser();
        AppConstant.WEBDRIVER = null;
    }

    /**
     * Set the global browser for the application
     * @param browser
     */
    private void setBrowser(String browser) {
        String runBrowser = System.getProperty("browser", browser);

        switch (runBrowser.toLowerCase().trim()) {
            case "chrome":
                AppConstant.WEBDRIVER = new ChromeDriver();
                break;

            case "edge":
                AppConstant.WEBDRIVER = new EdgeDriver();
                break;

            case "firefox":
                AppConstant.WEBDRIVER = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException(String.format("Browser \"%s\" not supported", runBrowser));
        }
    }

    /**
     * Quit the browser
     */
    private void quitBrowser() {
        if (AppConstant.WEBDRIVER != null) {
            AppConstant.WEBDRIVER.quit();
        }
    }


    /**
     * Maximize the window of the browser
     */
    private void maximizeWindow() {
        AppConstant.WEBDRIVER.manage().window().maximize();
    }

    /**
     * Set the window size of the browser
     * @param size
     */
    private void setWindowSize(Dimension size) {
        AppConstant.WEBDRIVER.manage().window().setSize(size);
    }


    /**
     * Print step for report
     * @param name
     * @param runnable
     */
    protected void step(String name, Runnable runnable) {
        Allure.step(name, () -> {
            runnable.run();
        });
    }

    /**
     * Print step for report without runnable
     * @param name
     */
    protected void step(String name) {
        Allure.step(name);
    }

    /**
     * Print step for report with status
     * @param name
     * @param status
     */
    protected void step(String name, Status status) {
        Allure.step(name, status);
    }

    /**
     * Print log for report
     * @param name
     * @param message
     */
    protected void log(String message) {
        Allure.addAttachment(String.format("LOG at %s", LocalDateTime.now().toString()), message);
    }

     /**
     * Print log for report
     * @param name
     * @param message
     */
    protected void log(String name, String message) {
        Allure.addAttachment(name, message);
    }

    //SECTION Common flows methods
    /**
     * Login to the application with the provided account
     * @param account
     */
    protected void login(Object account) {

    }

    /**
     * Register a new account with the provided account
     * @param account
     */
    protected void register(Object account) {}

    /**
     * Close the popup ad if it exists
     */
    protected void closeAdPopup() {

    }

    /**
     * Accept the cookie if it exists
     */
    protected void acceptCookie() {

    }
}
