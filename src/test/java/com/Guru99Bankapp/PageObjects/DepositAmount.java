package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DepositAmount {
	
	WebDriver driver;
	
	public DepositAmount(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH, using="//div/ul/li/a[text()='Deposit']")
	WebElement depositAccountLink;
	@FindBy(how=How.XPATH, using="//a[text()='Deposit']")
	WebElement successMessage;
	
	@FindBy(name="accountno")
	WebElement txt_accountno;
	@FindBy(name="AccSubmit")
	WebElement btn_accsubmit;
	
	@FindBy(name="ammount")
	WebElement txt_amount;
	
	@FindBy(name="desc")
	WebElement txt_description;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	public void clickOnDepositLink() {
		
		js.executeScript("arguments[0].scrollIntoView();", depositAccountLink);
		depositAccountLink.click();
		
	}
	public void setCustomerAccountNo(String cid) {
		txt_accountno.sendKeys(cid);
		
	}
	public void setAmount(String cid) {
		txt_amount.sendKeys(cid);
		
	}
	public void setDescription(String cid) {
		txt_description.sendKeys(cid);
		
	}
	
	public void clickOnSubmitToDeposit() {
		btn_accsubmit.click();
		
	}
		
	public String getSuccessMessage()
	{
		String message=successMessage.getText();
		return message;
		
	}


}
