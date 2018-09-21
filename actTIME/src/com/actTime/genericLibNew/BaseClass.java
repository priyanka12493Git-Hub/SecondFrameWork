package com.actTime.genericLibNew;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
    import com.actTime.objectRepository.CommonPage;
    import com.actTime.objectRepository.LoginPage;

	public abstract class BaseClass 
	{
	   public static WebDriver driver;   //Object Declaration
	   FileUtils fLib = new FileUtils();
	   
	   @BeforeSuite
	    public void confiqBS()
	    {
		   System.out.println("Connect to DataBase");
	    }
	   @BeforeClass
	    public void confiqBC()
	    {
		   System.out.println("Launch Browser");
		   driver =  new FirefoxDriver();  // Object initialiazation
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
	    }
	   @BeforeMethod
	   public void confiqBM() throws Throwable
	   {
		   Properties pObj = fLib.getPropertyFileObject();
		   String USERNAME =pObj.getProperty("username");
		   String PASSWORD =pObj.getProperty("password");
		   String URL =pObj.getProperty("url");
           System.out.println("login");
           driver.get(URL);
           LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
           lp.loginToApp(USERNAME,PASSWORD);
	   }
	   
	  @AfterMethod
	    public void confiqAM()
	   {
		CommonPage cp = PageFactory.initElements(driver, CommonPage.class);
		cp.logout();
	   }
	  
	  @AfterClass
	  public void confiqAC()
	  {
		  System.out.println("-----Close the browser-----");
		  driver.close();
	  }
	  
	  @AfterSuite
	   public void confiqAS()
	   {
		  System.out.println("Disconnect to Database");
	   }
	}

