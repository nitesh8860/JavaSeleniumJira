package actionClass;

import org.openqa.selenium.WebDriver;

import pageObjects.ForgetPassword;
import properties.LoadProperties;

public class ForgetPassAction {
	
	public static void Execute(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		ForgetPassword.forgetUsername(driver).sendKeys(object.getPropValues("NewLoginname"));
		ForgetPassword.forgetEmail(driver).sendKeys("abc@xyz.com");
		ForgetPassword.forgetResetBtn(driver).click();
	}
	public static void ForgetPassWrongUser(WebDriver driver) throws Exception{
		
		ForgetPassword.forgetUsername(driver).sendKeys("abcd");
		ForgetPassword.forgetEmail(driver).sendKeys("abc@xyz.com");
		ForgetPassword.forgetResetBtn(driver).click();
	}
	
}
