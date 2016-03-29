package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import actionClass.RegisterAction;
import pageObjects.Login_Page;
import properties.LoadProperties;
import utility.Constants;

public class Regisration {
	WebDriver driver;
	static LoadProperties object = new LoadProperties();

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", Constants.chromepath);
		
		driver = new ChromeDriver();
		Log.info("Browser Launched");
		driver.get(object.getPropValues("URL"));
		Log.info("URL launched");

	}

	@SuppressWarnings("deprecation")
	@Test(priority=0)
	public void registrationCheck() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		Login_Page.register(driver).click();
		RegisterAction.Execute(driver);
		Log.info("Registration Successfull");
		String expected = "Hello, " + object.getPropValues("NewLoginname")+ " !";
		System.out.println("expected : "+expected);
		String actual = Login_Page.helloUsername(driver).getText();
		System.out.println("actual : "+actual);

		Assert.assertEquals(actual, expected);
		Log.info("Assertion successfull");
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	


	
	
	@SuppressWarnings("deprecation")
	@AfterTest
	public void afterTest() {
		driver.close();
		Log.info("Browser Closed");
	}

}
