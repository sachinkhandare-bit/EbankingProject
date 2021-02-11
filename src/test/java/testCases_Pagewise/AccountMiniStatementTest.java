package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.AccountMiniStatementPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class AccountMiniStatementTest extends BaseClass {
	
	Guru_LoginPage lp;
	AccountMiniStatementPage ms;
	
	@Test(groups= {"Sanity","Regression"})
	public void getMiniStatementValidAccountValidCustomer() throws InterruptedException
	{
		logger.info("getMiniStatementValidAccount for valid Account");
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("sachin@123");
		logger.info("Password Entered");
		lp.clickOnLoginButton();
		ms=new AccountMiniStatementPage(driver);
		ms.clickonMiniStatement();
		logger.info("Mini Statement link is clicked");
		logger.info("Login Button Clicked");
		Thread.sleep(5000);
		ms.enterAccountNumber("89477");
		ms.clickOnSubmitButton();
		logger.info("Submit button clicked");
		System.out.println("Submit button clicked!!!!!!!!!!!!");
		String expected="http://www.demo.guru99.com/v4/customer/MiniStatement.php";
		if(isAlertPresent()==false)
		{
			String actual=driver.getCurrentUrl();
			System.out.println("Driver Title"+actual);
			//String msg=ms.getSuccessMessage();
			//System.out.println("Message "+msg);
			Assert.assertEquals(actual, expected);
			logger.info("Mini statement generated successfuly");
				
		}
		else
		{
			logger.info("Alert is present");
			String alertText=getAlertText();
			System.out.println("Alert text is "+alertText);
			acceptAlert();
		}
		
	}
	@Test
	public void getMiniStatementInvalidAccount() throws InterruptedException
	{
		logger.info("getMiniStatementInvalidAccount for Invalid Account");
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("sachin@123");
		logger.info("Password Entered");
		lp.clickOnLoginButton();
		ms=new AccountMiniStatementPage(driver);
		ms.clickonMiniStatement();
		logger.info("Mini Statement link is clicked");
		logger.info("Login Button Clicked");
		Thread.sleep(5000);
		ms.enterAccountNumber("894781");
		ms.clickOnSubmitButton();
		logger.info("Submit button clicked");
		System.out.println("Submit button clicked!!!!!!!!!!!!");
		String expected="Account does not exist";
		if(isAlertPresent())
		{
			String alertText=getAlertText();

			logger.info("Alert is present"+alertText);
			System.out.println("Alert text is "+alertText);
			acceptAlert();
			Assert.assertEquals(alertText, expected);
		}
		else
		{
		
		logger.info("Mini statement generated successfuly");
		}
		
		}
	
	
	@Test
	public void getMiniStatementInvalidAccountForCustomer() throws InterruptedException
	{
		logger.info("getMiniStatementInvalidAccountForCustomer for Invalid Account");
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("sachin@123");
		logger.info("Password Entered");
		lp.clickOnLoginButton();
		ms=new AccountMiniStatementPage(driver);
		ms.clickonMiniStatement();
		logger.info("Mini Statement link is clicked");
		logger.info("Login Button Clicked");
		Thread.sleep(5000);
		ms.enterAccountNumber("89478");
		ms.clickOnSubmitButton();
		logger.info("Submit button clicked");
		System.out.println("Submit button clicked!!!!!!!!!!!!");
		String expected="You are not authorize to generate statement of this Account!!";
		if(isAlertPresent())
		{
			String alertText=getAlertText();
			//String expected="You are not authorize to generate statement of this Account!!";
			logger.info("Alert is present"+alertText);
			System.out.println("Alert text is "+alertText);
			acceptAlert();
			Assert.assertEquals(alertText, expected);
		}
		else
		{
		
		logger.info("Mini statement generated successfuly");
		}
		
		}
}