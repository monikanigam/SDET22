package com.crm.vtiger.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.Files;

public class WebDriverUtility {
/*
 * author @Monika
 */
	/**
	 * this method wait for 20 sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibilityNew(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method wait for element to be clicked
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while(count<=40) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public void SelectAllOption(WebElement element,String selectValue) {
		Select select1 = new Select(element);
		 List<WebElement> allOpt = select1.getOptions();
		 for(WebElement allOption:allOpt) {
			 if(allOption.getText().equals(selectValue)) {
				 allOption.click();
				 break;
			 }
		 }
	}
	/**
	 * this method enables user to dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void SelectOption(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * this methods enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	   * this method will perform mouse over action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method perform right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			String winId=it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle)) {
				break;
			}
		}
	}
	/**
	 * Accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * Cancel alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/** 
	 * This Method use for scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	/**
	 * This method is use for go inside the frame by use index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 *  This method is use for go inside the frame by use webelement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is use for go inside the frame by use idOrName
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	/**
	 * This Method is use for take webpage screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
	public String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		String screenshotPath = "./screenshot/"+screenshotName+JavaUtility.getCurrentDate()+".PNG";
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		FileUtils.copyFile(src, dest);
		return screenshotPath;
	}
	
	/**
	 * this method is use for press Enter key
	 * @throws Throwable
	 */
	public void pressEnterKey() throws Throwable {
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 */
	public void switchParentToChildWindow(WebDriver driver) {
		 Set<String> childWin = driver.getWindowHandles();
			for(String ch:childWin) {
				driver.switchTo().window(ch);
				System.out.println(driver.switchTo().window(ch).getTitle());  
			}
     
	}
	
	public void maximiseTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
}
