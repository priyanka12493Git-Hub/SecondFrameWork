package com.actTime.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseClass 
{
   public static WebDriver driver;   //Object Declaration
   
   @BeforeSuite
    public void confiqBS()
    {
	   System.out.println("Connect to DataBase");
    }
   @BeforeClass
    public void confiqBC()
    {
	   driver =  new FirefoxDriver();  // Object initialiazation
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get("http://priya/login.do");
	   driver.manage().window().maximize();
    }
   @BeforeMethod
   public void confiqBM()
   {
	   System.out.println("Login");
	   driver.findElement(By.name("username")).sendKeys("admin");
	   driver.findElement(By.name("pwd")).sendKeys("manager");
	   driver.findElement(By.id("loginButton")).click();
   }
   
  @AfterMethod
    public void confiqAM()
   {
	System.out.println("logout");  
	driver.findElement(By.linkText("Logout")).click();
   }

  @AfterClass
  public void confiqAC()
  {
	  System.out.println("Close the browser");
	  driver.close();
  }
  
  @AfterSuite
   public void confiqAS()
   {
	  System.out.println("Disconnect to Database");
   }
}
