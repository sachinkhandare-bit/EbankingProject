package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
	WebDriver driver;
	
	public ChangePasswordPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.NAME, using="oldpassword")
	WebElement txt_oldpass;
	@FindBy(how=How.NAME, using="newpassword")
	WebElement txt_newpass;
	@FindBy(how=How.NAME, using="confirmpassword")
	WebElement txt_confirmpass;
	@FindBy(how=How.NAME, using="sub")
	WebElement btn_submit;
	
	public void enteroldPassword(String oldpass)
	{
		txt_oldpass.sendKeys(oldpass);
	}
	public void enterNewPassword(String newpass)
	{
		txt_newpass.sendKeys(newpass);
	}
	public void enterConfirmPassword(String confirmpass)
	{
		txt_confirmpass.sendKeys(confirmpass);
	}
	
	public void clickOnSubmitButton() {
		btn_submit.click();
		
	}
	
}
