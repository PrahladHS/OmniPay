package com.demoQa.genericUtiity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import com.demoQa.pomrepo.LoginPage;
import com.demoQa.pomrepo.RegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	LoginPage login;
	String uName;
	String pWd;
/** to launch the browser and to register**/
	@BeforeClass
	public void configBC() throws Throwable
	{
		String URL = fLib.getPropertyFiles("url");
		String BROWSER = fLib.getPropertyFiles("browser");
		String fName = fLib.getPropertyFiles("firstname");
		String lName = fLib.getPropertyFiles("lastname");
		uName = fLib.getPropertyFiles("username");
		pWd = fLib.getPropertyFiles("password");
		if(BROWSER.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		     driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		wLib.waitForpageLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
//		login=new LoginPage(driver);
//		wLib.scrollToWebElement(driver, login.getNewUserBtn());
//		login.getNewUserBtn().click();
//		RegisterPage reg=new RegisterPage(driver);
//		reg.Register(fName, lName, uName, pWd);
//		wLib.switchFrame(driver, 2);
//		wLib.scrollToWebElement(driver, reg.getImNotaRobBtn());
//		reg.getImNotaRobBtn().click();
//		driver.switchTo().defaultContent();
//		wLib.scrollToWebElement(driver, reg.getRegisterBtn());
//		reg.getRegisterBtn().click();
	}
	/** to login**/
	@BeforeMethod
	public void configBM() throws Throwable
	{
		login.getUserNameTxt().sendKeys(uName);
		wLib.scrollToWebElement(driver, login.getPasswordTxt());
		login.getPasswordTxt().sendKeys(pWd);
		wLib.scrollToWebElement(driver, login.getLoginBtn());
		login.getLoginBtn().click();
	}
	@AfterMethod
	public void configAM()
	{
		
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}

	}
