package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import properties.LoadProperties;
import utility.LibraryFunc;

public class RegisterPage {
	public WebDriver driver = null;
	
	static LoadProperties object=new LoadProperties();
	static LibraryFunc func=new LibraryFunc();
		
		private static WebElement element = null;
		
		//Register
		public static WebElement txtbx_ConfirmPassword(WebDriver driver)
		{
			try
			{
				
				
				element=driver.findElement(By.name(object.getPropValues("Login_ConfirmPwd")));
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return element;
		}
		 public static WebElement registerbtn_Login(WebDriver driver){
			 
		     try{

		      element=driver.findElement(By.name(object.getPropValues("RegisterSubmit")));

		           // Log.info("Submit button found on the login Page");

		     }catch (Exception e){
		    	 e.printStackTrace();

		     	//Log.error("Submit link is not found on the login Page");

		    		
		    		}

		return element;
		 }
		 public static WebElement firstName(WebDriver driver){
			 
		     try{

		      element=driver.findElement(By.id(object.getPropValues("firstName")));

		           // Log.info("Submit button found on the login Page");

		     }catch (Exception e){
		    	 e.printStackTrace();

		     	//Log.error("Submit link is not found on the login Page");

		    		
		    		}

		return element;
		 }
public static WebElement lastName(WebDriver driver){
			 
		     try{

		      element=driver.findElement(By.name(object.getPropValues("lastName")));

		           // Log.info("Submit button found on the login Page");

		     }catch (Exception e){
		    	 e.printStackTrace();

		     	//Log.error("Submit link is not found on the login Page");

		    		
		    		}

		return element;
		 }

public static WebElement gender(WebDriver driver){
	 
    try{

     element=driver.findElement(By.name(object.getPropValues("gender")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		}

return element;
}
public static WebElement address(WebDriver driver){
	 
    try{

     element=driver.findElement(By.name(object.getPropValues("address")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
}

public static WebElement contactNumber(WebDriver driver){
	 
    try{

     element=driver.findElement(By.name(object.getPropValues("contactNumber")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
}
public static WebElement emailID(WebDriver driver){
	 
    try{

     element=driver.findElement(By.name(object.getPropValues("emailID")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
	}
public static WebElement userName(WebDriver driver){
	 
    try{

     element=driver.findElement(By.id(object.getPropValues("UserName")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
}

public static WebElement password(WebDriver driver){
	 
    try{

     element=driver.findElement(By.name(object.getPropValues("password")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
}

public static WebElement confirmPassword(WebDriver driver){
	 
    try{

     element=driver.findElement(ById.id(object.getPropValues("confirmPassword")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
}

public static WebElement registerSignup(WebDriver driver){
	 
    try{

     element=driver.findElement(By.name(object.getPropValues("registerSignup")));

          // Log.info("Submit button found on the login Page");

    }catch (Exception e){
   	 e.printStackTrace();

    	//Log.error("Submit link is not found on the login Page");

   		
   		}

return element;
}

}