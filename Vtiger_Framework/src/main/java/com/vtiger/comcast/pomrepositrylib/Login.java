package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement loginButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp() {
		username.sendKeys("nigammonika5@gmail.com");
		password.sendKeys("Monika@7609");
		loginButton.click();
	}
	
	public void loginToApp(String usernameEdt, String passwordEdt)
	{
		username.sendKeys(usernameEdt);
		password.sendKeys(passwordEdt);
		loginButton.click();
	}
	
}
