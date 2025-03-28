package scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CardModule extends LoginModule {
	
	By cartBadgeLocater = By.xpath("//a[@class='shopping_cart_link']//span[1]");
	By cardLocater = By.xpath("//div[@id='shopping_cart_container']//a[1]");

	By continueShipLocater = By.xpath("//button[@id='continue-shopping']");// continue Ship Locater

	// Check out butten locaters
	By checkoutLocater = By.xpath("//button[@data-test='checkout']");
	By firstNameLocater = By.xpath("//input[@id='first-name']");
	By lastNameLocater = By.xpath("//input[@id='last-name']");
	By postalCodeLocater = By.xpath("//input[@id='postal-code']");
	By continueLocater = By.xpath("//input[@id='continue']");
	By cancelLocater = By.xpath("//input[@id='cancel']");

	// remove button
	By removeLocater = By.xpath("(//div[@class='item_pricebar']//button)[1]");

	@BeforeClass
	public void loginApp() {
		username("standard_user");
		password("secret_sauce");
		login();
	}
	public void addCard(int index) {
	    By addCardLocator = By.xpath("(//button[contains(@class,'btn btn_primary')])[" + index + "]");
	    driver.findElement(addCardLocator).click();
	}


	public void cardBadge() {
		WebElement cardcount = driver.findElement(cartBadgeLocater);
		String count = cardcount.getText();
		System.out.println(count);
	}

	public void card() {
		driver.findElement(cardLocater).click();
	}

	public void continueShip() {
		driver.findElement(continueShipLocater).click();
	}

	public void checkout() {
		driver.findElement(checkoutLocater).click();
	}

	public void firstName(String name) {
		driver.findElement(firstNameLocater).sendKeys(name);
	}

	public void lasttName(String name) {
		driver.findElement(firstNameLocater).sendKeys(name);
	}

	public void postalCode(String name) {
		driver.findElement(firstNameLocater).sendKeys(name);
	}

	public void continuebutton() {
		driver.findElement(continueLocater).click();
	}

	public void cancel() {
		driver.findElement(cancelLocater).click();
	}

	public void remove() {
		driver.findElement(removeLocater).click();
	}

	public void productList() {
		List<WebElement> products = driver.findElements(By.className("inventory_item"));
		Assert.assertTrue(products.size() > 0, "No products found!");

		for (WebElement product : products) {
			WebElement productName = product.findElement(By.className("inventory_item_name"));
			WebElement productDescription = product.findElement(By.className("inventory_item_desc"));
			WebElement productPrice = product.findElement(By.className("inventory_item_price"));
			WebElement productQuantity = product.findElement(By.className("cart_quantity"));
			WebElement productImage = product.findElement(By.className("inventory_item_img"));

			System.out.println("->Product: " + productName.getText() + "\n  Product Description: "
					+ productDescription.getText() + "\n  Price: " + productPrice.getText());

			Assert.assertFalse(productName.getText().isEmpty(), "Product name is missing!");
			Assert.assertFalse(productDescription.getText().isEmpty(), "Product Description is missing!");
			Assert.assertFalse(productPrice.getText().isEmpty(), "Product price is missing!");
			Assert.assertFalse(productQuantity.getText().isEmpty(), "Product price is missing!");
			Assert.assertTrue(productImage.isDisplayed(), "Product image is not displayed!");
		}
	}

	@AfterClass
	public void logoutApp() {
		menu();
		logout();
	}

}
