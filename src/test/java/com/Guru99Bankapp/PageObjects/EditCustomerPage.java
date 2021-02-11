package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver driver;
	
	public EditCustomerPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH, using="//div/ul/li/a[text()='Edit Customer']")
	WebElement editCustomerLink;
	@FindBy(how=How.XPATH, using="//table//p[text()='Customer details updated Successfully!!!']")
	WebElement successMessage;
	
	@FindBy(name="cusid")
	WebElement txt_cusid;
	@FindBy(name="AccSubmit")
	WebElement btn_submit;
	
	@FindBy(name="res")
	WebElement btn_reset;
	
	@FindBy(name="addr")
	WebElement update_Address;
	@FindBy(name="city")
	WebElement update_city;
	@FindBy(name="state")
	WebElement updatestate;
	@FindBy(name="telephoneno")
	WebElement update_mobile;
	@FindBy(name="pinno")
	WebElement update_pin;
	@FindBy(name="emailid")
	WebElement update_email;
	
	@FindBy(name="sub")
	WebElement btn_updateCustomer;
	
	
	public void clickOnEditCustomer() {
		editCustomerLink.click();
		
	}
	
	public void setCustomerID(String cid) {
		txt_cusid.sendKeys(cid);
		
	}
	public void updateAddress(String address) {
		update_Address.sendKeys(address);
		
	}

	public void updatecustomerCity(String city) {
		update_city.sendKeys(city);
		
	}
	public void updatecustomerState(String state) {
		updatestate.sendKeys(state);
		
	}
	public void updatecustomerPin(String pin) {
		update_pin.sendKeys(pin);
	}
	
	public void updatecustomerEmaiID(String email) {
		update_email.sendKeys(email);
	}
	public void updateMobileNo(String mobileno) {
		update_mobile.sendKeys(mobileno);
	}
	public void editCustomer() {
		btn_submit.click();
	}
	
	public void updateCustomerInfo()
	{
		btn_updateCustomer.click();
	}
	
	public String verifyCustomerUpdation()
	{
		String message=successMessage.getText();
		//String verifycustomer=message.getText();
		System.out.println("Message is "+message);
		
		return message;
	}
	
}
