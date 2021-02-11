package testCases_Pagewise;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.Guru_LoginPage;
public class LoginPage_testcases extends BaseClass {
	
	
	Guru_LoginPage lp;
	
	
	@Test(groups= {"Regression"})
	public void logintest_TC_001()
	{
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName(uname);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		logger.info("Browser launched and LoginButton Clicked");
		
		if(isAlertPresent())
		{
			String message=getAlertText();
			getscreenShot(driver, "logintest_TC_001");
			Assert.assertTrue(false);
			logger.info("Test case Failed Invalid user credentials"+message);
			acceptAlert();
			
		}
		else
		{
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test case Passed");
		}
		}
		
		
	}
	
	
	
	/*@Test
	public void logintest_TC_002()
	{
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName(uname);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		logger.info("Browser launched and LoginButton Clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(false);
			logger.info("Test case Passed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Test case Failed");
		}
		
	}*/
	
	
}
