package actionClass;

import org.openqa.selenium.WebDriver;

import pageObjects.RegisterPage;
import properties.LoadProperties;
import utility.LibraryFunc;

public class RegisterAction {
	public static void Execute(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		String username="TestUser"+LibraryFunc.nbsp();
		RegisterPage.firstName(driver).sendKeys(username);
		RegisterPage.lastName(driver).sendKeys("Sharma"+LibraryFunc.nbsp());
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys(username+"@email.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues(username));
		RegisterPage.password(driver).sendKeys(object.getPropValues("Infy123+"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("Infy123+"));
		RegisterPage.registerSignup(driver).click();
		}
	
	public static void firstNameFail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		RegisterPage.firstName(driver).sendKeys("");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	public static void genderFail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		//RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	public static void addressFail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	public static void EmailAdd1(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("abcxyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	
	public static void EmailAdd2(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	public static void EmailAdd3(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys(".abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	public static void EmailAdd4(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("abc@.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}


	public static void EmailAdd5(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("ab..c@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	
	public static void contactLessthan10_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("99999888");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
	}
	public static void contactMorethan10_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("99999888809");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
	}
	
	public static void contactasNonNumeric_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		
		
		
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("abc-jj+d");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
	}
	public static void contactasBlank_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
}
	public static void passwordLessthan6_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9087654321");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		
		RegisterPage.password(driver).sendKeys("abcd");
		RegisterPage.confirmPassword(driver).sendKeys("abcd");
		RegisterPage.registerSignup(driver).click();
}
	public static void passwordnotEqualconfirm_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		/*
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9087654321");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		*/
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys("abcd");
		RegisterPage.registerSignup(driver).click();
}
	public static void passwordasBlank_Fail(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		/*
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9087654321");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		
		RegisterPage.userName(driver).sendKeys(object.getPropValues("NewLoginname"));
		*/
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys("");
		RegisterPage.registerSignup(driver).click();
}
	

	public static void userNameBlank(WebDriver driver) throws Exception{
		LoadProperties object=new LoadProperties();
		driver.navigate().refresh();
		RegisterPage.firstName(driver).sendKeys("Rohit");
		RegisterPage.lastName(driver).sendKeys("Sharma");
		RegisterPage.gender(driver).click();
		RegisterPage.address(driver).sendKeys("Hyderabad");
		RegisterPage.contactNumber(driver).sendKeys("9999988888");
		RegisterPage.emailID(driver).sendKeys("abc@xyz.com");
		RegisterPage.userName(driver).sendKeys("");
		RegisterPage.password(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.confirmPassword(driver).sendKeys(object.getPropValues("NewPassword"));
		RegisterPage.registerSignup(driver).click();
		}
	
}
