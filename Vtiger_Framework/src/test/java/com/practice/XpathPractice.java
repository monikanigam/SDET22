package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class XpathPractice {

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	
	public static void main(String[]args) throws Throwable {
		// Open Chrome Browser
		WebDriver driver = new ChromeDriver();
		WebDriverUtility du = new WebDriverUtility();
		//Open Google.com
		driver.get("https://demoqa.com/tool-tips");
		WebElement hoverEle = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		du.mouseOver(driver, hoverEle);
		Thread.sleep(2000);
		WebElement toolTip = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		String msgText = toolTip.getText();
		System.out.println(msgText);
		driver.findElement(By.xpath("//input[@id='toolTipTextField']")).sendKeys(msgText); 
	}
}
   