package DemoTestArchitect;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class CheckoutTest {
    //SECTION Declare page objects using in test

    //SECTION Declare data, object, properties using in test

    //SECTION System methods

    //SECTION Test list

    @Test(description = "Verify Error Handling for Mandatory Checkout Fields")
    public void TC_06() {
        Allure.step("Preconditions: User is at checkout");
        Allure.step("1. Leave mandatory fields (address, payment info) blank");
        Allure.step("2. Click \"Confirm Order\"");
        Allure.step("3. Verify error messages", () -> {
            // - System should highlight missing fields and show an error message
        });
    }


    @Test(description = "Verify Guest User Can Complete Checkout")
    public void TC_08() {
        Allure.step("Preconditions: Products in cart");
        Allure.step("1. Navigate to Cart");
        Allure.step("2. Click \"Proceed to Checkout\"");
        Allure.step("3. Fill in billing details:\n"+
            "\t- First name" +
            "\t- Last name" +
            "\t- Address" +
            "\t- City" +
            "\t- Postcode" +
            "\t- Phone" +
            "\t- Email");
        Allure.step("4. Select payment method");
        Allure.step("5. Place order", () -> {
            // - Order should be placed successfully
            // - Order confirmation should be displayed
            // - Order number should be generated
        });
    }
}
