package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContact {

	WebDriver driver;
	public AddContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='Contacts_listView_addRecord']")
	private WebElement addContact;

	public WebElement getAddContactInMenu() {
		return addContact;
	}
	
	public void clickAddContact() {
		addContact.click();
	}
	
}
