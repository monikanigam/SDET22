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
import com.vtiger.comcast.pomrepositrylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositrylib.Home;
import com.vtiger.comcast.pomrepositrylib.Login;
import com.vtiger.comcast.pomrepositrylib.Organizations;

public class TC_01CreateOrganization extends BaseClass{

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	@Test
	public void createOrganization() throws Throwable {
			
		/*Read Test data*/
		String orgName = eLib.getExcelData("Sheet1", 1, 1) + "_"+ jLib.getRandomData();
		String websiteName = eLib.getExcelData("Sheet1", 1, 2);
		String phoneNumber = eLib.getExcelData("Sheet1", 1, 3);
		String typeOption = eLib.getExcelData("Sheet1", 1, 4);
		String assignedTo = eLib.getExcelData("Sheet1", 1, 5);
				
		 //Click menu button code
		 Home homePage = new Home(driver);
		// wutility.waitForElementVisibilityNew(driver, homePage.getMenu());
		 homePage.clickMenu();
		 System.out.println("click home");
		 wLib.waitUntilPageLoad(driver);
         homePage.selectOrg();
		 
       //Add Organization  code here
		 Organizations organi = new Organizations(driver);
		 organi.clickOrganisationBtn(); 
		 wLib.waitUntilPageLoad(driver);
		 
       //code for switch parent to child window
		String parentWin = driver.getWindowHandle();
		wLib.switchParentToChildWindow(driver);
		
		 System.out.println("enter child window");
		 wLib.waitUntilPageLoad(driver);
		 
		 //create new organization code
		 CreateNewOrganization createOrg = new CreateNewOrganization(driver);
		 createOrg.createNewOrg(orgName, websiteName, phoneNumber);
		 wLib.waitUntilPageLoad(driver);
		 
		 WebElement typeO = createOrg.getType();
		 wLib.SelectOption(typeO,typeOption);
		 wLib.waitUntilPageLoad(driver);
	     
	     WebElement assignTo  = createOrg.getAssignedTo();
	     wLib.SelectAllOption(assignTo,assignedTo);
	    
	 
	     wLib.waitUntilPageLoad(driver);
	 createOrg.clickSaveBtn();
	 
	 driver.switchTo().window(parentWin);
	 Thread.sleep(30000);

	}
}
