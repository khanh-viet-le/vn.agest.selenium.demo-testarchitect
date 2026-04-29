package DemoTestArchitect;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class RegisterTest {

    //SECTION Declare page objects using in test

    //SECTION Declare data, object, properties using in test

    //SECTION System methods

    //SECTION Test list

    @Test(description = "Verify New User Can Register Successfully")
    public void TC_09() {
        Allure.step("Preconditions:\n"+
            "\t- Homepage is loaded"+
            "\t- User is not logged in");

        Allure.step("1. Click \"Log in / Sign up\" link");
        Allure.step("2. Locate the registration form");
        Allure.step("3. Enter a valid email address");
        Allure.step("4. Click the \"Register\" button");
        Allure.step("5. Verify that the account is created successfully", () -> {
            // - Registration completes successfully
            // - User is automatically logged in after registration
            // - My Account dashboard is displayed
        });
        Allure.step("6. Check the user’s email for a password set link", () -> {
            // - Password set email is received by the user
        });
        Allure.step("7. Use the link to set a password");
        Allure.step("8. Verify the user can log in with the newly created account", () -> {
            // - User can log in using the newly set password
        });
    }

}
