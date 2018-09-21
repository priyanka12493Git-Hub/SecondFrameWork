package com.actTime.CustomerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.actTime.genericLib.BaseClass;

public class CustomerTest extends BaseClass
{
   @Test
   public void createCustomerTest()
   {
	  System.out.println("Create customer");
	  driver.findElement(By.xpath("//div[text()='Tasks']/..")).click();
	  driver.findElement(By.linkText("Projects & Customers")).click();
	  driver.findElement(By.xpath("//input[@value='Create New Customer']")).click();
	  driver.findElement(By.name("name")).sendKeys("Priya2");
	  driver.findElement(By.name("description")).sendKeys("priya file description");
	  driver.findElement(By.name("createCustomerSubmit")).click();
	  
   //verify the image
     String expMsg = "successfully created";
     String actMsg = driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
     if(actMsg.contains(expMsg))
     {
    	 System.out.println("Customer is successfully created==> PASS");
     }
     else
     {
    	 System.out.println("Customer is not successfully created==> FAIL");
     }
     
}  
   
   @Test
   public void modifyCustomerTest()
   {
	   System.out.println("Create customer and modify same customer");
	   driver.findElement(By.xpath("//div[text()='Tasks']/..")).click();
	   driver.findElement(By.linkText("Projects & Customers")).click();
	   driver.findElement(By.linkText("Priya3")).click();
	   WebElement wb = driver.findElement(By.name("name"));
	   wb.clear();
	   wb.sendKeys("Priya123");
	   driver.findElement(By.name("description")).sendKeys("Modification of file");
	   driver.findElement(By.name("saveChanges")).submit();	 
	   
	   //verify the message
	   
	     String expMsg = "Your changes have been saved.";
	     String actMsg = driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
	     if(actMsg.equals(expMsg))
	     {
	    	 System.out.println("Customer is successfully modified==> PASS");
	     }
	     else
	     {
	    	 System.out.println("Customer is not successfully modified==> FAIL");
	     }
   }
}
