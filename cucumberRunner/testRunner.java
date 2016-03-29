package cucumberRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(

		features={"Feature"},
		glue={"stepDefinition"},
		tags={"@LaunchApp"},
		format={"pretty", "html:target/cucumber"}  
		)
public class testRunner {    }
