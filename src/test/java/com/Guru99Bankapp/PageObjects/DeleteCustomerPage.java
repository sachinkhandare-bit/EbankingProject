package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	WebDriver driver;
	
	public DeleteCustomerPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH, using="//a[text()='Delete Customer']")
	WebElement deleteCustomerLink;
	@FindBy(how=How.XPATH, using="//table//p[text()='Customer details updated Successfully!!!']")
	WebElement successMessage;
	
	@FindBy(name="cusid")
	WebElement txt_cusid;
	@FindBy(name="AccSubmit")
	WebElement btn_submit;
	
	
	public void clickOnDeleteustomerLink() {
		deleteCustomerLink.click();
		
	}
	
	public void setCustomerID(String cid) {
		txt_cusid.sendKeys(cid);
		
	}
	public void clickOnSubmiToDelete() {
		btn_submit.click();
		
	}
	
}
