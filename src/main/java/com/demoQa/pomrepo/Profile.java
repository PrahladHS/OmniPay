package com.demoQa.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	 WebDriver driver;
	
	 public Profile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(id="gotoStore")
private WebElement goToBookStoreBtn;

public WebElement getGoToBookStoreBtn() {
	return goToBookStoreBtn;
}


}
