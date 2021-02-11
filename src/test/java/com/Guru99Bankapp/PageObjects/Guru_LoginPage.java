package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class Guru_LoginPage {
	
	WebDriver driver;
	
	public Guru_LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name=("uid")) 
	WebElement user_name;
	
	@FindBy(how=How.NAME, using="password")
	WebElement user_pass;
	@FindBy(name=("btnLogin"))
	WebElement btn_login;
	
	@FindBy(xpath=("//a[text()='Log out']"))
	WebElement log_out_link;
	
	
	
	public void setUserName(String uname, String pass)
	{
		
		user_pass.sendKeys(pass);
	}
	
	public void setPassword(String pass)
	{
		user_pass.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		System.out.println("Buton click entered");
		btn_login.click();
		//System.out.println(" After Buton click ");
	}

	public void sendUserName(String uname) {
		System.out.println("Value entered");
		user_name.sendKeys(uname);		
	}
	public void clickOnLogoutLink()
	{
		log_out_link.click();
	}
}
