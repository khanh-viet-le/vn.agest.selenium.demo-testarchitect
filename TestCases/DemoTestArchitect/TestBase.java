package DemoTestArchitect;

import Constants.AppConstant;
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
