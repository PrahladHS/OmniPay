package com.demoQa.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStore {

	 WebDriver driver;
	
	 public BookStore(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='/books?book=9781449325862']")
	private WebElement bookOneLink;
	
	@FindBy(xpath = "//a[@href='/books?book=9781449331818']")
	private WebElement bookTwoLink;
	
	@FindBy(xpath = "//a[@href='/books?book=9781449337711']")
	private WebElement bookThreeLink;
	
	@FindBy(xpath = "//button[.='Add To Your Collection']")
	private WebElement addToYourCollBtn;
	
	@FindBy(xpath = "//button[.='Back To Book Store']")
	private WebElement backToStoreBtn;
	
	@FindBy(xpath = "//span[.='Profile']")
	private WebElement profileBtn;
	
	public WebElement getAddToYourCollBtn() {
		return addToYourCollBtn;
	}

	public void setAddToYourCollBtn(WebElement addToYourCollBtn) {
		this.addToYourCollBtn = addToYourCollBtn;
	}

	public WebElement getBackToStoreBtn() {
		return backToStoreBtn;
	}

	public void setBackToStoreBtn(WebElement backToStoreBtn) {
		this.backToStoreBtn = backToStoreBtn;
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public void setProfileBtn(WebElement profileBtn) {
		this.profileBtn = profileBtn;
	}

	public WebElement getBookOneLink() {
		return bookOneLink;
	}

	public WebElement getBookTwoLink() {
		return bookTwoLink;
	}

	public WebElement getBookThreeLink() {
		return bookThreeLink;
	}
	
	
	
}
