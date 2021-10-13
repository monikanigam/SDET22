package com.crm.vtiger.GenericUtils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.vtiger.comcast.pomrepositrylib.Home;
import com.vtiger.comcast.pomrepositrylib.Login;


public class BaseClass {
//  public DataBaseUtility dLib = new DataBaseUtility();
  public static FileUtility fLib = new FileUtility();
  public JavaUtility jLib = new JavaUtility();
  public ExcelUtility eLib = new ExcelUtility();
  public static WebDriverUtility wLib = new WebDriverUtility();
 public WebDriver driver;
 public static WebDriver staticDriver;
  
  @BeforeSuite(groups = {"smoketest","regression"})
  public void connectToDB() throws Throwable {
	//  dLib.connectToDB();
	  System.out.println("=============DB connection successfull=================");
  }
  static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
  
  @Parameters(value = {"browser"}) //chrome, firefox
  @BeforeClass(groups = {"smoketest","regression"})
  public void launchTheBrowser(@Optional("Chrome") String browserValue) throws Throwable {
	// String BROWSER = fLib.getPropertyKeyValue("browser");
	String URL = fLib.getPropertyKeyValue("url1");
	System.out.println("Launching browser : "+ browserValue);
	/*Launch the browser */
	if(browserValue.equals("firefox")) {
		
		driver = new FirefoxDriver();
	}else if(browserValue.equals("Chrome")) {
		driver = new ChromeDriver();
	}else if(browserValue.equals("ie")) {
		driver = new InternetExplorerDriver();
	}else {
          System.out.println("Invalid browser entry :"+ browserValue);	
    }
	staticDriver = driver;
	System.out.println("====================Browser Launch successful===============");
	
	wLib.maximiseTheWindow(driver);
	wLib.waitUntilPageLoad(driver);
	driver.get(URL);
}
  
  @BeforeMethod(groups = {"smoketest","regression"})
  public void loginToApp() throws Throwable {
      //Read Data From Property file
	String USERNAME = fLib.getPropertyKeyValue("username1");
	String PASSWORD = fLib.getPropertyKeyValue("password1");
	
	//LOGIN TO APP
	Login lp = new Login(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("============Login successful==================");
  }
  
  @AfterMethod(groups = {"smoketest","regression"}) 
  public void logoutOfApp() {
	  Home hp = new Home(driver);
	  hp.clickVtigerBtn();
	  wLib.waitUntilPageLoad(driver);
	  hp.clickLogout();
		System.out.println("============Logout successful==================");
  }
  
  @AfterClass(groups = {"smoketest","regression"})
  public void closeBrowser() {
	  driver.close();
	  System.out.println("===============Browser close successful================");
  }
  
  @AfterSuite(groups = {"smoketest","regression"})
  public void closeDB() throws Throwable {
	 // dLib.closeDB();
	  System.out.println("===============DataBase close successful================");
  }
  
}
