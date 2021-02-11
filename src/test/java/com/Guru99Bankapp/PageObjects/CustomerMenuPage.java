package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerMenuPage {
	
	WebDriver driver;
	
	public CustomerMenuPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	//static By balanceenquirylink=By.xpath("//div//a[text()='Balance Enquiry']");
	@FindBy(how=How.XPATH, using="//div//a[text()='Balance Enquiry']")
	
	WebElement balanceenquirylink;
	@FindBy(how=How.XPATH, using="//div//a[text()='Fund Transfer']")
	
	WebElement fundtransferlink;
	@FindBy(how=How.XPATH, using="//div//a[text()='Changepassword']")
	
	WebElement changepasswordlink;
	@FindBy(how=How.XPATH, using="//div//a[text()='Mini Statement']")
	
	WebElement ministatementlink;
	@FindBy(how=How.XPATH, using="//div//a[text()='Customised Statement']")
	
	WebElement customisedministatementlink;
	
	@FindBy(how=How.XPATH, using="//div//a[text()='Log out']")
	
	WebElement logoutlink;
	
	public void clickonBalanceEnquiry()
	{
		balanceenquirylink.click();
	}
	public  void clickonFundTransfer()
	{
		fundtransferlink.click();
	}
	public void clickonChangepassword()
	{
		changepasswordlink.click();
	}
	public void clickonMiniStatement()
	{
		ministatementlink.click();
	}
	public void clickoncustomisedMiniStatement()
	{
		customisedministatementlink.click();
	}
	public void clickonLogOut()
	{
		logoutlink.click();
	}

}
