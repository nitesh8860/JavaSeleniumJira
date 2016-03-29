package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByPartialLinkText;

import utility.LibraryFunc;



import properties.LoadProperties;

public class Login_Page {
	
	public WebDriver driver = null;
	
static LoadProperties object=new LoadProperties();
static LibraryFunc func=new LibraryFunc();
	
	private static WebElement element = null;
	
	public static WebElement txtbx_UserName(WebDriver driver)
	{
		try
		{
			
			element=driver.findElement(By.name(object.getPropValues("Login_uname")));
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}
	
	
	public static WebElement txtbx_Password(WebDriver driver)
	{
		try
		{
			
			
			element=driver.findElement(By.name(object.getPropValues("Login_Pwd")));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}
	
		
 public static WebElement btn_Login(WebDriver driver){
    	 
         try{

	      element=driver.findElement(By.name(object.getPropValues("Login_submit")));

	           // Log.info("Submit button found on the login Page");

         }catch (Exception e){
        	 e.printStackTrace();

         	//Log.error("Submit link is not found on the login Page");

        		
        		}

    return element;
     }
 
 public static WebElement InvPass(WebDriver driver)
	{
		try
		{
			
			element=driver.findElement(By.className(object.getPropValues("InvPassText")));
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}

 
 public static WebElement lnk_Logout(WebDriver driver)
 {
	 try
	 {
		 element=driver.findElement(By.linkText(object.getPropValues("logout")));
	 }catch(Exception e){
	 }
	 return element;
	 }

 //Register
 public static WebElement register(WebDriver driver)
 {
	 try
	 {
		 element=driver.findElement(By.id(object.getPropValues("Register")));
	 }catch(Exception e){
	 }
	 return element;
	 }

 
 
 
 
 
 //Register
 public static WebElement helloUsername(WebDriver driver)
 {
	 try
	 {
		 element=driver.findElement(ByPartialLinkText.partialLinkText(object.getPropValues("HelloUsername")));
	 }catch(Exception e){
	 }
	 return element;
	 }
 public static WebElement forgetPassLink(WebDriver driver)
 {
	 try
	 {
		 element=driver.findElement(ById.id("MainContent_ForgetPasswordLink"));
	 }catch(Exception e){
	 }
	 return element;
	 }
 }
 
 
 

