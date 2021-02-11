package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.DepositAmount;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class AmountDeposit_Test extends BaseClass{
	
	
	Guru_LoginPage lp;
	DepositAmount dp;
	@Test
	public void depositAmount() throws InterruptedException
	{
		logger.info("********Amout Deposit Test Case*********");
		System.out.println("depositAmount method is called");
		driver.get(url);
		logger.info("Browser Launched and URL enetered");
		System.out.println("get URL method is called");
		//logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		dp=new DepositAmount(driver);
		lp.sendUserName(uname);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		//logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		
		logger.info("Browser launched and LoginButton Clicked");
		Thread.sleep(7000);
		dp.clickOnDepositLink();
		logger.info("Deposit Account  page is launched");
		String accountNumber="89477";
		dp.setCustomerAccountNo(accountNumber);
		dp.setAmount("89876");
		dp.setDescription("Emi Amout to deposit");
		dp.clickOnSubmitToDeposit();
		logger.info("Submit button clicked to deposit amount");
		
		if(isAlertPresent())
		{
			String alertMessage=getAlertText();
			System.out.println("Alert Status is  "+alertMessage);
			logger.info(alertMessage+" Alert is popUp");
			//logger.fatal("Do you really want to delete this Account?");
			acceptAlert();
						
		}
		else
		{
			String message=dp.getSuccessMessage();
			System.out.println("Success message is "+message);
			String expected="Transaction details of Deposit for Account "+accountNumber;
			Assert.assertEquals(message, expected);
			logger.info(message);
		}
		

}
}
