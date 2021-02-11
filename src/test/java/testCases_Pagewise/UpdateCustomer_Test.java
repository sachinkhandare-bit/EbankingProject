package testCases_Pagewise;

import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.AddNewCustomerPage;
import com.Guru99Bankapp.PageObjects.EditCustomerPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

import junit.framework.Assert;

public class UpdateCustomer_Test extends BaseClass {
	Guru_LoginPage lp;
	EditCustomerPage edit;
	
	@Test
	public void updateCustomer_info() throws InterruptedException
	{
		logger.info("*******Edit Customer Test Case************");
		System.out.println("Addnewcustomer method is called");
		driver.get(url);
		System.out.println("get URL method is called");
		//logger.info("Browser launched and Url Entered");
		lp=new Guru_LoginPage(driver);
		edit=new EditCustomerPage(driver);
		lp.sendUserName(uname);
		//logger.info("Browser launched and Username Entered");
		lp.setPassword(pass);
		//logger.info("Browser launched and password Entered");
		lp.clickOnLoginButton();
		//logger.info("Browser launched and LoginButton Clicked");
		edit.clickOnEditCustomer();
		Thread.sleep(7000);
		edit.setCustomerID("53809");
		System.out.println("Customer ID is Enterd");
		edit.editCustomer();
		Thread.sleep(7000);
		edit.updateAddress("Crystal Park Aprtment");
		edit.updatecustomerCity("Naagpur");
		edit.updatecustomerState("Panjab");
		edit.updatecustomerPin("411016");
		edit.updateMobileNo("9876568976");
		edit.updatecustomerEmaiID("sandypandit@gmail.com");
		edit.updateCustomerInfo();
		System.out.println("Update button clicked...");
		Thread.sleep(9000);
		
		String message=edit.verifyCustomerUpdation();
		if(message.equals("Customer details updated Successfully!!!"))
		{
			Assert.assertTrue(true);
			System.out.println("Customer info updated Successfuly");
		}
		else
		{
			System.out.println("Customer info not updated Successfuly");
			Assert.assertTrue(false);
			
		}


	}

}
