package com.actTime.testscript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.actTime.genericLibNew.BaseClass;
import com.actTime.genericLibNew.FileUtils;
import com.actTime.objectRepository.ActiveProjectAndCustomerPage;
import com.actTime.objectRepository.CreateNewCustomerPage;
import com.actTime.objectRepository.HomePage;
import com.actTime.objectRepository.OpenTaskPage;

public class CreateCustomer extends BaseClass
{
  FileUtils fis = new FileUtils();
  
  @Test
  public void createCustomerTest() throws Throwable
  {
	  //read the data from EXCEL
	  String customerName = fis.getExcelData("Sheet1", 1, 2);
	  
	  //Step 2 Navigate to Task Page
	  HomePage hp = PageFactory.initElements(driver, HomePage.class);
	  hp.navigateToTaskPage();
	  
	  //step 3 Navigate to ProjAndCustomer Page
	  OpenTaskPage op = PageFactory.initElements(driver, OpenTaskPage.class);
	  op.navigateToProjAndCustomerPage();
	  
	  //step 4 Navigate to customer Page
	  ActiveProjectAndCustomerPage ap = new ActiveProjectAndCustomerPage();
	  ap.navigateToCustomerPage();
	  
	  //step 5 Create Customer
	  CreateNewCustomerPage cnp = PageFactory.initElements(driver, CreateNewCustomerPage.class);
	  cnp.createCustomer(customerName);
  }
  
   @Test
	  public void createCustomerWithDespTest() throws Throwable
	  {
		  //read the data from EXCEL
		  String customerName = fis.getExcelData("Sheet1", 1, 2);
		  String customerDesp = fis.getExcelData("Sheet1", 2, 3);
		  
		  //Step 2 Navigate to Task Page
		  HomePage hp = PageFactory.initElements(driver, HomePage.class);
		  hp.navigateToTaskPage();
		  
		  //step 3 Navigate to ProjAndCustomer Page
		  OpenTaskPage op = PageFactory.initElements(driver, OpenTaskPage.class);
		  op.navigateToProjAndCustomerPage();
		  
		  //step 4 Navigate to customer Page
		  ActiveProjectAndCustomerPage ap = new ActiveProjectAndCustomerPage();
		  ap.navigateToCustomerPage();
		  
		  //step 5 Create Customer
		  CreateNewCustomerPage cnp = PageFactory.initElements(driver, CreateNewCustomerPage.class);
		  cnp.createCustomer(customerName,customerDesp);

  }
}
