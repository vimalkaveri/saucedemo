package scenario;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ProductListingModule extends LoginModule{
	
	@BeforeClass
	public void loginApp() {
		username("standard_user");
		password("secret_sauce");
		login();
	}
	
	@AfterClass
	public void logoutApp() {
		menu();
		logout();
	}

}
