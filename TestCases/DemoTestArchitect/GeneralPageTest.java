package DemoTestArchitect;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class GeneralPageTest extends TestBase {
    //SECTION Declare page objects using in test

    //SECTION Declare data, object, properties using in test

    //SECTION System methods

    //SECTION Test list

    @Test(description = "Verify Homepage Elements Are Visible")
    public void TC01() {
        Allure.step("1. Navigate to https://demo.testarchitect.com/");
        Allure.step("2. Close popup notifications");
        Allure.step("3. Accept cookie notice");
        Allure.step("4. Verify header section elements:\n"+
            "\t- Phone number \"(+1800) 000 8808\n" +
            "\t- Address \"1730 S. Amphlett Blvd. Suite 200, San Mateo, CA", () -> {
            // - All mentioned elements should be visible
        });

        Allure.step("5. Verify top navigation elements:\n"+
            "\t- Login/Sign up link\n" +
            "\t- Social media icons (Pinterest, Instagram, Twitter, Facebook)", () -> {
            // - All links should be clickable
        });

        Allure.step("6. Verify main navigation menu:\n"+
            "\t- Home\n"+
            "\t- About Us\n"+
            "\t- Shop\n"+
            "\t- Offers\n"+
            "\t- Blog\n"+
            "\t- Contact Us", () -> {
            // - Header information should be correctly displayed
        });
    }

    @Test(description = "Verify Main Menu Categories Navigate Correctly")
    public void TC02() {
        Allure.step("1. Navigate to https://demo.testarchitect.com/");
        Allure.step("2. Close any popup notifications if present");
        Allure.step("3. Accept cookie notice if present.");
        Allure.step("4. Locate the search bar in the header");
        Allure.step("5. Click on the category dropdown");
        Allure.step("6. Select \"All categories\"");
        Allure.step("7. Enter \"camera\" in the search field");
        Allure.step("8. Click the search button");
        Allure.step("9. Observe search results page", () -> {
            // - Search results should load
            // - URL should contain search term "s=watch"
            // - Products related to "camera" should be displayed
        });
    }

    @Test(description = "Verify Main Menu Categories Navigate Correctly")
    public void TC03() {
        Allure.step("Preconditions: Homepage is loaded");

        Allure.step("1. Hover over \"All departments\" menu");
        Allure.step("2. Verify all main categories are present:\n" +
            "\t- Automobiles & Motorcycles\n" +
            "\t- Car Electronics\n" +
            "\t- Mobile Phone Accessories\n" +
            "\t- Computer & Office\n" +
            "\t- Tablet Accessories\n" +
            "\t- Consumer Electronics\n" +
            "\t- Electronic Components & Supplies\n" +
            "\t- Phones & Telecommunication\n" +
            "\t- Watches", () -> {
            // - All categories should be visible in the menu
        });
        Allure.step("3. Click each category and verify navigation", () -> {
            // - Clicking each category should navigate to correct page
        });
    }
}
