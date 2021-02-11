package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditCustomerAccount {
WebDriver driver;
	
	public EditCustomerAccount(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH, using="//div/ul/li/a[text()='Edit Account']")
	WebElement editAccountLink;
	@FindBy(how=How.XPATH, using="//table//p[text()='Account details updated Successfully!!!']")
	WebElement successMessage;
	
	@FindBy(name="accountno")
	WebElement txt_accountno;
	@FindBy(name="AccSubmit")
	WebElement btn_accsubmit;
	
	@FindBy(name="res")
	WebElement btn_reset;
	
	@FindBy(name="a_type")
	WebElement customer_account_type;
	
	
	
	public void clickOnEditAccountLink() {
		editAccountLink.click();
		
	}
	public void setCustomerAccountNo(String cid) {
		txt_accountno.sendKeys(cid);
		
	}
	
	public void clickOnSubmitToEditAccount() {
		btn_accsubmit.click();
		
	}
		
	public void selectCustomerAccountType(String type) {
		Select select=new Select(customer_account_type);
		select.selectByValue(type);
		System.out.println("Account type selected is "+select.getFirstSelectedOption().getText());
		
	}
	
	public void clickOnSubmitToUpdateAccount() {
		btn_accsubmit.click();
		
	}
	
	public String accountUpdatedMessage()
	{
		String message=successMessage.getText();
		return message;
		
	}

}
