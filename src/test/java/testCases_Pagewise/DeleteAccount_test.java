package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.DeleteAccountPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class DeleteAccount_test extends BaseClass{

	Guru_LoginPage lp;
	DeleteAccountPage dc;
	
	@Test
	public void deleteCustomerAccount() throws InterruptedException
	{
		logger.info("********** Delete Customer Test************");
		System.out.println("deleteCustomerAccount method is called");
		driver.get(url);
		logger.info("Browser Launched and URL enetered");
		System.out.println("get URL method is called");
		//logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		dc=new DeleteAccountPage(driver);
		lp.sendUserName(uname);
		logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		//logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		
		logger.info("Browser launched and LoginButton Clicked");
		dc.clickOnDeleteAccountLinlk();
		logger.info("Delete Account  page is launched");
		dc.enterAccountNumberToDelete("89477");
		dc.submitAccountToDelete(); 
		logger.info("Delete account button clicked");
		
		if(isAlertPresent())
		{
			String alertMessage=getAlertText();
			System.out.println("Alert Status is  "+alertMessage);
			logger.info("Alert Present "+alertMessage);
			if(alertMessage.equals("Do you really want to delete this Account?"))
			{
			//logger.fatal("Do you really want to delete this Account?");
			String expected="Do you really want to delete this Account?";
			Assert.assertEquals(alertMessage, expected);
			acceptAlert();
			}
			else if(alertMessage.equals("Account does not exist"))
			{
				String expected="Account does not exist";
				Assert.assertEquals(alertMessage, expected);
				acceptAlert();
			}
					
		}
		else
		{
			getscreenShot(driver, "deleteCustomerAccount");
			System.out.println("Something Went Wrong");
			logger.info("Something Went Wrong");
		}
		
		//Thread.sleep(2000);
		
		if(isAlertPresent())
		{
			String expected="Account Deleted Sucessfully";
			String alertmessage=getAlertText();
			if(alertmessage.equals(expected))
			{
				Assert.assertEquals(alertmessage, expected);
				logger.fatal("Account Deleted Successfuly!!!!");
				//logger.info("Account Deleted Successfuly!!!! Alert text is "+alertmessage);
			}
			else
			{
			System.out.println("Final Alert Message is  "+alertmessage);
			logger.info("Final Alert Message is  "+alertmessage);
					
		}

	}
	}
}
