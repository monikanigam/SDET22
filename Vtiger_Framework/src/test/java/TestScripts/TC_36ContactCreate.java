package TestScripts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_36ContactCreate {

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	
	@Test
	public static void createContactPreviosMethod() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileUtility fileU = new FileUtility();
		WebDriverUtility wutility = new WebDriverUtility();
		
		String url = fileU.getPropertyKeyValue("url1");
		String username = fileU.getPropertyKeyValue("username1");
		String password = fileU.getPropertyKeyValue("password1");
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 wutility.waitUntilPageLoad(driver);
		 
       //Organization create code here
        driver.findElement(By.xpath("//i[@title='Menu']")).click();
        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
        driver.findElement(By.xpath("//button[@id='Contacts_listView_addRecord']")).click();
        
		 wutility.waitUntilPageLoad(driver);
      //  String parentWin = driver.getWindowHandle();
		Set<String> childWin = driver.getWindowHandles();
		for(String ch:childWin) {
			driver.switchTo().window(ch);
			System.out.println(driver.switchTo().window(ch).getTitle());
		}
		
		 wutility.waitUntilPageLoad(driver);
	//	 WebElement fElement = driver.findElement(By.xpath("//div[@name='firstname']"));
//		 JavascriptExecutor jse = (JavascriptExecutor)driver;
//		 jse.executeScript("arguments[0].value='Riya';", fElement);
		//input[@name='firstname']
		 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Riya");
		 
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mohan");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("riya123@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9086456782");
		//driver.findElement(By.xpath("//span[@id='select2-account_id-3l-container']")).sendKeys("Oracle");
		
		//ASSIGN_To dropdown
		   wutility.waitUntilPageLoad(driver);
		     WebElement assignTo = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
		Select select1 = new Select(assignTo);
		 List<WebElement> allOpt = select1.getOptions();
		 for(WebElement allOption:allOpt) {
			 if(allOption.getText().equals("Marketing Group")) {
				 allOption.click();
				 break;
			 }
		 }
		 
		 //LifeCycleStage Dropdown
	    wutility.waitUntilPageLoad(driver);
		WebElement lifecycleStage = driver.findElement(By.xpath("//select[@name='contacttype']"));
		Select select2 = new Select(lifecycleStage);
		 List<WebElement> allOpti = select2.getOptions();
		 for(WebElement allOption:allOpti) {
			 if(allOption.getText().equals("Sales Qualified Lead")) {
				 allOption.click();
				 break;
			 }
		 }
        
		 //Status DropDown
		 wutility.waitUntilPageLoad(driver);
		 WebElement status = driver.findElement(By.xpath("//select[@name='contactstatus']"));
			Select select3 = new Select(status);
			 List<WebElement> allOptin = select3.getOptions();
			 for(WebElement allOption:allOptin) {
				 if(allOption.getText().equals("Warm")) {
					 allOption.click();
					 break;
				 }
			 }
		 
			 wutility.waitUntilPageLoad(driver);
			 driver.findElement(By.xpath("//button[text()='Save']")).click();	
			 
			 driver.close();
	}
}
