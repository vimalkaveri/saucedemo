package basicetest;


import org.testng.Assert;
import org.testng.annotations.*;

import scenario.LoginModule;

public class LoginTest extends LoginModule{
	
	@Test(priority=1,description="verify the valide user")
	public void TC001() {
		username("standard_user");
		password("secret_sauce");
		login();
		menu();
		logout();
	}
	
    @Test(priority = 2, description = "Verify that uppercase username is not allowed")
    public void TC002() {
        username("STANDARD_USER");
        password("secret_sauce");
        login();

        // Expected error message when login fails due to case sensitivity
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = getErrorMessage();

        // Verify that the correct error message is displayed
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message did not match!");
    }
    @Test(priority = 3, description = "Verify that locked out user is not allowed")
    public void TC003() {
    	username("locked_out_user");
        password("secret_sauce");
        login();

        // Expected error message when login fails due to case sensitivity
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = getErrorMessage();

        // Verify that the correct error message is displayed
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message did not match!");
    }

}
