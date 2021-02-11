package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
	
	WebDriver driver;
	
	public DeleteAccountPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH, using="//div//a[text()='Delete Account']")
	WebElement deleteAccountLink;
	@FindBy(name="accountno")
	WebElement txt_accountNo;
		
	@FindBy(name="AccSubmit")
	WebElement btn_submit;
	
	@FindBy()
	WebElement deleteConfiramtion;

	
	public void clickOnDeleteAccountLinlk() {
		deleteAccountLink.click();
		
	}
	public void enterAccountNumberToDelete(String uname)
	{
		txt_accountNo.sendKeys(uname);
	}
	public void submitAccountToDelete()
	{
		btn_submit.click();
	}
}
