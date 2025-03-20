package scenario;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import base.Browser;

public class LoginModule extends Browser {
	By userLocater = By.id("user-name");
	By passwordLocater = By.id("password");
	By loginLocater = By.id("login-button");
	By menuLocater = By.id("react-burger-menu-btn");
	By logoutLocater = By.id("logout_sidebar_link");
	By errorLocater = By.cssSelector("[data-test='error']"); // Locator for error message

	public void username(String name) {
		WebElement userName = driver.findElement(userLocater);
		userName.clear();
		userName.sendKeys(name);
	}

	public void password(String userpassword) {
		WebElement password = driver.findElement(passwordLocater);
		password.clear();
		password.sendKeys(userpassword);
	}

	public void login() {
		WebElement loginbutton = driver.findElement(loginLocater);
		loginbutton.click();
	}

	public void menu() {
		WebElement menuButton = driver.findElement(menuLocater);
		menuButton.click();
	}

	public void logout() {
		WebElement logout = driver.findElement(logoutLocater);
		logout.click();
	}

	public String getErrorMessage() {
		WebElement errorMsg = driver.findElement(errorLocater);
		return errorMsg.getText();
	}

}
