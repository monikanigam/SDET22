package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {

	WebDriver driver;
	public CreateNewContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phone;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement assignedTo;
	
	@FindBy(xpath="//select[@name='contacttype']")
	private WebElement lifecycleStage;
	
	@FindBy(xpath="//div[text()='The Last Name field is required.']")
	private WebElement actualMsg;
	
	@FindBy(xpath="//i[@class='fa-accounts']")
	private WebElement organizationSelect;
	
	@FindBy(xpath="//i[@class='fal fa-times c-pointer align-middle close']")
	private WebElement crossButton;
	
	public WebElement getCrossButton() {
		return crossButton;
	}
	public WebElement getOrganizationSelect() {
		return organizationSelect;
	}

	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveBtn;

	public WebElement getActualMsg() {
		return actualMsg;
	}
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getAssignedTo() {
		return assignedTo;
	}

	public WebElement getLifecycleStage() {
		return lifecycleStage;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContactInfo(String firstNAME, String lastNAME, String eMail, String phoneNUM) {
       firstName.sendKeys(firstNAME);
       lastName.sendKeys(lastNAME);
       email.sendKeys(eMail);
       phone.sendKeys(phoneNUM);
	}
	
	public void clickSave() {
		saveBtn.click();
	}
	public void createContactWithFirstN(String firstNAME) {
	       firstName.sendKeys(firstNAME);
	}
	
	public void clickSelectOrganization() {
		organizationSelect.click();
	}
	
	public void clickCrossButton() {
		crossButton.click();
	}
	
}
