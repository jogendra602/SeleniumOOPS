package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.HomePage;
import com.selenium.LoginPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void verifyLoginPageTitle() {
		String title = page.getInstance(LoginPage.class).getLogionPageTitle();
		System.out.println("Login page title:  " + title);
		Assert.assertEquals(title, "HubSpot Login");
	}

	@Test(priority = 2, enabled = true)
	public void verifyLoginPageHeader() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println("Login page header:  " + header);
		Assert.assertEquals(header, "Don't have an account?");
	}

	@Test(priority = 3, enabled = true)
	public void verifyLogin() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("jogendra602@gmail.com", "Test1234@5");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String headerHome = homePage.getHomePageHeader();
		System.out.println("Home page header : " + headerHome);
		Assert.assertEquals(headerHome, "Do these tasks to start using your new tools.");
	}
}
