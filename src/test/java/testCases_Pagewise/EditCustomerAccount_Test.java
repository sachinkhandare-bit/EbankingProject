package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.EditCustomerAccount;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;


public class EditCustomerAccount_Test extends BaseClass {
	Guru_LoginPage lp;
	EditCustomerAccount edit;
	
	@Test
	public void updateCustomerAccount() throws InterruptedException
	{
		logger.info("********* Edit Customer Account Test Case**********");
		System.out.println("updateCustomerAccount method is called");
		driver.get(url);
		System.out.println("get URL method is called");
		//logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		edit=new EditCustomerAccount(driver);
		lp.sendUserName(uname);
		//logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		logger.info("Browser launched and LoginButton Clicked");
		edit.clickOnEditAccountLink();
		Thread.sleep(7000);
		edit.setCustomerAccountNo("74140");
		logger.info("Customer Account No is Enterd");
		System.out.println("Customer Account No is Enterd");
		edit.clickOnSubmitToEditAccount();
		logger.info("Submit Button is clicked to edit Account info");
		Thread.sleep(7000);
		edit.selectCustomerAccountType("Current");
		edit.clickOnSubmitToUpdateAccount();
		Thread.sleep(5000);
		System.out.println("Update button clicked...");
		logger.info("Submit Button is clicked to Upadte Account info");
		//Thread.sleep(9000);
		
		if(isAlertPresent())
		{
			String alertMessage=getAlertText();
			System.out.println("Alert Text is  "+alertMessage);
			logger.info("Alert is Present "+alertMessage);
			getscreenShot(driver, "updateCustomerAccount");
			acceptAlert();
			//logger.fatal("Do you really want to delete this Account?");
			
			
		}
		else
		{
		String message=edit.accountUpdatedMessage();
		logger.info("Message Captured is "+message);
		System.out.println("Mesage captured is "+message);
		if(message.equals("Account details updated Successfully!!!"))
		{
			Assert.assertTrue(true);
			logger.info("Account info updated Successfuly");
			System.out.println("Customer info updated Successfuly");
		}
		

		}
		}

}
