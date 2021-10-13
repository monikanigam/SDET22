package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {


	WebDriver driver;
	public Organizations(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="Accounts_listView_addRecord")
	private WebElement addOrganisation;

	public WebElement getAddOrganisation() {
		return addOrganisation;
	}

	public void clickOrganisationBtn() throws Throwable {
		addOrganisation.click();
	}
}
