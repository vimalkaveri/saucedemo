package basicetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
			WebElement productPrice = product.findElement(By.className("inventory_item_price"));
			WebElement productImage = product.findElement(By.className("inventory_item_img"));

			System.out.println("Product: " + productName.getText() + " - Price: " + productPrice.getText());

			Assert.assertFalse(productName.getText().isEmpty(), "Product name is missing!");
			Assert.assertFalse(productPrice.getText().isEmpty(), "Product price is missing!");
			Assert.assertTrue(productImage.isDisplayed(), "Product image is not displayed!");
		}
	}

	@Test(priority = 2, description = "Add product to cart and verify")
	public void addToCartAndVerify() {
		WebElement addToCartBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
		addToCartBtn.click();

		WebElement cartBadge = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
		Assert.assertEquals(cartBadge.getText(), "1", "Cart does not show correct item count!");

		WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
		cartIcon.click();

		WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_item")));
		Assert.assertTrue(cartItem.isDisplayed(), "Product not found in cart!");
	}
}
