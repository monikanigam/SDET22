package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {

	@Test
	public void readDataFromPropertyFile() throws Throwable {
		/*read data from properties file*/
		//step 1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("/AutodeskNew_Framework/Data/CommonData.properties");
		//step 2: create an object of the properties class & load the all keys:value pair
		Properties pobj = new Properties();
		pobj.load(fis);
		//step 3: read the value using getProperty("key")
		String url = pobj.getProperty("url");
		String browse = pobj.getProperty("browser");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
		System.out.println(url);
		System.out.println(browse);
		System.out.println(username);
		System.out.println(password);
	}

}
