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
public class HomePage extends BasePage {

	private By header =By.cssSelector("h5[class*='Heading-sc-9dtc71']");//("/html/body/div[3]/div/div/div/div/section/div/div/main/div/div/div/div[1]/div/div[2]/h3/i18n-string");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getHomePageTitle()
	{
		return getPageTitle();
	}

	public String getHomePageHeader()
	{
		return getPageHeader(header);
	}

}
