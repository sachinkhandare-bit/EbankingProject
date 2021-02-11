package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BalanceEnquiryPage {
	
	WebDriver driver;
	
	public BalanceEnquiryPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.NAME, using="accountno")
	WebElement selectaccountNo;
	@FindBy(how=How.NAME, using="AccSubmit")
	WebElement btn_submit;
	@FindBy(how=How.CSS, using="p[class='heading3']")
	WebElement successmessage;
	
	public void selectAccount(String accno)
	{
		System.out.println("Account Selec");
		Select selctacc=new Select(selectaccountNo);
		selctacc.selectByVisibleText(accno);
		System.out.println("Account Number selected is "+selctacc.getFirstSelectedOption().getText());
		//selectaccountNo.sendKeys(accno);
	}
	
	public void clickOnSubmitButton() {
		btn_submit.click();
		
	}
	public String successMessage() {
		String message=successmessage.getText();
		return message;
		
	}

}
