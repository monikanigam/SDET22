package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindAll({@FindBy(xpath="//i[@title='Menu']") , @FindBy(xpath="//i[@id='menu']")})
	
	@FindBy(xpath="//i[@id='menu']")
	private WebElement menuBtn;
	
	@FindBy(xpath="//span[text()='Organizations']")
	private WebElement selectOrgInMenu;
	
	@FindBy(xpath="//span[contains(@class,'border')]")
	private WebElement clickVtigerBtn;
	
	@FindBy(xpath="//div[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement selectContactInMenu;
	
	public WebElement getSelectContactInMenu() {
		return selectContactInMenu;
	}

	public WebElement getClickVtigerBtn() {
		return clickVtigerBtn;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getSelectOrgInMenu() {
		return selectOrgInMenu;
	}

	public WebElement getMenu() {
		return menuBtn;
	}
	
	public void clickMenu() {
		menuBtn.click();
	}
	
	public void selectOrg() {
		selectOrgInMenu.click();
	}
	
	public void clickVtigerBtn() {
		clickVtigerBtn.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickContact() {
		selectContactInMenu.click();
	}
	
}
