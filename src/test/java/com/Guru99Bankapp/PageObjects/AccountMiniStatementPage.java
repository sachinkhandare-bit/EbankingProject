package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountMiniStatementPage extends CustomerMenuPage {
	
	WebDriver driver;
	
	public AccountMiniStatementPage(WebDriver ldriver)
	{   super(ldriver);
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name=("accountno")) 
	WebElement account_number;
		
	@FindBy(name=("AccSubmit"))
	WebElement btn_submit;
	
	@FindBy(how=How.XPATH, using="p[class='heading3']")
	WebElement successMessage;
	
				
	public void enterAccountNumber(String accno)
	{
		account_number.sendKeys(accno);
	}
	
	public void clickOnSubmitButton()
	{
		btn_submit.click();
	}
	
	public String getSuccessMessage()
	{ 
		String messsage="No Message";
		System.out.println("Get success method called");
		messsage=successMessage.getText();
		return messsage;
	}
}
