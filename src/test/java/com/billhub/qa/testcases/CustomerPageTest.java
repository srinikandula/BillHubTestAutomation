package com.billhub.qa.testcases;

import com.billhub.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.billhub.qa.base.TestBase;
import com.billhub.qa.pages.CustomerPage;
import com.billhub.qa.pages.LoginPage;
import com.billhub.qa.pages.MdmDashboardPage;

import java.time.Duration;

public class CustomerPageTest extends TestBase{
	LoginPage loginPage;
	MdmDashboardPage mdmDashboardPage;
	CustomerPage customerPage;

	public Object[][] data=TestUtils.getTestData("Customer");
	public CustomerPageTest() {
		super();
	}
	
	@BeforeClass
	public void setup() throws InterruptedException  {
		initialization();
		loginPage= new LoginPage();
		mdmDashboardPage = loginPage.loginAsMdm(prop.getProperty("mdm_userid"),prop.getProperty("mdm_password"));
		Thread.sleep(Duration.ofSeconds(30).toMillis());
		customerPage = mdmDashboardPage.clickOnCustomerLink();
	}

	@Test(priority = 3)
	public void SearchCustomerByNameTest(){
			String customerName=(String) data[0][0];
			boolean result = customerPage.validateSearchCustomerByName(customerName);
			Assert.assertTrue(result, "Search Customer By Name Test Failed");
	}
	@Test(priority = 2)
	public void SearchCustomerByCodeTest(){
			String customerCode=TestUtils.numberToString(data[0][1]);
			boolean result = customerPage.validateSearchCustomerByCode(customerCode);
			Assert.assertTrue(result, "Search Customer By Code Test Failed");

	}
	@Test(priority = 1)
	public void AddCustomerWithValidDataTest(){
		String customerName=(String) data[0][0], customerCode=TestUtils.numberToString(data[0][1]),customerPeriod=TestUtils.numberToString(data[0][2]), customerDrop=(String) data[0][3];
		boolean result= customerPage.validateAddCustomerWithValidData(customerName,customerCode,customerPeriod,customerDrop);
		Assert.assertTrue(result,"Test failed");
	}
	@Test(priority = 6)
	public void AddCustomerWithInvalidDataTest(){
		String customerName=(String) data[1][0], customerCode=(String)data[1][1],customerPeriod=(String)data[1][2], customerDrop=(String) data[1][3];
		boolean isTestFailed = customerPage.validateAddCustomerWithInvalidData(customerName,customerCode,customerPeriod,customerDrop);
		Assert.assertFalse(isTestFailed, "Test failed as invalid data saved successfully.");
	}

	@Test(priority = 4)
	public void AddCustomerWithoutDataTest(){
		boolean result=customerPage.validateAddNewCustomerWithoutData("","","","");
		Assert.assertFalse(result,"Test failed as it has saved with blank data");
	}

	@Test(priority = 5)
	public void ValidateCustomerInDatabaseTest(){
		String customerCode=TestUtils.numberToString(data[0][1]);
		boolean isPresent = customerPage.validateAddedCustomerInDatabase(customerCode);
		Assert.assertTrue(isPresent, "Customer is present but not found in the database.");
	}
	@AfterClass
	public void tearDown() {
		driver.close();						
	}

}