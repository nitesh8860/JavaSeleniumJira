package actionClass;
import org.openqa.selenium.WebDriver;

import pageObjects.Login_Page;
//import Properties.LoadProperties;
public class SignOut_Action {
	
	public static void Execute(WebDriver driver) throws Exception{
		
		
		Login_Page.lnk_Logout(driver).click();
		Thread.sleep(5000);
		
	}

}
