package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ForgetPassword;
import pageObjects.Login_Page;
import properties.LoadProperties;
import utility.LibraryFunc;

public class ForgetPassword_step {
	public WebDriver driver;
	static LoadProperties object = new LoadProperties();
	static String s;

	String username = "TestUser" + LibraryFunc.nbsp();
	
@Given("^User navigates to Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(object.getPropValues("URL"));

		driver.manage().window().maximize();
}

@When("^User clicked on Forget Password link$")
public void user_clicked_on_Forget_Password_link() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Login_Page.forgetPassLink(driver).click();
}

@Then("^User enters valid Username and Email id$")
public void user_enters_valid_Username_and_Email_id() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	ForgetPassword.forgetUsername(driver).sendKeys(object.getPropValues("LoginName"));
	ForgetPassword.forgetEmail(driver).sendKeys("abc@xyz.com");
	
}

@And("^User clicks on reset button$")
public void user_clicks_on_reset_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	ForgetPassword.forgetResetBtn(driver).click();
	System.out.println("1");
	driver.findElement(By.name("ctl00$MainContent$NewPassword")).sendKeys("abc123");
	System.out.println("2");
	driver.findElement(By.name("ctl00$MainContent$ConfirmNewPassword")).sendKeys("abc123");
	driver.findElement(By.name("ctl00$MainContent$ctl04")).click();
}

@Then("^Message should be displayed Password reset successfully$")
public void message_should_be_displayed_Password_reset_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String expected = "http://10.66.38.52/MyApplication/Account/CustomManage";
	System.out.println("expected : "+expected);
	String actual = driver.getCurrentUrl();
	System.out.println("actual : "+actual);

	Assert.assertEquals(actual, expected);
	
}
	
}
