package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.pomrepositrylib.AddContact;
import com.vtiger.comcast.pomrepositrylib.CreateNewContact;
import com.vtiger.comcast.pomrepositrylib.Home;
import com.vtiger.comcast.pomrepositrylib.Login;

public class TC_NewCreateContact extends BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	
	@Test
	public void newCreateContact() throws Throwable {
	
		/*Read Test data*/
		String FIRSTNAME = eLib.getExcelData("Sheet1", 5, 1) + "_"+ jLib.getRandomData();
		String LASTNAME = eLib.getExcelData("Sheet1", 5, 2);
		String EMAIL = eLib.getExcelData("Sheet1", 5, 3);
		String PHONENUM = eLib.getExcelData("Sheet1", 5, 4);
		String ASSIGNEDTO = eLib.getExcelData("Sheet1", 5, 5);
		String LIFECYCLESTAGE = eLib.getExcelData("Sheet1", 5, 6);
		
		 //Click menu button code
		 Home homePage = new Home(driver);
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
			 createContact.createContactInfo(FIRSTNAME,LASTNAME,EMAIL,PHONENUM);
			 wLib.waitUntilPageLoad(driver);

			WebElement Assigned = createContact.getAssignedTo();
			wLib.SelectAllOption(Assigned, ASSIGNEDTO);
			wLib.waitUntilPageLoad(driver);
        
			WebElement lifeCycle = createContact.getLifecycleStage();
			wLib.SelectAllOption(lifeCycle, LIFECYCLESTAGE);
			wLib.waitUntilPageLoad(driver);
			   
			   createContact.clickSave();
			   
			   driver.switchTo().window(parentWin);
				 Thread.sleep(30000);
	}

}
