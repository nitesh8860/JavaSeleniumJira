package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import properties.LoadProperties;
import utility.LibraryFunc;

public class ForgetPassword {
	
public WebDriver driver = null;
	
	static LoadProperties object=new LoadProperties();
	static LibraryFunc func=new LibraryFunc();
		
		private static WebElement element = null;
		
	public static WebElement forgetUsername(WebDriver driver){
		 
	    try{

	     element=driver.findElement(By.name(object.getPropValues("forgetUsername")));

	          // Log.info("Submit button found on the login Page");

	    }catch (Exception e){
	   	 e.printStackTrace();

	    	//Log.error("Submit link is not found on the login Page");

	   		
	   		}

	return element;
	}
	public static WebElement forgetEmail(WebDriver driver){
		 
	    try{

	     element=driver.findElement(By.name(object.getPropValues("forgetEmail")));

	          // Log.info("Submit button found on the login Page");

	    }catch (Exception e){
	   	 e.printStackTrace();

	    	//Log.error("Submit link is not found on the login Page");

	   		
	   		}

	return element;
	}public static WebElement forgetResetBtn(WebDriver driver){
		 
	    try{

	     element=driver.findElement(By.name(object.getPropValues("forgetResetBtn")));

	          // Log.info("Submit button found on the login Page");

	    }catch (Exception e){
	   	 e.printStackTrace();

	    	//Log.error("Submit link is not found on the login Page");

	   		
	   		}

	return element;
	}
}
