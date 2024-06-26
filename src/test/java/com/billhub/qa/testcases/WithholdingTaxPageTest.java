package com.billhub.qa.testcases;

import com.billhub.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.billhub.qa.base.TestBase;
import com.billhub.qa.pages.LoginPage;
import com.billhub.qa.pages.MdmDashboardPage;
import com.billhub.qa.pages.WithholdingTaxPage;

import java.time.Duration;

public class WithholdingTaxPageTest extends TestBase{
	
	LoginPage loginPage;
	MdmDashboardPage mdmDashboardPage;
	WithholdingTaxPage withholdingTaxPage;
	public Object[][] data;
	
	public WithholdingTaxPageTest() {
		super();
	}

	public void updateExcelSheetData() {

		String random_WTAX_code= TestUtils.generateRandomNumber(2);
		String random_WRATE_code=TestUtils.generateRandomNumber(2);
		TestUtils.setCellData("WithholdingTax", 1, 1, random_WTAX_code);
		TestUtils.setCellData("WithholdingTax",1,2,random_WRATE_code);
	}
	
	@BeforeClass
	public void setup(){

		initialization();
		loginPage= new LoginPage();
		mdmDashboardPage = loginPage.loginAsMdm(prop.getProperty("mdm_userid"),prop.getProperty("mdm_password"));
		withholdingTaxPage = mdmDashboardPage.clickOnWithholdingTaxLink();
		updateExcelSheetData();
		data = TestUtils.getTestData("WithholdingTax");
	}


	@Test(priority = 1)
	public void AddTaxWithValidDataTest(){

		String tax_Type=(String) data[0][0], tax_Code=(String) data[0][1], tax_Rate=TestUtils.numberToString(data[0][2]), tax_Description=(String) data[0][3];
		
		boolean result=withholdingTaxPage.validateAddTaxWithValidData(tax_Type,tax_Code,tax_Rate,tax_Description);
		Assert.assertTrue(result,"Withholding tax add failed");
	}
	
	@Test(priority = 2)
	public void AddWithholdingTaxWithDuplicateDataTest(){

		// pass duplicate credentials in arguments
		String tax_Type=(String) data[0][0], tax_Code=(String) data[0][1], tax_Rate=TestUtils.numberToString(data[0][2]), tax_Description=(String) data[0][3];
		
		boolean result=withholdingTaxPage.validateAddWithholdingTaxWithDuplicateData(tax_Type,tax_Code,tax_Rate,tax_Description);
		Assert.assertFalse(result,"Test Failed!: duplicate credentials has been saved");
	}

	@Test(priority = 3)
	public void SearchWithholdingTaxByRate(){

		String tax_Rate=TestUtils.numberToString(data[0][2]);
		
		boolean result=withholdingTaxPage.validateSearchWithholdingTax(tax_Rate);
		Assert.assertTrue(result, "Test failed!: Search functionality is not working properly");
	}
	
	@Test(priority = 4)
	public  void withholdingTaxAppearanceTest(){

		String tax_Rate=TestUtils.numberToString(data[0][2]);
		
		boolean result=withholdingTaxPage.validateWithholdingTaxInDatabase(tax_Rate);
		Assert.assertTrue(result,"Test failed!: No such tax record exist in table");
	}
	
	@Test(priority = 5)
	public void AddTaxWithBlankDataTest(){

		boolean result=withholdingTaxPage.validateAddTaxWithBlankData("","","","");
		Assert.assertFalse(result,"Test failed!: Withholding tax added with blank data");
	}
	
	@Test(priority = 6)
	public void AddTaxWithInvalidDataTest(){

		String tax_Type=(String) data[2][0], tax_Code=(String) data[2][1], tax_Rate=(String)data[2][2], tax_Description=(String) data[2][3];
		
		boolean result=withholdingTaxPage.validateAddTaxWithValidData(tax_Type,tax_Code,tax_Rate,tax_Description);
		Assert.assertFalse(result,"Test failed!: Withholding Tax has been added successfully with invalid data");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}

