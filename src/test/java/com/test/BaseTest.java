package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.selenium.BasePage;
import com.selenium.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUptest(String browser) {
		if (browser.equals("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\App\\Drivers\\chromedriver_win32\\chromedriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			ChromeOptions opt = new ChromeOptions();
			opt.merge(cap);
			driver = new ChromeDriver(opt);
			// driver=new ChromeDriver(); driver.manage().window().maximize();

			/*
			 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
			 * driver.manage().window().maximize();
			 */
		} else if (browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}

		else {

			System.out.println("no driver found");
		}
		driver.get("https://app.hubspot.com/login");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page = new BasePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
