package actionClass;

import org.openqa.selenium.WebDriver;

import pageObjects.Login_Page;
import properties.LoadProperties;

public class SignIn_Action {
	
	public static void Execute(WebDriver driver) throws Exception{
		
		LoadProperties object=new LoadProperties();
		Login_Page.txtbx_UserName(driver).sendKeys(object.getPropValues("loginname"));
		Login_Page.txtbx_Password(driver).sendKeys(object.getPropValues("Password"));
		Login_Page.btn_Login(driver).click();
		Thread.sleep(5000);
		
	}

}
