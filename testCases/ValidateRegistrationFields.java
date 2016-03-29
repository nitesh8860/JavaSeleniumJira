package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Login_Page;
import properties.LoadProperties;
import utility.Constants;
import actionClass.RegisterAction;

@Listeners(utility.ListenerClass.class)
public class ValidateRegistrationFields {

	public WebDriver driver;
	static LoadProperties object = new LoadProperties();

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeTest() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", Constants.chromepath);
		
		driver = new ChromeDriver();
		Log.info("Browser Launched");
		driver.get(object.getPropValues("URL"));
		Log.info("URL launched");	
		
	
	
	

	}
	
	@Test(priority=1)
	public void validate_FirstName() throws Exception {
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		try
		{
		Login_Page.register(driver).click();
		RegisterAction.firstNameFail(driver);
		
		String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
		System.out.println(actual);
		String expected = "The First Name field is required.";
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}catch(Exception e)
		{
			throw(e);
		}
	}
	
	
	@Test(priority=2)
	public void registrationFailGender() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		try
		{
		
		RegisterAction.genderFail(driver);
		String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
		System.out.println(actual);
		String expected = "The Gender field is required.";
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}
		catch(Exception e)
		{
			throw(e);
		}
		}

	@Test(priority=3)
	public void registrationFailAddress() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		try
		{
		RegisterAction.addressFail(driver);
		String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
		System.out.println(actual);
		String expected = "The Address field is required.";
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}
		catch(Exception e)
		{
			throw(e);
		}
		}
	
	//**************************************************************************************************
	@Test(priority=4)
	public void registrationFailContact_TC1() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		RegisterAction.contactLessthan10_Fail(driver);

		
			String actual =driver.findElement(ById.id("MainContent_ctl00")).getText();
			
		System.out.println(actual);
		String expected = "Please Enter Valid Contact Number.";
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		}
	
		@Test(priority=5)
		public void registrationFailContact_TC2() throws Exception {
			System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
			
			RegisterAction.contactMorethan10_Fail(driver);
			
				String actual =driver.findElement(ById.id("MainContent_ctl00")).getText();
				
			System.out.println(actual);
			String expected = "Please Enter Valid Contact Number.";
			System.out.println(expected);
			Assert.assertEquals(actual, expected);
			
			System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
			}

		@Test(priority=6)
		public void registrationFailContact_TC3() throws Exception {
			System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
			
			RegisterAction.contactasBlank_Fail(driver);
			
				String actual =driver.findElement(ById.id("MainContent_ctl00")).getText();
				
			System.out.println(actual);
			String expected = "The Contact Number field is required.";
			System.out.println(expected);
			Assert.assertEquals(actual, expected);
			
			System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
			}
	
		@Test(priority=11)
		public void registrationFailContact_TC4() throws Exception {
			System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
			
			RegisterAction.contactasNonNumeric_Fail(driver);
			
				String actual =driver.findElement(ById.id("MainContent_ctl00")).getText();
				
			System.out.println(actual);
			String expected = "Please Enter Valid Contact Number.";
			System.out.println(expected);
			Assert.assertEquals(actual, expected);
			
			System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
			}
	
	
		
		
	
		
		@Test(priority = 8)
	public void validate_invalidEmail() throws Exception

{
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	RegisterAction.EmailAdd1(driver);

	String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
	System.out.println("Actual:" + actual);
	String expected = "Please Enter Valid Email ID.";
	System.out.println("Expexted:" + expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
}
@Test(priority = 9)
public void registrationEmailAdd2() throws Exception
{
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	RegisterAction.EmailAdd2(driver);

	String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
	System.out.println("Actual:" + actual);
	String expected = "Please Enter Valid Email ID.";
	System.out.println("Expexted:" + expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
}
@Test(priority = 10)
public void registrationEmailAdd3() throws Exception
{
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	RegisterAction.EmailAdd3(driver);

	String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
	System.out.println("Actual:" + actual);
	String expected = "Please Enter Valid Email ID.";
	System.out.println("Expexted:" + expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
}
@Test(priority = 11)
public void registrationEmailAdd4() throws Exception
{
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	RegisterAction.EmailAdd4(driver);

	String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
	System.out.println("Actual:" + actual);
	String expected = "Please Enter Valid Email ID.";
	System.out.println("Expexted:" + expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
}
@Test(priority = 12)
public void registrationEmailAdd5() throws Exception
{
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	RegisterAction.EmailAdd5(driver);

	String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
	System.out.println("Actual:" + actual);
	String expected = "Please Enter Valid Email ID.";
	System.out.println("Expexted:" + expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
}


@Test(priority=13)
public void registrationFailUsernameBlank() throws Exception {
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	RegisterAction.userNameBlank(driver);
	
	String actual = driver.findElement(ById.id("MainContent_ctl00")).getText();
	System.out.println(actual);
	String expected = "The user name field is required.";
	System.out.println(expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
}

@Test(priority=14)
public void passwordFail_TC1() throws Exception {
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	try
	{
	RegisterAction.passwordLessthan6_Fail(driver);
	
		String actual =driver.findElement(ByClassName
				.className("text-danger")).getText();
		
	System.out.println(actual);
	String expected = "Passwords must be at least 6 characters.";
	System.out.println(expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
}
catch(Exception e)
{
	throw(e);
}
}

@Test(priority=15)
public void passwordFail_TC2() throws Exception {
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	try
	{
	RegisterAction.passwordnotEqualconfirm_Fail(driver);
	WebElement Warning = driver.findElement(ByClassName.className("text-danger"));
	List<WebElement> ErrorMsgS = Warning.findElements(By.tagName("li"));
	for(WebElement ErrorMsg : ErrorMsgS) {
		String actual =ErrorMsg.getText();
		
	System.out.println(actual);
	String expected = "The password and confirmation password do not match.";
	System.out.println(expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	}
	catch(Exception e)
	{
		throw(e);
	}
	}

@Test(priority=16)
public void passwordFail_TC3() throws Exception {
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	try
	{
	RegisterAction.passwordasBlank_Fail(driver);
	
		String actual =driver.findElement(ByClassName.className("text-danger")).getText();
		
	System.out.println(actual);
	String expected = "Passwords must be at least 6 characters.";
	System.out.println(expected);
	Assert.assertEquals(actual, expected);
	
	System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	}catch(Exception e)
	{
		throw(e);
	}
}


	
	@SuppressWarnings("deprecation")
	@AfterClass
	public void afterTest() {
		driver.close();
		Log.info("Browser Closed");
	}

}

