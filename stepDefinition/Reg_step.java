package stepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Login_Page;
import pageObjects.RegisterPage;
import properties.LoadProperties;
import utility.LibraryFunc;

public class Reg_step {

	public WebDriver driver;
	static LoadProperties object = new LoadProperties();
	static String s;

	String username = "TestUser" + LibraryFunc.nbsp();

	

	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(object.getPropValues("URL"));

		driver.manage().window().maximize();


	
	}

	@When("^User Navigate to Registration page$")
	public void user_Navigate_to_Registration_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Login_Page.register(driver).click();

	}

	@When("^User enters valid credential nin all field$")
	public void user_enters_valid_credential_nin_all_field() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	
		
		RegisterPage.firstName(driver).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.lastName(driver).sendKeys("Sharma" + LibraryFunc.nbsp());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.gender(driver).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.address(driver).sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RegisterPage.emailID(driver).sendKeys(username + "@email.com");
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

	}

	@Then("^Registration should be successfull and homepage should be displayed$")
	public void message_displayed_REgistration_Successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String expected = "Hello, " + username+" !";
		System.out.println("expected : "+expected);
		String actual = Login_Page.helloUsername(driver).getText();
		Thread.sleep(5000);
		System.out.println("actual : "+actual);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion successfull");
	}

}
