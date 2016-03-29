package actionClass;




import org.openqa.selenium.WebDriver;

import pageObjects.Home_Page;

import pageObjects.Manage_Account;
import properties.LoadProperties;

public class ChangePwd_Action {
	
	public static void Execute(WebDriver driver) throws Exception{
		
		LoadProperties object=new LoadProperties();
		
		Home_Page.HelloUser_Link(driver).click();
		Manage_Account.txtbox_CurrentPwd(driver).clear();
		Manage_Account.txtbox_CurrentPwd(driver).sendKeys(object.getPropValues("NewPassword"));
		Manage_Account.txtbox_ChangedPwd(driver).sendKeys(object.getPropValues("chngdnewpwd"));
		Manage_Account.txtbox_ChangedPwdConf(driver).sendKeys(object.getPropValues("chngdnewpwd"));
		Manage_Account.btn_ChngePwdSubmit(driver).click();
		
	}
	
}
		