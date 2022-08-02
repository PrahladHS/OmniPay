package com.DemoQa.BookStoreTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoQa.genericUtiity.BaseClass;
import com.demoQa.genericUtiity.FileUtility;
import com.demoQa.genericUtiity.WebDriverUtility;
import com.demoQa.pomrepo.BookStore;
import com.demoQa.pomrepo.LoginPage;
import com.demoQa.pomrepo.Profile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookStoreTest {
	
	public WebDriver driver;
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	
@Test
public void validateAddedBooks() throws Throwable
{
	WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	String URL = fLib.getPropertyFiles("url");
	String BROWSER = fLib.getPropertyFiles("browser");
	String fName = fLib.getPropertyFiles("firstname");
	String lName = fLib.getPropertyFiles("lastname");
	String uName = fLib.getPropertyFiles("username");
	String pWd = fLib.getPropertyFiles("password");
	wLib.waitForpageLoad(driver);
	driver.manage().window().maximize();
	driver.get(URL);
	LoginPage login=new LoginPage(driver);
	login.getUserNameTxt().sendKeys(uName);
	wLib.scrollToWebElement(driver, login.getPasswordTxt());
	login.getPasswordTxt().sendKeys(pWd);
	wLib.scrollToWebElement(driver, login.getLoginBtn());
	login.getLoginBtn().click();
	Thread.sleep(3000);
	
	//navigate to book store
	Profile p=new Profile(driver);
	wLib.scrollToWebElement(driver, p.getGoToBookStoreBtn());
	p.getGoToBookStoreBtn().click();
	
	//add first book to your collection
	BookStore store=new BookStore(driver);
	String FirstBook = store.getBookOneLink().getText();
	store.getBookOneLink().click();
	wLib.scrollToWebElement(driver, store.getAddToYourCollBtn());
	store.getAddToYourCollBtn().click();
	wLib.AcceptAlert(driver);
	
	//go back to book store
	store.getBackToStoreBtn().click();
	
	//add second book to your collection
		
		String SecondBook = store.getBookOneLink().getText();
		store.getBookTwoLink().click();
		wLib.scrollToWebElement(driver, store.getAddToYourCollBtn());
		store.getAddToYourCollBtn().click();
		wLib.AcceptAlert(driver);
		
		//add third book to your collection
				wLib.scrollToWebElement(driver, store.getBookThreeLink());
				String ThirdBook = store.getBookOneLink().getText();
				store.getBookThreeLink().click();
				wLib.scrollToWebElement(driver, store.getAddToYourCollBtn());
				store.getAddToYourCollBtn().click();
				wLib.AcceptAlert(driver);
				
				//navigate to profile
				wLib.scrollToWebElement(driver, store.getProfileBtn());
				store.getProfileBtn().click();
				
				//verify the added books
				String ExpFirstBook="Git Pocket Guide";
				String ExpSecondBook="Learning JavaScript Design Patterns";
				String ExpThirdBook="Designing Evolvable Web APIs with ASP.NET";
				Assert.assertEquals(FirstBook, ExpFirstBook);
				Assert.assertEquals(SecondBook, ExpSecondBook);
				Assert.assertEquals(ThirdBook, ExpThirdBook);
}
}
