package com.demoQa.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='newUser']")
	private WebElement newUserBtn;
	
	@FindBy(id="userName")
	private WebElement userNameTxt;
	
	@FindBy(id="password")
	private WebElement passwordTxt;
	
	@FindBy(id="login")
	private WebElement loginBtn;

	public WebElement getNewUserBtn() {
		return newUserBtn;
	}

	public WebElement getUserNameTxt() {
		return userNameTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void Login(String userName,String pWd)
	{
	userNameTxt.sendKeys(userName);	
	passwordTxt.sendKeys(pWd);
	loginBtn.click();
	}
	
}

