package properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	
	public String getPropValues(String input) throws IOException {
		 
		//String result = "";
		Properties prop = new Properties();
		String propFileName = "PageObjectId.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		//Date time = new Date(System.currentTimeMillis());

		// get the property value and print it out
		String user = prop.getProperty(input);
		

		//System.out.println(user+" "+input);
		return user;
	}


}
