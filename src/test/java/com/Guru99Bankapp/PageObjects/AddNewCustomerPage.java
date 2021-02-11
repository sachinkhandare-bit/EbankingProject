package com.Guru99Bankapp.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	
	WebDriver driver;
	
	public AddNewCustomerPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using="//div//a[text()='New Customer']")
	WebElement newcutomerlink;
	@FindBy(name="name")
	WebElement customer_Name;
	@FindBy(name="rad1")
	WebElement customer_gender_RadioButton;
	@FindBy(how=How.ID, using="dob")
	WebElement customer_DOB;
	@FindBy(name="addr")
	WebElement customer_Address;
	
	@FindBy(name="city")
	WebElement customer_city;
	@FindBy(name="state")
	WebElement customer_state;
	@FindBy(name="pinno")
	WebElement customer_pinno;
	@FindBy(name="telephoneno")
	WebElement customer_mobileno;
	@FindBy(name="emailid")
	WebElement customer_emailID;
	@FindBy(name="password")
	WebElement customer_password;
	@FindBy(name="sub")
	WebElement submit_button;
	@FindBy(name="res")
	WebElement reset_button;
	
	public void clickOnNewCustomer() {
		newcutomerlink.click();
		
	}
	public void enterCustomerName(String uname)
	{
		customer_Name.sendKeys(uname);
	}
	public void setCustomerGender(String gender) {
		customer_gender_RadioButton.click();
	}
	public void setCustomerDOB(String dd, String mm, String yy) {
		customer_DOB.sendKeys(dd);
		customer_DOB.sendKeys(mm);
		customer_DOB.sendKeys(yy);
		
		
	}
	public void customerAddress(String address) {
		customer_Address.sendKeys(address);
		
	}

	public void customerCity(String city) {
		customer_city.sendKeys(city);
		
	}
	public void customerState(String state) {
		customer_state.sendKeys(state);
		
	}
	public void customerPin(String pin) {
		customer_pinno.sendKeys(pin);
	}
	public void customerPassword(String pass) {
		customer_password.sendKeys(pass);
	}
	public void customerEmaiID(String email) {
		customer_emailID.sendKeys(email);
	}
	public void customerMobileNo(String mobileno) {
		customer_mobileno.sendKeys(mobileno);
	}
	public void createNewCustomer() {
		submit_button.click();
	}
	
	public String verifyCustomerRegistration()
	{
		WebElement message=driver.findElement(By.xpath("//table//p[text()='Customer Registered Successfully!!!']"));
		String verifycustomer=message.getText();
		System.out.println("Message is "+verifycustomer);
		
		return verifycustomer;
	}
}
