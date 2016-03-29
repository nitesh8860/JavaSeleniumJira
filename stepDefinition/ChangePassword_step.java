package stepDefinition;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;


import actionClass.SignIn_Action;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Home_Page;

import pageObjects.Manage_Account;

import properties.LoadProperties;
import utility.LibraryFunc;

public class ChangePassword_step {
	public WebDriver driver;
	static LoadProperties object = new LoadProperties();
	static String s;

	String username = "TestUser" + LibraryFunc.nbsp();
	
	@Given("^User invoke Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(object.getPropValues("URL"));

		driver.manage().window().maximize();


	
	}
	@When("^User logged in with valid creds$")
	public void user_logged_in_with_valid_creds() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SignIn_Action.Execute(driver);
	    
	}

	@And("^User Navigate to Account setting page$")
	public void user_Navigate_to_Account_setting_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Home_Page.HelloUser_Link(driver).click();
	}
	
	@Then("^User enters new password$")
	public void user_enters_new_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Manage_Account.txtbox_CurrentPwd(driver).clear();
		Manage_Account.txtbox_CurrentPwd(driver).sendKeys(object.getPropValues("Password"));
		Manage_Account.txtbox_ChangedPwd(driver).sendKeys(object.getPropValues("chngdnewpwd"));
		Manage_Account.txtbox_ChangedPwdConf(driver).sendKeys(object.getPropValues("chngdnewpwd"));
	}	
	@And("^User click on Change Password button$")
	public void user_click_on_Change_Password_button() throws Throwable {
		Manage_Account.btn_ChngePwdSubmit(driver).click();
	}

	@Then("^Message displayed Password changed successfully$")
	public void message_displayed_Password_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		 System.out.println("Test"); 
	     String ActualVal = driver.findElement(By.className("text-success")).getText();
	     System.out.println(ActualVal);   
	     
	      
	        Assert.assertEquals(ActualVal,"Your password has been changed.");
	         
	}

}
