package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.DeleteCustomerPage;
import com.Guru99Bankapp.PageObjects.EditCustomerPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class DeleteCustomer_Test extends BaseClass{
	Guru_LoginPage lp;
	DeleteCustomerPage del;
	
	@Test
	public void deleteCustomerTest() throws InterruptedException
	{
		logger.info("******* Delete Customer Test********");
	System.out.println("Addnewcustomer method is called");
	driver.get(url);
	System.out.println("get URL method is called");
	logger.info("Browser launched and Url Entered");
	lp=new Guru_LoginPage(driver);
	del=new DeleteCustomerPage(driver);
	lp.sendUserName(uname);
	logger.info("Browser launched and Username Entered");
	lp.setPassword(pass);
	logger.info("Browser launched and password Entered");
	lp.clickOnLoginButton();
	logger.info("Browser launched and LoginButton Clicked");
	del.clickOnDeleteustomerLink();
	logger.info("Customer Delete link is clicked ");
	Thread.sleep(7000);
	del.setCustomerID("68011");
	System.out.println("Customer ID is Enterd");
	logger.info("Customer ID is Enterd");
	del.clickOnSubmiToDelete();
	logger.info("Delete button is clicked ");
	Thread.sleep(7000);
	if(isAlertPresent())
	{
		String alertText=getAlertText();
		System.out.println("Confirm Delete Customer!!!!!!!");
		Assert.assertTrue(true);
		logger.info("Confirm Delete Customer Alert!!!!!!! Apert Test is "+alertText);
		acceptAlert();
	}
	else
	{
		String alertText=getAlertText();
		System.out.println("Customer Record doesnot Exist!!!!!!! Alert text is "+alertText);
		Assert.assertTrue(false);
		logger.info("Customer Record doesnot Exist!!!!!!! Alert text is "+alertText);
		acceptAlert();
	}
	
	if(isAlertPresent())
	{
		String alertText=getAlertText();
		System.out.println("Customer Deleted Successfuly!!!!!!!!Alert text is "+alertText);
		Assert.assertTrue(true);
		logger.info("Customer Deleted Successfuly!!!!!!!!Alert text is "+alertText);
		acceptAlert();
		
	}
	else
	{
		getscreenShot(driver, "deleteCustomerTest");
		System.out.println("Customer Record doesnot Delete!!!!!!! ");
		Assert.assertTrue(false);
		logger.info("Customer Record doesnot Delete!!!!!!! ");
		
	}
	}
}
