package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import properties.LoadProperties;
import utility.LibraryFunc;
import utility.Log;

public class Manage_Account {
	public static WebDriver driver = null;
	static LoadProperties object=new LoadProperties();
	static LibraryFunc func=new LibraryFunc();
    private static WebElement element = null;
    
    public static WebElement txtbox_CurrentPwd(WebDriver driver) throws Exception{
        try{ 
        	 element = driver.findElement(By.name(object.getPropValues("Current_Pwd")));
             Log.info("My Current Password field is found on the Manage_Account");
             
             
        }catch (Exception e){
       		Log.error("My Current Password field  is not found on the Manage_Account page");
       		throw(e);
       		}
       	return element;
    }

    public static WebElement txtbox_ChangedPwd(WebDriver driver) throws Exception{
        try{ 
        	 element = driver.findElement(By.name(object.getPropValues("Changed_NPwd")));
             Log.info("My Change Password field  is found on the Manage_Account page");
             
             
        }catch (Exception e){
       		Log.error("My Change Password field  is not found on the Manage_Account page");
       		throw(e);
       		}
       	return element;
    }
    
    
    public static WebElement txtbox_ChangedPwdConf(WebDriver driver) throws Exception{
        try{ 
        	 element = driver.findElement(By.name(object.getPropValues("Changed_PwdConf")));
             Log.info("My Confirm Password field  is found on the Manage_Account page");
             
             
        }catch (Exception e){
       		Log.error("My Confirm Password field  is not found on the Manage_Account page");
       		throw(e);
       		}
       	return element;
    
    }   
    
    public static WebElement btn_ChngePwdSubmit(WebDriver driver) throws Exception{
        try{ 
        	 element = driver.findElement(By.name(object.getPropValues("ChngePwd_Submit")));
             Log.info("Change Password button is found on the Manage_Account page");
             
             
        }catch (Exception e){
       		Log.error("Change Password button  is not found on the Manage_Account page");
       		throw(e);
       		}
       	return element;
    
    }   
}


