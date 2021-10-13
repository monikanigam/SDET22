package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.comcast.pomrepositrylib.AddContact;
import com.vtiger.comcast.pomrepositrylib.CreateNewContact;
import com.vtiger.comcast.pomrepositrylib.Home;

public class TC_01ContactAlertVarify extends BaseClass{

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	@Test
	public  void contactAlertVarify() throws Throwable {

//		/* Create Objects*/
//		ExcelUtility excelUtil = new ExcelUtility();
//		FileUtility fileUtil = new FileUtility();
//		JavaUtility javaUtil = new JavaUtility();
//		WebDriverUtility wutility = new WebDriverUtility();
		//WebDriver driver = null;
//		
//		/*Read Common data from property file */
//		String BROWSER = fLib.getPropertyKeyValue("browser");
//		String URL = fLib.getPropertyKeyValue("url1");
//		String USERNAME = fLib.getPropertyKeyValue("username1");
//		String PASSWORD = fLib.getPropertyKeyValue("password1");
		
		
		/*Read Test data*/
		String FIRSTNAME = eLib.getExcelData("Sheet1", 5, 1) + "_"+ jLib.getRandomData();
		

//		/*Launch the browser */
//		if(BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}else if(BROWSER.equals("Chrome")) {
//			driver = new ChromeDriver();
//		}else if(BROWSER.equals("ie")) {
//			driver = new InternetExplorerDriver();
//		}else {
//			driver = new ChromeDriver();
//		}
//			/*Login to App*/
//			driver.get(URL);
//			Login login = new Login(driver);
//			login.loginToApp(USERNAME, PASSWORD);
//			wutility.waitUntilPageLoad(driver);
//			System.out.println("click login");
			
			 //Click menu button code
			 Home homePage = new Home(driver);
			// wutility.waitForElementVisibilityNew(driver, homePage.getMenu());
			 homePage.clickMenu();
			 System.out.println("click home");
			 wLib.waitUntilPageLoad(driver);
			 homePage.clickContact();
			 
	         //Add contact btn
	         AddContact addContact = new AddContact(driver);
	         addContact.clickAddContact(); 
	 		 wLib.waitUntilPageLoad(driver);
	 		
			 
			 //code for switch parent to child window
	 		String parentWin = driver.getWindowHandle();
			wLib.switchParentToChildWindow(driver);
			 System.out.println("enter child window");
			 wLib.waitUntilPageLoad(driver);
			 
				//create contact    
			 CreateNewContact createContact = new CreateNewContact(driver);
			 createContact.createContactWithFirstN(FIRSTNAME);
			 createContact.clickSave();
			 wLib.waitUntilPageLoad(driver);
			 String actualTitle= createContact.getActualMsg().getText();
			 System.out.println(actualTitle);
			 String expectedTitle = "The Last Name field is required.";
			Assert.assertTrue(actualTitle.contains(expectedTitle)); 
		// Assert.assertEquals(actualTitle,expectedTitle);
			 System.out.println("pass");
			 createContact.clickCrossButton();

			 driver.switchTo().window(parentWin);
			 Thread.sleep(30000);
			// driver.close();
		}
	}
	 
	

