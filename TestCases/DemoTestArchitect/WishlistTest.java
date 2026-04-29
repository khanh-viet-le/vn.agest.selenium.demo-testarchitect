package DemoTestArchitect;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class WishlistTest {
    //SECTION Declare page objects using in test


    //SECTION Declare data, object, properties using in test

    //SECTION System methods

    //SECTION Test list

    @Test(description = "Verify Product Can Be Added to Wishlist")
    public void TC_10() {
        Allure.step("Preconditions: User is logged in");
        Allure.step("1. Navigate to Shop page");
        Allure.step("2. Find a product");
        Allure.step("3. Click wishlist icon");
        Allure.step("4. Verify wishlist update", () -> {
            // - Product should be added to wishlist
            // - Wishlist count should increase
        });
        Allure.step("5. Navigate to Wishlist page", () -> {
            // - Product should appear in wishlist page
        });
    }
}
