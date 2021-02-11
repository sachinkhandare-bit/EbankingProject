package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage {
	
	WebDriver driver;
	
	public AddNewAccountPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using="//div/ul/li/a[text()='New Account']")
	WebElement newAccountlink;
	@FindBy(name="cusid")
	WebElement customer_ID;
	@FindBy(name="selaccount")
	WebElement customer_sccount_type;
	@FindBy(name="inideposit")
	WebElement intialAamount;
	@FindBy(name="button2")
	WebElement btn_submit;
	
	@FindBy(how=How.XPATH, using="//p[@class='heading3']")
	WebElement successMessage;
	
	public void clickOnNewAccountLinlk() {
		newAccountlink.click();
		
	}
	public void enterCustomerID(String uname)
	{
		customer_ID.sendKeys(uname);
	}
	public void selectCustomerAccountType(String type) {
		Select select=new Select(customer_sccount_type);
		select.selectByValue(type);
		System.out.println("Account type selected is "+select.getFirstSelectedOption().getText());
		
	}
	public void setIntialAmount(String amount) {
		intialAamount.sendKeys(amount);
	}
	
	public void submitToCreateNewAccount()
	{
		btn_submit.click();
	}
	
	public String getSuccessMessage()
	{
		String sMEssage=successMessage.getText();
		return sMEssage;
	}

}
