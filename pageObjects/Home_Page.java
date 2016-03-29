package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import properties.LoadProperties;
import utility.LibraryFunc;

public class Home_Page {
	public WebDriver driver = null;
	
	static LoadProperties object=new LoadProperties();
	static LibraryFunc func=new LibraryFunc();
private static WebElement element = null;
	
	public static WebElement HelloUser_Link(WebDriver driver)
	{
		try
		{
			
			element=driver.findElement(By.cssSelector(object.getPropValues("HelloLink")));
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}

}
