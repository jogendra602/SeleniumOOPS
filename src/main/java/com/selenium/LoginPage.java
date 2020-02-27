/**
 * 
 */
package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author JOJO
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By header = By.xpath("//*[@id=\"hs-login\"]/div[1]/i18n-string");

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLogionPageTitle() {
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getPageHeader(header);
	}

	public HomePage doLogin(String userName, String password) {
		getEmailId().sendKeys(userName);
		getPassword().sendKeys(password);

		getLoginButton().click();

		return getInstance(HomePage.class);

	}

}
