package testCases_Pagewise;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.AddNewCustomerPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;


public class AddNewCustomer_Test extends BaseClass {
	//WebDriver driver;
	Guru_LoginPage lp;
	AddNewCustomerPage ac;
	String emailTitle;
	
	@Test(groups= {"Regression"})
	public void addNewCustomer() throws InterruptedException
	{
		/*logger.info("*********Add New Customer Test ***********");
		System.out.println("Addnewcustomer method is called");
		driver.get(url);
		logger.info("Browser Launched and URL enetered");
		System.out.println("get URL method is called");
		//logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		ac=new AddNewCustomerPage(driver);
		lp.sendUserName(uname);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		//logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();*/
		
		LoginPage_testcases lt=new LoginPage_testcases();
		lt.logintest_TC_001();
		ac=new AddNewCustomerPage(driver);
		logger.info("Browser launched and LoginButton Clicked");
		ac.clickOnNewCustomer();
		logger.info("Add new customer link is clicked");
		ac.enterCustomerName("Gajanan");
		ac.setCustomerGender("male");
		ac.setCustomerDOB("04","12","2017");
		ac.customerAddress("Shree Aprtment");
		ac.customerCity("Mumbai");
		ac.customerState("Maharashtara");
		ac.customerPin("767676");
		ac.customerMobileNo("8989897654");
		emailTitle=EmailStringGenarator();
		ac.customerEmaiID(emailTitle+"@gmail.com");
		ac.customerPassword("myPass");
		logger.info("Customer information is set");
		ac.createNewCustomer();
		
		Thread.sleep(5000);
		String pageTitle=driver.getTitle();
		System.out.println("Page Title after Customer Registration is "+pageTitle);
		//Verify whether mail id is exist or not using assert //Customer Id 53809
		if(isAlertPresent())
		{
			getscreenShot(driver, "addNewCustomer");
			String message=getAlertText();
			logger.info("Customer with mail id Alert text is "+message);
			Assert.assertFalse(false);
			logger.info("Test Case failed due to"+message);
			System.out.println("Customer having mailid is already Exist!!!!!!");
		}
		else
		{
			String expectedResult="Customer Registered Successfully!!!";
			
			Assert.assertEquals(expectedResult, ac.verifyCustomerRegistration());
			logger.info("Customer with mail id is Registered Successfully!!!");
		}
		
		
				
	}
	
	public static String EmailStringGenarator()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
		
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
