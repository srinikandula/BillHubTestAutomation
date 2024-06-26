package com.billhub.qa.pages;

import com.billhub.qa.base.TestBase;
import com.billhub.qa.utils.TestUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceValidationByTaxation_1022_BT_Page extends TestBase{

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/a")
	WebElement filterBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[1]/ngx-select-dropdown/div/button")
	WebElement locationBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[1]/ngx-select-dropdown/div/div/div/input")
	WebElement locationInput;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[1]/ngx-select-dropdown/div/div/ul[2]/li")
	WebElement firstLocation;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[3]/ngx-select-dropdown/div/button")
	WebElement commercialNameBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[3]/ngx-select-dropdown/div/div/div/input")
	WebElement commercialNameInput;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[5]/input")
	WebElement documentNumberInput;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[3]/div[1]/table/tbody/tr[1]/td[6]")
	WebElement firstRowDocumentNumber;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[3]/ngx-select-dropdown/div/div/ul[2]/li[1]")
	WebElement firstCommercialName;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[4]/div/label[3]/i")
	WebElement crossIcon;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[1]/div/ul/li/form/div[8]/button")
	WebElement applyBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[2]/div/div/label[1]")
	WebElement allInvoicesBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[2]/div/div/label[2]")
	WebElement pendingInvoicesBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[3]/button")
	WebElement raiseQueryBtn;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-raise-query/form/div[1]/div/select")
	WebElement selectReason;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-raise-query/form/div[2]/button[1]")
	WebElement validateBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[3]/div[1]/table/tbody[1]/tr[1]/td[2]/div/input")
	WebElement firstRowCheckBox;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[6]/button")
	WebElement exportBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[7]/button")
	WebElement DownloadBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[4]/button")
	WebElement correctInvoiceBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/main/div/div/app-account/div/div/div[2]/div/div/div[5]/button")
	WebElement blanketApproveBtn;

	@FindBy(xpath = "/html/body/modal-container/div/div/app-confirm-dialog/div[3]/button[1]")
	WebElement confirmationBtn;

	public InvoiceValidationByTaxation_1022_BT_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchInvoicesWithMultipleFields(String location, String commercial_name) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		filterBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		crossIcon.click();
		
		locationBtn.click();
		locationInput.sendKeys(location);
		TestUtils.waitForWebElementToBeClickable(firstLocation).click();
		locationBtn.click();
		
		commercialNameBtn.click();
		commercialNameInput.sendKeys(commercial_name);
		TestUtils.waitForWebElementToBeClickable(firstCommercialName).click();
		commercialNameBtn.click();
		
		applyBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		filterBtn.click();

		return TestUtils.isElementVisible(firstRowCheckBox);
	}
	
	public boolean searchInvoiceWithDocumentNumber(String location, String commercial_name, String document_number) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		filterBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		crossIcon.click();
		
		locationBtn.click();
		locationInput.sendKeys(location);
		TestUtils.waitForWebElementToBeClickable(firstLocation).click();
		locationBtn.click();
		
		commercialNameBtn.click();
		commercialNameInput.sendKeys(commercial_name);
		TestUtils.waitForWebElementToBeClickable(firstCommercialName).click();
		commercialNameBtn.click();
		
		documentNumberInput.sendKeys(document_number);
		
		applyBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		filterBtn.click();

		return StringUtils.containsIgnoreCase(firstRowDocumentNumber.getText(), document_number);
	}

	public boolean searchInvoicesWithInvalidData(String location, String commercial_name) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		filterBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		crossIcon.click();
		
		locationBtn.click();
		locationInput.sendKeys(location);
		TestUtils.waitForWebElementToBeClickable(firstLocation).click();
		locationBtn.click();
		
		commercialNameBtn.click();
		commercialNameInput.sendKeys(commercial_name);
		TestUtils.waitForWebElementToBeClickable(firstCommercialName).click();
		commercialNameBtn.click();
		
		applyBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		filterBtn.click();

		return TestUtils.isElementVisible(firstRowCheckBox);
	}
	
	public boolean validateAllInvoices() {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		allInvoicesBtn.click();
		TestUtils.waitForElementInvisibility(By.className("loader"));
		return TestUtils.isElementVisible(firstRowCheckBox);
	}

	public boolean validatePendingInvoices() {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		pendingInvoicesBtn.click();
		TestUtils.waitForElementInvisibility(By.className("loader"));
		return TestUtils.isElementVisible(firstRowCheckBox);
	}
	

	public boolean validateExportButton(String location, String commercial_name) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		searchInvoicesWithMultipleFields(location, commercial_name);
		firstRowCheckBox.click();
		TestUtils.waitForWebElementToBeClickable(exportBtn).click();
		TestUtils.waitForElementInvisibility(By.className("loader"));
		return true;
	}
	
	public boolean validateDownloadButton(String location, String commercial_name) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		searchInvoicesWithMultipleFields(location, commercial_name);
		firstRowCheckBox.click();
		TestUtils.waitForWebElementToBeClickable(DownloadBtn).click();
		TestUtils.waitForElementInvisibility(By.className("loader"));
		return true;
	}
	
	public boolean validateCorrectInvoices(String location, String commercial_name, String document_number) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		boolean isDocumentNumberFound = searchInvoiceWithDocumentNumber(location, commercial_name, document_number);
		
		if(isDocumentNumberFound == false) 		
			return false;
		
		firstRowCheckBox.click();
		correctInvoiceBtn.click();
		TestUtils.waitForElementInvisibility(By.className("loader"));
		confirmationBtn.click();
		
		return TestUtils.isSuccessToastDisplayed("Invoice updated successfully");
	}
	
	public boolean validateBlanketApprove(String location, String commercial_name) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		searchInvoicesWithMultipleFields(location, commercial_name);
		
		firstRowCheckBox.click();
		blanketApproveBtn.click();
		TestUtils.waitForElementInvisibility(By.className("loader"));
		confirmationBtn.click();
		
		return TestUtils.isSuccessToastDisplayed("Invoice updated successfully");
	}
	
	public boolean validateRaiseQuery(String location, String commercial_name, String reason) {
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		searchInvoicesWithMultipleFields(location, commercial_name);
		
		firstRowCheckBox.click();
		raiseQueryBtn.click();
		
		TestUtils.waitForElementInvisibility(By.className("loader"));
		selectReason.sendKeys(reason);
		validateBtn.click();
		
		return TestUtils.isSuccessToastDisplayed("Invoice updated successfully");
	}
}
