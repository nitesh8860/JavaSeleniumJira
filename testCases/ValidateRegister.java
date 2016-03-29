package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Login_Page;
import pageObjects.RegisterPage;
import properties.LoadProperties;
import utility.Constants;
import utility.LibraryFunc;
import actionClass.RegisterAction;
import actionClass.SignOut_Action;

public class ValidateRegister {
	
	public WebDriver driver;
	static LoadProperties object = new LoadProperties();
static String s ;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() throws IOException {
		
		{
		
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		      driver = new ChromeDriver();       
				
			}

	}


	@SuppressWarnings("deprecation")
	
	@Test(priority=1)
	public void registrationCheck() throws Exception {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get(object.getPropValues("URL"));
		
		try
		{
			driver.manage().window().maximize();
			
		Login_Page.register(driver).click();

		System.out.println("1");
		String username="TestUser"+LibraryFunc.nbsp();
		RegisterPage.firstName(driver).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.lastName(driver).sendKeys("Sharma"+LibraryFunc.nbsp());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.gender(driver).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.address(driver).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.emailID(driver).sendKeys(username+"@email.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.userName(driver).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.password(driver).sendKeys("Infy123+");
		RegisterPage.confirmPassword(driver).sendKeys();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.confirmPassword(driver).sendKeys("Infy123+");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.registerSignup(driver).click();
		Thread.sleep(5000);
		Log.info("Registration Successfull");
		String expected = "Hello, " + username+" !";
		System.out.println("expected : "+expected);
		String actual = Login_Page.helloUsername(driver).getText();
		Thread.sleep(5000);
		System.out.println("actual : "+actual);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(actual, expected);
		Log.info("Assertion successfull");
		SignOut_Action.Execute(driver);
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	
	


	
	
	@SuppressWarnings("deprecation")
	@AfterTest
	public void afterTest() {
		driver.quit();
		Log.info("Browser Closed");
	}


}

