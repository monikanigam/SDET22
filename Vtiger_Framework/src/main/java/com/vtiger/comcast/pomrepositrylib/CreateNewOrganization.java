package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {

	WebDriver driver;
	public CreateNewOrganization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//label[text()='Organization Name']/../../..//input[@name='accountname']")
	private WebElement OrganizationName;
	
	@FindBy(xpath="//label[text()='Website']/../../..//input[@name='website']")
	private WebElement websiteName;
	
	@FindBy(xpath="//label[text()='Phone']/../../..//input[@name='phone']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement assignedTo;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveBtn;


	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getWebsiteName() {
		return websiteName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getAssignedTo() {
		return assignedTo;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createNewOrg(String orgnizationName, String website, String phoneNum) {
		OrganizationName.sendKeys(orgnizationName);
		websiteName.sendKeys(website);
		phoneNumber.sendKeys(phoneNum);
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	
}
