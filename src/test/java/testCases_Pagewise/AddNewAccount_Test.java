package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.AddNewAccountPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class AddNewAccount_Test extends BaseClass {
	Guru_LoginPage lp;
	AddNewAccountPage ac;
	
	@Test(groups= {"Regression"})
	public void addNewAccount() throws InterruptedException
	{
		logger.info("*****Add New Account Test case**********");
		/*System.out.println("AddnewAccount method is called");
		driver.get(url);
		logger.info("Browser Launched and URL enetered");
		System.out.println("get URL method is called");
		//logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		ac=new AddNewAccountPage(driver);
		lp.sendUserName(uname);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		//logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();*/
		
		
		ac=new AddNewAccountPage(driver);
		LoginPage_testcases lt=new LoginPage_testcases();
		lt.logintest_TC_001();
		
		logger.info("Browser launched and LoginButton Clicked");
		ac.clickOnNewAccountLinlk();
		logger.info("New Account open page is launched");
		ac.enterCustomerID("44984");
		ac.selectCustomerAccountType("Current");
		ac.setIntialAmount("5000");
		ac.submitToCreateNewAccount();
		
		if(isAlertPresent())
		{
			String alertText=getAlertText();
			System.out.println("Alert Text is "+alertText);
			logger.info(" Accounte does not created!!"+alertText);
			getscreenShot(driver, "addNewAccount");
			acceptAlert();
		}
		else
		{		
		String message=ac.getSuccessMessage();
		String actualMessage="Account Generated Successfully!!!";
		Assert.assertEquals(actualMessage, message);
		logger.info("Account Generated Successfully!!!  Alert Text is "+message);
		//acceptAlert();
		}
	}
	
}