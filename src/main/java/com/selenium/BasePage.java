package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		// TODO Auto-generated method stub
		
		waitForElementPresent(locator);
		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		WebElement element=null;
		try {
			element=driver.findElement(locator);
			return element;
		}
		catch(Exception e)
		{
			System.out.println("catch message "+locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {

try {
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
}
catch(Exception e)
{
	System.out.println("exception message "+ locator.toString());
	
}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			
		}
		catch(Exception e)
		{
			System.out.println("exception message "+ title);
			
		}
	}
	

}
