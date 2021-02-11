package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99Bank.utilities.XLS_DataReadUtil;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class LoginPage_DDTTest extends BaseClass {
	
	Guru_LoginPage lp;
	//ReadConfig config=new 
	@Test(dataProvider="LoginData")
	public void loginPage_DDT_Test( String userName, String password) throws InterruptedException
	{
		driver.get(url);
		logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		lp.sendUserName(userName);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickOnLoginButton();
		logger.info("LoginButton Clicked");
		Thread.sleep(5000);
		
		String expected="Guru99 Bank Manager HomePage";
		if(driver.getTitle().equals(expected))
		{
			String actual=driver.getTitle();
			logger.info("User name and Password correct");
			Assert.assertEquals(actual, expected);
			logger.info("Login Test case Passed");
					
		}
		else if(isAlertPresent())
		{
			System.out.println("*********ERROR***************");
			getscreenShot(driver, "loginPage_DDT_Test");
			String message=getAlertText();
			acceptAlert();
			logger.warn("Your login ID or Password is not valid !!! Test case Failed");
			logger.info("Your login ID or Password is not valid !!! Test case Failed");
			System.out.println("************"+message);
			logger.info("Invalid User Credentials "+message);
			
			Assert.assertTrue(true);
			
			
			//lp.clickOnLogoutLink();
			//acceptAlert();
				
		}
		
		
		
	}

	@DataProvider(name="LoginData")
	public Object getLoginData()
	{
		System.out.println("Get Logindata called");
		XLS_DataReadUtil.getXSlWorkbook();
		int rownum=XLS_DataReadUtil.getRowcount();
		System.out.println("Get Logindata called row count is*****"+rownum);
		int columnNum=XLS_DataReadUtil.getcolumnCount(rownum);
		System.out.println("Get Logindata called columnNum count is*****"+columnNum);
		Object[][] loginDataObj=new Object[rownum][columnNum];
		for(int i=1; i<=rownum; i++)
		{		
			for (int j = 0; j < columnNum; j++) {
				
				loginDataObj[i-1][j]=XLS_DataReadUtil.getCellData(i, j);
			}
		}
		return loginDataObj;
		
	}
	

}
