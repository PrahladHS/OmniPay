package com.demoQa.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id = "firstname")
private WebElement firstNameTxt;

@FindBy(id="lastname")
private WebElement lastNameTxt;

@FindBy(id="userName")
private WebElement userNameTxt;

@FindBy(id="password")
private WebElement passwordTxt;

@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
private WebElement imNotaRobBtn;

@FindBy(id="register")
private WebElement registerBtn;


public WebElement getFirstNameTxt() {
	return firstNameTxt;
}
public WebElement getLastNameTxt() {
	return lastNameTxt;
}
public WebElement getUserNameTxt() {
	return userNameTxt;
}
public WebElement getPasswordTxt() {
	return passwordTxt;
}
public WebElement getImNotaRobBtn() {
	return imNotaRobBtn;
}
public WebElement getRegisterBtn() {
	return registerBtn;
}

public void Register(String fName,String lName,String uName,String pWd)
{
	firstNameTxt.sendKeys(fName);
	lastNameTxt.sendKeys(lName);
	userNameTxt.sendKeys(uName);
	passwordTxt.sendKeys(pWd);
}
}
