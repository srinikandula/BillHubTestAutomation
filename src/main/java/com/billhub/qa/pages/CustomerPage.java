package com.billhub.qa.pages;


import com.billhub.qa.base.TestBase;
import com.billhub.qa.utils.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage extends TestBase {
	
    @FindBy(xpath = "//input[@id='Customer_Name']")
    WebElement SearchCustomerByName;

    @FindBy(xpath = "//input[@id='Customer_Code']")
    WebElement SearchCustomerByCode;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement SearchCustomerBtn;

    @FindBy(xpath = "//button[@class='btn btn-secondary btn-verify-blue active']")
    WebElement addCustomerBtn;
    
    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    WebElement updateBtn;
    
    @FindBy(css = "div[class='has-float-label form-group col-md-6'] input[type='text']")
    WebElement customerCode;
    
    @FindBy(css = "div[class='modal-body pb-0'] div:nth-child(2) input:nth-child(1)")
    WebElement customerName;
    
    @FindBy(css = "input[formcontrolname='Credit_Period']")
    WebElement customerPeriod;
    
    @FindBy(id = "Vertical")
    WebElement verticalDropdown;
    
    @FindBy(css = "#defaultCheck2")
    WebElement ActiveCheckBox;
    
    @FindBy(css = "button[class='btn btn-primary btn-done']")
    WebElement addBtn;

    @FindBy(css = "button[class='btn btn-danger btn-done']")
    WebElement closeBtn;

    public CustomerPage(){
        PageFactory.initElements(driver,this);
    }
    
    public void initializePopupWebElements(){
        PageFactory.initElements(driver,this);
    }
    
    public void fillNewCustomerForm(String customer_code,String customer_name, String customer_period, String customer_drop){

    	addCustomerBtn.click();
    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
        initializePopupWebElements();
        customerCode.sendKeys(customer_code);
        customerName.sendKeys(customer_name);
        customerPeriod.sendKeys(customer_period);
        Select selectVertical = new Select(verticalDropdown);
        selectVertical.selectByVisibleText(customer_drop);

    }
    public boolean searchAddedCustomerByCode(String customer_code) {

    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
        SearchCustomerByCode.clear();
        SearchCustomerByName.clear();
        SearchCustomerByCode.sendKeys(customer_code);
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        SearchCustomerBtn.click();
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        return TestUtils.matchSearchedData(By.xpath("//*[@id=\"main\"]/main/div/div/app-list-customer/div/div/div[3]/div/table/tbody/tr[1]/td[2]"), customer_code);
    }

    public boolean validateSearchCustomerByName(String customer_name){
	
    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
        SearchCustomerByCode.clear();
        SearchCustomerByName.clear();
        SearchCustomerByName.sendKeys(customer_name);
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        SearchCustomerBtn.click();
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        return TestUtils.matchSearchedData(By.xpath("//*[@id=\"main\"]/main/div/div/app-list-customer/div/div/div[3]/div/table/tbody/tr[1]/td[3]"),customer_name);
    }

    public boolean validateAddCustomerWithValidData(String custName, String custCode, String custPeriod, String custDrop){
	
    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
        TestUtils.waitForToastToDisappear();
        fillNewCustomerForm(custCode,custName,custPeriod,custDrop);
        
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        ActiveCheckBox.click();
        
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        addBtn.click();
        
        boolean isAdded = TestUtils.isSuccessToastDisplayed("customer Added successfully");
        if(isAdded == false) closeBtn.click();
        return isAdded;
    }

    public boolean validateAddCustomerWithInvalidData(String custName, String custCode, String custPeriod, String custDrop){
        
    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
    	TestUtils.waitForToastToDisappear();
    	fillNewCustomerForm(custCode,custName,custPeriod,custDrop);
    	
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        ActiveCheckBox.click();
        
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        addBtn.click();
        
        boolean isAdded = TestUtils.isSuccessToastDisplayed("customer Added successfully");
        if(isAdded == false) closeBtn.click();
        return isAdded;
    }

    public boolean validateAddNewCustomerWithoutData(String custName, String custCode, String custPeriod, String custDrop) {
        
    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
    	TestUtils.waitForToastToDisappear();
        fillNewCustomerForm(custCode, custName, custPeriod, custDrop);
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        ActiveCheckBox.click();
        
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        addBtn.click();
        
        boolean isAdded = TestUtils.isSuccessToastDisplayed("customer Added successfully");
        if(isAdded == false) closeBtn.click();
        return isAdded;
    }

    public boolean validateActiveStatus(String customer_code){

    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
    	SearchCustomerByCode.clear();
        SearchCustomerByName.clear();
        SearchCustomerByCode.sendKeys(customer_code);
        
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        SearchCustomerBtn.click();

        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        TestUtils.locateAndClickEditBtn(By.xpath("//*[@id=\"main\"]/main/div/div/app-list-customer/div/div/div[3]/div/table/tbody/tr/td[6]/i"));
        boolean isActive= ActiveCheckBox.isSelected();
        
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        closeBtn.click();
        return isActive;

    }

    public boolean validateInactiveStatus(String custName, String custCode, String custPeriod, String custDrop){

    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
    	fillNewCustomerForm(custCode, custName,custPeriod,custDrop);
    	
    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
        addBtn.click();
//        closeBtn.click();
        TestUtils.waitForElementInvisibility(By.className("modal-container"));
        return validateActiveStatus(custCode);
    }

    public boolean validateAddedCustomerInDatabase(String customer_code){

    	TestUtils.waitForElementInvisibility(By.className("modal-container"));
    	SearchCustomerByCode.clear();
        return searchAddedCustomerByCode(customer_code);
    }

}
