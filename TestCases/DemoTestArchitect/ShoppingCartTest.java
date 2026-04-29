package DemoTestArchitect;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class ShoppingCartTest {

    //SECTION Declare page objects using in test

    //SECTION Declare data, object, properties using in test

    //SECTION System methods

    //SECTION Test list

    @Test(description = "Verify Product Can Be Added to Shopping Cart")
    public void TC04() {
        Allure.step("Preconditions: User is on shop page");

        Allure.step("1. Navigate to Shop page");
        Allure.step("2. Select any available product");
        Allure.step("3. Click \"Add to Cart\" button");
        Allure.step("4. Verify cart notification", () -> {
            // - Success message should appear
        });
        Allure.step("5. Check cart icon update", () -> {
            // - Product should be added to cart
            // - Cart count should increase
            // - Cart total should update
        });
    }

    @Test(description = "Verify Product Quantity Can Be Updated in Cart")
    public void TC_05() {
        Allure.step("Preconditions: Product is in cart");
        Allure.step("1. Navigate to Cart page");
        Allure.step("2. Locate quantity field");
        Allure.step("3. Change quantity to 2");
        Allure.step("4. Click \"Update Cart\" button");
        Allure.step("5. Verify cart updates", () -> {
            // - Quantity should update
            // - Cart total should recalculate
            // - Update message should appear
        });
    }

    @Test(description = "Verify Users Can Clear the Shopping Cart")
    public void TC_07() {
        Allure.step("Preconditions: User added the items into cart");
        Allure.step("1. Open browser and go to https://demo.testarchitect.com/");
        Allure.step("2. Login with valid credentials");
        Allure.step("3. Go to Shopping cart page");
        Allure.step("4. Verify items show in table");
        Allure.step("5. Click on Clear shopping cart");
        Allure.step("6. Verify empty cart page displays", () -> {
            // - YOUR SHOPPING CART IS EMPTY displays
        });
    }
}
