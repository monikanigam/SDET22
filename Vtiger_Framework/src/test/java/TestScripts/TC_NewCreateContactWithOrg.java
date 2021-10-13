package TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.pomrepositrylib.AddContact;
import com.vtiger.comcast.pomrepositrylib.CreateNewContact;
import com.vtiger.comcast.pomrepositrylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositrylib.Home;
import com.vtiger.comcast.pomrepositrylib.Login;
import com.vtiger.comcast.pomrepositrylib.Organizations;

public class TC_NewCreateContactWithOrg {
	
	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
    @Test
	public static void createContactWithOrg() throws Throwable {

		/* Create Objects*/
		ExcelUtility excelUtil = new ExcelUtility();
		FileUtility fileUtil = new FileUtility();
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUtility wutility = new WebDriverUtility();
		WebDriver driver = null;
		
		/*Read Common data from property file */
		String BROWSER = fileUtil.getPropertyKeyValue("browser");
		String URL = fileUtil.getPropertyKeyValue("url1");
		String USERNAME = fileUtil.getPropertyKeyValue("username1");
		String PASSWORD = fileUtil.getPropertyKeyValue("password1");
		
		/*Read Test data organization*/
		String orgName = excelUtil.getExcelData("Sheet1", 1, 1);
		String websiteName = excelUtil.getExcelData("Sheet1", 1, 2);
		String phoneNumber = excelUtil.getExcelData("Sheet1", 1, 3);
		String typeOption = excelUtil.getExcelData("Sheet1", 1, 4);
		String assignedTo = excelUtil.getExcelData("Sheet1", 1, 5);
		
		/*Read Test data contacts*/
		String FIRSTNAME = excelUtil.getExcelData("Sheet1", 5, 1) + "_"+ javaUtil.getRandomData();
		String LASTNAME = excelUtil.getExcelData("Sheet1", 5, 2);
		String EMAIL = excelUtil.getExcelData("Sheet1", 5, 3);
		String PHONENUM = excelUtil.getExcelData("Sheet1", 5, 4);
		String ASSIGNEDTO = excelUtil.getExcelData("Sheet1", 5, 5);
		String LIFECYCLESTAGE = excelUtil.getExcelData("Sheet1", 5, 6);
		
		/*Launch the browser */
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		/*Login to App*/
		driver.get(URL);
		Login login = new Login(driver);
		login.loginToApp(USERNAME, PASSWORD);
		wutility.waitUntilPageLoad(driver);
		System.out.println("click login");
		

		 //Click menu button code
		 Home homePage = new Home(driver);
		// wutility.waitForElementVisibilityNew(driver, homePage.getMenu());
		 homePage.clickMenu();
		 System.out.println("click home");
		 wutility.waitUntilPageLoad(driver);
        homePage.selectOrg();
		 
      //Add Organization  code here
		 Organizations organi = new Organizations(driver);
		 organi.clickOrganisationBtn(); 
		 wutility.waitUntilPageLoad(driver);
		 
      //code for switch parent to child window
		wutility.switchParentToChildWindow(driver);
		
		 System.out.println("enter child window");
		 wutility.waitUntilPageLoad(driver);
		 
		 //create new organization code
		 CreateNewOrganization createOrg = new CreateNewOrganization(driver);
		 createOrg.createNewOrg(orgName, websiteName, phoneNumber);
		 wutility.waitUntilPageLoad(driver);
		 
		 WebElement typeO = createOrg.getType();
	     wutility.SelectOption(typeO,typeOption);
	     wutility.waitUntilPageLoad(driver);
	     
	     WebElement assignTo  = createOrg.getAssignedTo();
	     wutility.SelectAllOption(assignTo,assignedTo);
	     
	     wutility.waitUntilPageLoad(driver);
		 createOrg.clickSaveBtn();
	   //  wutility.waitUntilPageLoad(driver);
		 Thread.sleep(30000);

		 //Click menu button code
		 homePage.clickMenu();
		 System.out.println("click home");
		 wutility.waitUntilPageLoad(driver);
        homePage.clickContact();
		
        //Add contact btn
        AddContact addContact = new AddContact(driver);
        addContact.clickAddContact();
		 wutility.waitUntilPageLoad(driver);

	     //code for switch parent to child window
		 wutility.switchParentToChildWindow(driver);
			System.out.println("enter child window");
			 wutility.waitUntilPageLoad(driver);
			 
		//create contact  
			 CreateNewContact createContact = new CreateNewContact(driver);
			 createContact.createContactInfo(FIRSTNAME,LASTNAME,EMAIL,PHONENUM);
			 wutility.waitUntilPageLoad(driver);
			 createContact.clickSelectOrganization();
			 //code for switch parent to child window
				String parentWin = driver.getWindowHandle();
				wutility.switchParentToChildWindow(driver);
				
				 System.out.println("enter child window");
				 wutility.waitUntilPageLoad(driver);
				 
				WebElement table = driver.findElement(By.id("listview-table"));
				List<WebElement> allRows = table.findElements(By.tagName("tr"));
			for(WebElement rows:allRows) {
				List<WebElement> cells = rows.findElements(By.tagName("td"));
				for(WebElement cell:cells) {
					String callData = cell.getText();
					 wutility.waitUntilPageLoad(driver);
//					System.out.println(cell.getText());
					if(callData.equals("InfosysNew")) {
						cell.click();
					}
				}
			}
			 wutility.waitUntilPageLoad(driver);
			WebElement Assigned = createContact.getAssignedTo();
			wutility.SelectAllOption(Assigned, ASSIGNEDTO);
			 wutility.waitUntilPageLoad(driver);
        
			WebElement lifeCycle = createContact.getLifecycleStage();
			wutility.SelectAllOption(lifeCycle, LIFECYCLESTAGE);
			wutility.waitUntilPageLoad(driver);
		
			   createContact.clickSave();
			   driver.switchTo().window(parentWin);
				 Thread.sleep(30000);
				  
				 //Logout code
				 homePage.clickVtigerBtn();
				 wutility.waitUntilPageLoad(driver);
				 homePage.clickLogout();
				 driver.close();
	} 
}
