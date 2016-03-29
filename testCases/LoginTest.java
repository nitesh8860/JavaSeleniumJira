package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utility.Constants;
import utility.ExcelRead;
import utility.ExcelUpdate;

public class LoginTest {

	public static int h;
	public static int flag;
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", Constants.chromepath);
		driver = new ChromeDriver();
		Log.info("Browser launched");
		driver.get(Constants.url);
		Log.info("url launched in browser");
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void Login() throws Exception {

		LoginPage l = new LoginPage(driver);
		flag = ExcelRead.read(Constants.path, Constants.sheet).length;
		System.out.println("No. of Test cases : " + (flag - 1));

		for (h = 1; h < ExcelRead.read(Constants.path, Constants.sheet).length; h++) {

			l.username.sendKeys(ExcelRead.username("login"));
			l.password.sendKeys(ExcelRead.password("login"));
			l.signBtn.click();
			Log.info("login tried");
			if (driver.getCurrentUrl().endsWith("/Login")) {
				if (l.invalidText.getText().equalsIgnoreCase(
						"Invalid username or password.")) {
					Log.warn("login failed at ");
					ExcelUpdate.update(h, 3, "FAIL");

				}
			} else if (driver.getCurrentUrl().endsWith("/Demo_App/Default")) {
				Log.info("login successfull");
				ExcelUpdate.update(h, 3, "PASS");

				l.logOut.click();
				Log.info("logout successfull");
			}

			l.username.clear();
			l.password.clear();

		}

	}
	
	
	
	
	@SuppressWarnings("deprecation")
	@AfterTest
	private void terminatingBrowser() {
		driver.close();
		Log.info("Browser clossed");

	}
}
