package com.billhub.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.billhub.qa.base.TestBase;
import com.billhub.qa.utils.TestUtils;

public class BADashboardPage extends TestBase{
	
	@FindBy(xpath = "//button[@class='btn btn-primary ng-star-inserted']")
	WebElement createMemoBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Create Memo']")
	WebElement createMemoTab;
	
	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement POBasedInvoiceCheckbox;
	
	@FindBy(xpath = "//select[@id='frmState']")
	WebElement fromState;
	
	@FindBy(xpath = "//select[@id='toState']")
	WebElement toState;
	
	@FindBy(xpath = "//button[normalize-space()='Proceed Manually']")
	WebElement proceedManuallyBtn;

	@FindBy(xpath = "//a[normalize-space()='Filter']")
	WebElement filterBtn;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[1]/ngx-select-dropdown")
	 WebElement company;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[2]/ngx-select-dropdown")
	WebElement location;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[3]/ngx-select-dropdown")
	WebElement service;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[4]/ngx-select-dropdown/div/button")
	WebElement poBtn;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[5]/input")
	WebElement invoice;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[6]/input")
	WebElement memo;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[8]/button")
	WebElement applyBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[1]/ngx-select-dropdown/div/div/div/input")
	 WebElement companySearch;

	@FindBy(xpath = "//input[@name='search-text']")
	WebElement locationSearch;

	@FindBy(xpath="//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[3]/ngx-select-dropdown/div/div/div/input")
	WebElement serviceSearch;

	@FindBy(xpath ="//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[1]/ngx-select-dropdown/div/div/ul[2]/li")
	WebElement targetCompany;

	@FindBy(xpath= "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[2]/ngx-select-dropdown/div/div/ul[2]/li[1]")
	WebElement targetLocation;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[3]/ngx-select-dropdown/div/div/ul[2]")
	WebElement targetService;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[2]/div[2]/div/ul/li/form/div[4]/ngx-select-dropdown/div/div/ul[2]/li[3]")
	WebElement both;

	@FindBy(xpath="//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[4]/div[1]/span[2]/i")
	WebElement delCompany;

	@FindBy(xpath="//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[4]/div[1]/span[2]/i")
	WebElement delLocation;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[4]/div[1]/span[3]/i")
	WebElement delService;

	@FindBy(xpath="//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[4]/div[1]/span[2]/i")
	WebElement delMemo;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[1]/div[2]/div/input")
	WebElement viewMemoInput;

	@FindBy(xpath = "//button[normalize-space()='Upload & Continue']")
	WebElement uploadAndContinueBtn;
	
	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-po-popup/div[3]/button[1]")
	WebElement uploadBtn;
	
	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-po-popup/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[1]/div/input")
	WebElement poResultCheckBox;
	
	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-po-popup/div[2]/div[1]/div/form/div[2]/div/div/input")
	WebElement searchPoInput;
	
	@FindBy(xpath = "/html/body/modal-container/div/div/app-add-po-popup/div[2]/div[1]/div/form/div[2]/div/div/div/button")
	WebElement searchPoBtn;
	public BADashboardPage() {

		PageFactory.initElements(driver, this);
	}
	public void initializePopupWebElements(){
		PageFactory.initElements(driver,this);
	}

	
	public CreatePOBasedInvoicePage createNewMemoPOBased(String from_state, String to_state) {

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		TestUtils.waitForWebElementToBeClickable(createMemoBtn).click();
		TestUtils.waitForWebElementToBeClickable(createMemoTab).click();
		POBasedInvoiceCheckbox.click();
		fromState.sendKeys(from_state);
		toState.sendKeys(to_state);
		proceedManuallyBtn.click();
		return new CreatePOBasedInvoicePage();
	}

	public boolean filterByCompany(String company_name){

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		filterBtn.click();
		company.click();
		companySearch.sendKeys(company_name);
		targetCompany.click();
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		return TestUtils.matchSearchedData(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]/td[3]"), company_name);
	}

	public boolean filterByService(String service_name) {

		filterBtn.click();
		service.click();
		serviceSearch.sendKeys(service_name);
		targetService.click();
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		WebElement result=TestUtils.waitForElementVisibility(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]"));
		return result.isDisplayed();
	}

	public boolean filterByCompanyAndLocation(String company_name,String location_name){

		//		removing previously applied filters
		delService.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		delCompany.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));

		filterBtn.click();
		company.click();
		companySearch.sendKeys(company_name);
		targetCompany.click();
		viewMemoInput.click();
		location.click();
		locationSearch.sendKeys(location_name);
		targetLocation.click();
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		return TestUtils.matchSearchedData(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]/td[9]"), location_name);

	}
	 public boolean filterByLocation(String location_name) {

//		removing previously applied filters
		delLocation.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		delCompany.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));

		filterBtn.click();
		location.click();
		locationSearch.sendKeys(location_name);
		targetLocation.click();
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		return TestUtils.matchSearchedData(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]/td[9]"), location_name);
	 }

	public boolean filterByPo() {

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		delLocation.click();		// removing previously applied filters

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		filterBtn.click();
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		WebElement result=TestUtils.waitForElementVisibility(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]"));
		return result.isDisplayed();
	}

	public boolean filterByBoth() {

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		filterBtn.click();
		poBtn.click();
		both.click();
		TestUtils.waitForElementInvisibility(By.className("selected-items"));
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		WebElement result=TestUtils.waitForElementVisibility(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]"));
		return result.isDisplayed();
	}

	public boolean filterByCompanyServiceAndMemo(String company_name,String service_name,String memo_num) {

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		filterBtn.click();
		company.click();
		companySearch.sendKeys(company_name);
		targetCompany.click();

//		clicking outside to remove the selected dropdown which is covering other filter options
		viewMemoInput.click();
		service.click();
		serviceSearch.sendKeys(service_name);
		targetService.click();
		viewMemoInput.click();
		memo.sendKeys(memo_num);
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		WebElement result=TestUtils.waitForElementVisibility(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]"));
		return result.isDisplayed();
	}

	public boolean filterByInvoiceServiceAndLocation(String invo_num,String service_name,String loc_name) {

		// removing previously applied filters
		delMemo.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		delService.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		delCompany.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));

		filterBtn.click();
		invoice.sendKeys(invo_num);
		service.click();
		serviceSearch.sendKeys(service_name);
		targetService.click();
		viewMemoInput.click();
		location.click();
		locationSearch.sendKeys(loc_name);
		targetLocation.click();
		viewMemoInput.click();
		applyBtn.click();
		TestUtils.waitForElementVisibility(By.className("dashboard-table"));

		WebElement result=TestUtils.waitForElementVisibility(By.xpath("//*[@id=\"main\"]/main/div/div/app-dashboard/div/div[5]/div/table/tbody/tr[1]"));
		return result.isDisplayed();
	}

	public CreatePOBasedInvoiceWithExcelsheetPage createNewMemoPOBasedWithExcelsheet(String from_state, String to_state, String po_number) {
		
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		TestUtils.waitForWebElementToBeClickable(createMemoBtn).click();
		TestUtils.waitForWebElementToBeClickable(createMemoTab).click();
		
		POBasedInvoiceCheckbox.click();
		fromState.sendKeys(from_state);
		toState.sendKeys(to_state);
		uploadAndContinueBtn.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		
		// searching and tagging the PO to the invoice
		searchPoInput.sendKeys(po_number);
		searchPoBtn.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		TestUtils.waitForWebElementToBeClickable(poResultCheckBox).click();
		uploadBtn.click();
		return new CreatePOBasedInvoiceWithExcelsheetPage();
	}

	public CreateNonPOBasedInvoicePage createNewBTBased(){
		
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		TestUtils.waitForWebElementToBeClickable(createMemoBtn).click();
		TestUtils.waitForWebElementToBeClickable(createMemoTab).click();
		fromState.sendKeys("Rajasthan");
		toState.sendKeys("Kerala");
		proceedManuallyBtn.click();
		return new CreateNonPOBasedInvoicePage();
	}
}

