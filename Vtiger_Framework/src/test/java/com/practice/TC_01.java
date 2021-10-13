package com.practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.comcast.pomrepositrylib.AddContact;
import com.vtiger.comcast.pomrepositrylib.CreateNewContact;
import com.vtiger.comcast.pomrepositrylib.Home;

import io.github.bonigarcia.wdm.WebDriverManager;

// TEST CASE IS SELECT "TEAM SELLING" IN ASSIGNED TO DROP DOWN 
public class TC_01 extends BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	@Test(groups = {"smoketest","regression"})
	public  void contact10Group() throws Throwable {
		WebDriverManager.chromedriver().setup();
		
		/*Read Test data*/
		String FIRSTNAME = eLib.getExcelData("Sheet1", 5, 1) + "_"+ jLib.getRandomData();
		String LASTNAME = eLib.getExcelData("Sheet1", 5, 2);
		String EMAIL =  jLib.getRandomData()+"_"+eLib.getExcelData("Sheet1", 5, 3);
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

	


