package basicetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import scenario.ProductListingModule;

public class ProductListingTest extends ProductListingModule {

	WebDriverWait wait;

	@BeforeClass
	public void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test(priority = 1, description = "Verify the product list (inventory)")
	public void TC_PL_001() {
		List<WebElement> products = driver.findElements(By.className("inventory_item"));
		Assert.assertTrue(products.size() > 0, "No products found!");

		for (WebElement product : products) {
			WebElement productName = product.findElement(By.className("inventory_item_name"));
			WebElement productDescription = product.findElement(By.className("inventory_item_desc"));
			WebElement productPrice = product.findElement(By.className("inventory_item_price"));
			WebElement productImage = product.findElement(By.className("inventory_item_img"));

			System.out.println("->Product: " + productName.getText() + "\n  Product Description: "
					+ productDescription.getText() + "\n  Price: " + productPrice.getText());

			Assert.assertFalse(productName.getText().isEmpty(), "Product name is missing!");
			Assert.assertFalse(productDescription.getText().isEmpty(), "Product Description is missing!");
			Assert.assertFalse(productPrice.getText().isEmpty(), "Product price is missing!");
			Assert.assertTrue(productImage.isDisplayed(), "Product image is not displayed!");
		}
	}

	@Test(priority = 2, description = "clickToProductVerify")
	public void TC_PL_002() {
		driver.findElement(By.xpath("//div[normalize-space(text())='Sauce Labs Backpack']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']")).getText());
		System.out.println(driver.findElement(By.className("inventory_details_price")).getText());
		driver.findElement(By.id("back-to-products")).click();
	}

	@Test(priority = 3, description = "to verfiy product sort container")
	public void TC_PL_003() {

		WebElement container = driver.findElement(By.tagName("select"));// .click();
		Select sel = new Select(container);
		sel.selectByIndex(3);
		List<WebElement> products = driver.findElements(By.className("inventory_item"));
		Assert.assertTrue(products.size() > 0, "No products found!");

		for (WebElement product : products) {
			WebElement productName = product.findElement(By.className("inventory_item_name"));
			WebElement productDescription = product.findElement(By.className("inventory_item_desc"));
			WebElement productPrice = product.findElement(By.className("inventory_item_price"));
			WebElement productImage = product.findElement(By.className("inventory_item_img"));

			System.out.println("->Product: " + productName.getText() + "\n  Product Description: "
					+ productDescription.getText() + "\n  Price: " + productPrice.getText());

			Assert.assertFalse(productName.getText().isEmpty(), "Product name is missing!");
			Assert.assertFalse(productDescription.getText().isEmpty(), "Product Description is missing!");
			Assert.assertFalse(productPrice.getText().isEmpty(), "Product price is missing!");
			Assert.assertTrue(productImage.isDisplayed(), "Product image is not displayed!");
		}
	}
}
