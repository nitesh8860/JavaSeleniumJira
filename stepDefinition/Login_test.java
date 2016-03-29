package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Login_test {
	private static WebDriver driver = null;

	@Given("^User opens Login Page$")
	public void user_opens_Login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.66.38.52/MyApplication/Account/Login");
		System.out.println("2");
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("find element");
		driver.findElement(By.name("ctl00$MainContent$UserName")).sendKeys("new");

		driver.findElement(By.name("ctl00$MainContent$Password")).sendKeys("11110000");

	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.findElement(By.name("ctl00$MainContent$ctl05")).click();
		String actual = driver.getCurrentUrl();
		String Expected = "http://10.66.38.52/MyApplication/HomePage";

		Boolean f = false;
		if (actual.equals(Expected)) {
			f = true;
		} else {
			System.out.println("wrong credentials");
		}
		Assert.assertTrue(f);
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {

		System.out.println("Login Successfully");
		// Write code here that turns the phrase above into concrete actions
	}

}
