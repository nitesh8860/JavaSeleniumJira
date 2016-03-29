package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="MainContent_UserName")
		public WebElement username;
		
			
		@FindBy(id="MainContent_Password")
		public WebElement password;
	
		@FindBy(name = "ctl00$MainContent$ctl05")
		public WebElement signBtn;
	
		@FindBy(className = "text-danger")
		public WebElement invalidText;
		
		@FindBy(xpath = "/html/body/form/div[3]/div/div/table[1]/tbody/tr/td[1]")
		public WebElement Welcome;
		
		@FindBy(xpath="/html/body/form/div[2]/div/div[2]/ul[2]/li[2]/a")
		public WebElement logOut;
}
