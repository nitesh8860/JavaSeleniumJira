package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Login_Page;
import properties.LoadProperties;
import updateJIRA.TestClass;
import utility.Constants;
import actionClass.SignIn_Action;
import actionClass.SignOut_Action;

@Test
public class ValidateLogin {
	static LoadProperties object=new LoadProperties();
	public WebDriver driver = null;

	
@BeforeClass
	
	public void launchBrowser()
	
	{
	System.setProperty("webdriver.ie.driver", Constants.ieexplorer);
	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	caps.setCapability(
	    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	    true);
	driver = new InternetExplorerDriver(caps);
		
	}
		
	
	
@SuppressWarnings("deprecation")



/*
 * Login to application
 * Enter valid user name, password. and click Login.
 * Click User menu > Logout.
 
 */
public  void valid_userCredentials() throws Exception{
	
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
    driver.get(object.getPropValues("URL"));
	
	try
	{
		
	SignIn_Action.Execute(driver);
	Log.info("Login tried");
	String expected = "Hello, " + object.getPropValues("NewLoginname")+ " !";
	System.out.println("expected : "+expected);
	String actual=null;
	try{
	 actual = Login_Page.helloUsername(driver).getText();
	}
	catch(Exception e){
		actual="element not found";
	}
	
	
	
	System.out.println("actual : "+actual);

	updateJIRA.TestClass t = new TestClass();
	if(actual.equalsIgnoreCase(expected)){
		System.out.println("Updating JIRA");
		
		t.getTransitions("TES-1");
		
		
	}
	else{
		t.createIssue("10000", "Bug", "validate login failed");
	}
	
//	try{
	Assert.assertEquals(actual, expected);
	Log.info("Assertion successfull");
//	}
//	catch(AssertionError e){
//		System.out.println("Assertion Failed");
//	}
	
	try{ 
    SignOut_Action.Execute(driver);
    }
    catch(Exception e){
    	System.out.println("sign out button not found");
    }
    Log.info("Logout successfull");
   
        
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
