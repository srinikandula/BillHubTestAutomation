package com.billhub.qa.pages;

import com.billhub.qa.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.billhub.qa.base.TestBase;
import com.billhub.qa.utils.TestUtils;

public class LoginPage extends TestBase{

	@FindBy(xpath = "//input[@id='passwordInput']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='emailInput']")
	WebElement userId;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement loginBtn;

	public LoginPage(){
		PageFactory.initElements(driver,this);
	}

	public MdmDashboardPage loginAsMdm(String user,String pass){
		
		userId.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		return new MdmDashboardPage();
	}

	public BADashboardPage loginAsBa(String user, String pass){
		
		userId.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		return new BADashboardPage();
	}
	
	public CommercialDashboardPage loginAsCommercial(String user, String pass){
		
		userId.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();

		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		return new CommercialDashboardPage();
	}

	public AccountDashboardPage loginAsAccount(String user, String pass){
		
		userId.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		return new AccountDashboardPage();
	}
	
	public TaxationDashboardPage loginAsTaxation(String user, String pass){
		
		userId.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		TestUtils.waitForElementInvisibility(By.className("modal-container"));
		return new TaxationDashboardPage();
	}


}
