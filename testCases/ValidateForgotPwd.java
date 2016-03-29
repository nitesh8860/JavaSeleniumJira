package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgetPassword;
import pageObjects.Login_Page;
import properties.LoadProperties;
import utility.Constants;
import actionClass.ForgetPassAction;

public class ValidateForgotPwd {
	public WebDriver driver;
	static LoadProperties object = new LoadProperties();

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeTest() throws IOException {
		
			System.setProperty("webdriver.ie.driver", Constants.ieexplorer);
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(
			    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			    true);
			driver = new InternetExplorerDriver(caps);
			Log.info("Browser Launched");
			driver.get(object.getPropValues("URL"));
			Log.info("URL launched");	
			}

	@SuppressWarnings("deprecation")
	
	/*
	 * Click Forgot Password Link
	 * Enter valid Username
	 * Enter valid Email
	 * Click Reset
	 * Validate success message.
	 */
	@Test(priority=1)
	public void forgetPwd_CheckUsername() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		
		try{
			Login_Page.forgetPassLink(driver).click();
		
		ForgetPassword.forgetUsername(driver).sendKeys(object.getPropValues("LoginName"));
		ForgetPassword.forgetEmail(driver).sendKeys("abc@xyz.com");
		ForgetPassword.forgetResetBtn(driver).click();
		
		
		String expected = "http://10.66.38.52/MyApplication/Account/CustomManage";
		System.out.println("expected : "+expected);
		String actual = driver.getCurrentUrl();
		System.out.println("actual : "+actual);

		Assert.assertEquals(actual, expected);
		Log.info("Assertion successfull");
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	catch (Exception e)
	{
		throw(e);
	}

	}

	
	
	
	/*
	 * Click Forgot Password Link
	 * Enter invalid Username
	 * Click Reset
	 * Validate success message.
	 */
	
	@Test(priority=2)
	public void forgetPwd_invalidUserName() throws Exception
	{
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get(object.getPropValues("URL"));
		
		try{
		
		Login_Page.forgetPassLink(driver).click();
		ForgetPassword.forgetUsername(driver).sendKeys("test");
		ForgetPassword.forgetEmail(driver).sendKeys("abc@xyz.com");
		ForgetPassword.forgetResetBtn(driver).click();
		
		
		String expected = "http://10.66.38.52/MyApplication/Account/ForgetPassword";
		System.out.println("expected : "+expected);
		String actual = driver.getCurrentUrl();
		System.out.println("actual : "+actual);
		Assert.assertEquals(actual, expected);
		Log.info("Assertion successfull");
		//Warning Check
		String expectedWarn = "Username OR Email ID Not Correct.";
		System.out.println("expected : "+expected);
		String actualWarn = driver.findElement(ById.id("MainContent_lbltext")).getText();
		System.out.println("actual : "+actual);
		Assert.assertEquals(actualWarn, expectedWarn);
		Log.info("Assertion successfull");
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	catch (Exception e)
	{
		throw(e);
	}

		
	}
	
	
	/*
	 * Click Forgot Password Link
	 * Enter invalid Email
	 * Click Reset
	 * Validate success message.
	 */
	
	@Test(priority=3)
	public void forgetPwd_invalidEmail() throws Exception
	{
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get(object.getPropValues("URL"));
		
		try{
			Login_Page.forgetPassLink(driver).click();
			ForgetPassword.forgetUsername(driver).sendKeys(object.getPropValues("LoginName"));
			ForgetPassword.forgetEmail(driver).sendKeys("test@email.com");
		
		ForgetPassword.forgetResetBtn(driver).click();
		
		
		String expected = "http://10.66.38.52/MyApplication/Account/ForgetPassword";
		System.out.println("expected : "+expected);
		String actual = driver.getCurrentUrl();
		System.out.println("actual : "+actual);
		Assert.assertEquals(actual, expected);
		Log.info("Assertion successfull");
		//Warning Check
		String expectedWarn = "Username OR Email ID Not Correct.";
		System.out.println("expected : "+expected);
		String actualWarn = driver.findElement(ById.id("MainContent_lbltext")).getText();
		System.out.println("actual : "+actual);
		Assert.assertEquals(actualWarn, expectedWarn);
		Log.info("Assertion successfull");
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	catch (Exception e)
	{
		throw(e);
	}

		
	}
	
	@SuppressWarnings("deprecation")
	@AfterClass
	public void afterTest() {
		driver.quit();
		Log.info("Browser Closed");
	}
}
