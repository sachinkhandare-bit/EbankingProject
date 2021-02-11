package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99Bank.utilities.ReadConfig;
import com.Guru99Bank.utilities.XLS_DataReadUtil;
import com.Guru99Bankapp.PageObjects.ChangePasswordPage;
import com.Guru99Bankapp.PageObjects.CustomerMenuPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class ChangePasswordTest extends BaseClass {
	//ReadConfig config=new ReadConfig();
	ChangePasswordPage cp;
	CustomerMenuPage cm;
	Guru_LoginPage lp;
	
	@Test(priority=2)
	public void changePasswordWrongPasswordTest()
	{
		System.out.println("changePassword method is called");
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("sachin@123");
		logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		logger.info("Browser launched and LoginButton Clicked");
		cp=new ChangePasswordPage(driver);
		cm=new CustomerMenuPage(driver);
		cm.clickonChangepassword();
		logger.info("Click on change password");
		cp.enteroldPassword("sggsggs");
		cp.enterNewPassword("mypass@123");
		cp.enterConfirmPassword("mypass@123");
		logger.info("Old password and new password entered");
		cp.clickOnSubmitButton();
		logger.info("Clicked on Submit Button");
		
		if(isAlertPresent())
		{
			String alerText=getAlertText();
			String expected="Please fill all fields";
			String expected2="Password is Changed";
			String expected3="Old Password is incorrect";
			if(alerText.equals(expected))
			{
			logger.info("Password Field is blanked alert is "+alerText);
			
			Assert.assertEquals(alerText, expected);
			acceptAlert();
			}
			else if(alerText.equals(expected2))
			{
				logger.info("Password changed successfully and alert is "+alerText);
				Assert.assertEquals(alerText, expected2);
				acceptAlert();
			}
			else if(alerText.equals(expected3))
			{
				logger.info("old Password is incorrect and Alert is "+alerText);
				Assert.assertEquals(alerText, expected2);
				acceptAlert();
			}
			else
			{
				logger.info("Un Expected condition is occured!!!!");
			}
		}
		
	}

	
	@Test(priority=3)
	public void changePasswordCorrectData()
	{
		System.out.println("changePassword method is called");
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("sachin@123");
		logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		logger.info("Browser launched and LoginButton Clicked");
		cp=new ChangePasswordPage(driver);
		cm=new CustomerMenuPage(driver);
		cm.clickonChangepassword();
		logger.info("Click on change password");
		cp.enteroldPassword("sachin@123");
		cp.enterNewPassword("sachin@12");
		cp.enterConfirmPassword("sachin@12");
		logger.info("Old password and new password entered");
		cp.clickOnSubmitButton();
		logger.info("Clicked on Submit Button");
		
		if(isAlertPresent())
		{
			String alerText=getAlertText();
			String expected="Please fill all fields";
			String expected2="Password is Changed";
			String expected3="Old Password is incorrect";
			if(alerText.equals(expected))
			{
			logger.info("Password Field is blanked alert is "+alerText);
			
			Assert.assertEquals(alerText, expected);
			acceptAlert();
			}
			else if(alerText.equals(expected2))
			{
				logger.info("Password changed successfully and alert is "+alerText);
				Assert.assertEquals(alerText, expected2);
				acceptAlert();
			}
			else if(alerText.equals(expected3))
			{
				logger.info("old Password is incorrect and Alert is "+alerText);
				Assert.assertEquals(alerText, expected2);
				acceptAlert();
			}
			else
			{
				logger.info("Un Expected condition is occured!!!!");
			}
		}
	}

	@Test(priority=1)
	public void changePasswordBlankData()
	{
		System.out.println("changePassword method is called");
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("sachin@123");
		logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		logger.info("Browser launched and LoginButton Clicked");
		cp=new ChangePasswordPage(driver);
		cm=new CustomerMenuPage(driver);
		cm.clickonChangepassword();
		logger.info("Click on change password");
		/*cp.enteroldPassword("sachin@123");
		cp.enterNewPassword("sachin@12");
		cp.enterConfirmPassword("sachin@12");*/
		logger.info("Old password and new password Kept blank");
		cp.clickOnSubmitButton();
		logger.info("Clicked on Submit Button");
		
		if(isAlertPresent())
		{
			String alerText=getAlertText();
			String expected="Please fill all fields";
			String expected2="Password is Changed";
			String expected3="Old Password is incorrect";
			if(alerText.equals(expected))
			{
			logger.info("Password Field is blanked alert is "+alerText);
			
			Assert.assertEquals(alerText, expected);
			acceptAlert();
			}
			else if(alerText.equals(expected2))
			{
				logger.info("Password changed successfully and alert is "+alerText);
				Assert.assertEquals(alerText, expected2);
				acceptAlert();
			}
			else if(alerText.equals(expected3))
			{
				logger.info("old Password is incorrect and Alert is "+alerText);
				Assert.assertEquals(alerText, expected2);
				acceptAlert();
			}
			else
			{
				logger.info("Un Expected condition is occured!!!!");
			}
		}
		
	}
	@DataProvider(name="PasswordChangeData")
	public Object getLoginData()
	{
		System.out.println("Get Logindata called");
		
		XLS_DataReadUtil.getXSlWorkbook();
		int rownum=XLS_DataReadUtil.getRowcount();
		System.out.println("Get PasswordChangeData called row count is*****"+rownum);
		int columnNum=XLS_DataReadUtil.getcolumnCount(rownum);
		System.out.println("Get PasswordChangeData called columnNum count is*****"+columnNum);
		Object[][] passobj=new Object[rownum][columnNum];
		for(int i=1; i<=rownum; i++)
		{		
			for (int j = 0; j < columnNum; j++) {
				
				passobj[i-1][j]=XLS_DataReadUtil.getCellData(i, j);
			}
		}
		return passobj;
		
	}
}
