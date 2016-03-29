package testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

	import actionClass.ChangePwd_Action;
import actionClass.SignIn_Action;
import pageObjects.Home_Page;
import pageObjects.Manage_Account;
import properties.LoadProperties;
import utility.Constants;

	public class ValidateChangePassword {
		
		static LoadProperties object=new LoadProperties();
		public WebDriver driver;
		

	  @BeforeClass
	  public void beforeClass() {
		  {
				
			  System.setProperty("webdriver.chrome.driver", Constants.chromepath);
				
				driver = new ChromeDriver();
					
				}
	  }
	  
	  /*
	   * Login to Application
	   * Click Manage Account (Hello user name)change Password link,
	   * Enter Old password, new password, confirm password and submit
	   */

	  @Test
	  public void validate_ChangePwd() throws Exception{
		  System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  driver.get(object.getPropValues("URL"));
			 driver.manage().window().maximize();
			
			try
			{
				
			SignIn_Action.Execute(driver);
			
			Home_Page.HelloUser_Link(driver).click();
			Manage_Account.txtbox_CurrentPwd(driver).clear();
			Manage_Account.txtbox_CurrentPwd(driver).sendKeys(object.getPropValues("Password"));
			Manage_Account.txtbox_ChangedPwd(driver).sendKeys(object.getPropValues("chngdnewpwd"));
			Manage_Account.txtbox_ChangedPwdConf(driver).sendKeys(object.getPropValues("chngdnewpwd"));
			Manage_Account.btn_ChngePwdSubmit(driver).click();
	      
		   
		     
		     String ActualVal = driver.findElement(By.className("text-success")).getText();
		     System.out.println(ActualVal);   
		     
		      
		        Assert.assertEquals(ActualVal,"Your password has been changed.");
		        
		     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());

			} 
			catch (Exception e)
			{
				throw(e);
			}
		}
	  
	  
	  @AfterClass
	  
		  public void terminateBrowser(){
				
				driver.quit();
				}
	  }

