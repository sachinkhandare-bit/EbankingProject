package testCases_Pagewise;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru99Bankapp.PageObjects.AddNewCustomerPage;
import com.Guru99Bankapp.PageObjects.BalanceEnquiryPage;
import com.Guru99Bankapp.PageObjects.CustomerMenuPage;
import com.Guru99Bankapp.PageObjects.Guru_LoginPage;

public class BalaceEnquiryTest extends BaseClass {
	
	Guru_LoginPage lp;
	BalanceEnquiryPage bp;
	
	String successmsg;
	String accno="89477";
	
	@Test
	public void balanceEnquiry() throws InterruptedException
	{
		
		logger.info("*********Balance Enquiry Test ***********");
		System.out.println("balanceEnquiry method is called");
		driver.get(url);
		logger.info("Browser Launched and URL enetered");
		System.out.println("get URL method is called");
		logger.info("Browser launched and Url Entered");
		
		
		lp=new Guru_LoginPage(driver);
		bp=new BalanceEnquiryPage(driver);
		CustomerMenuPage cm=new CustomerMenuPage(driver);
		lp.sendUserName("74140");
		logger.info("Browser launched and Username Entered");
		lp.setPassword("myPass");
		
		lp.clickOnLoginButton();
		logger.info("Login Button Clicked");
		//CustomerMenuPage cm=new CustomerMenuPage(driver);
		
		cm.clickonBalanceEnquiry();
		logger.info("clickonBalanceEnquiry link Clicked");
		bp.selectAccount(accno);
		bp.clickOnSubmitButton();
		logger.info("clickOnSubmitButton button Clicked");
		successmsg=bp.successMessage();
		String expected="Balance Details for Account "+accno;
		logger.info("Result is "+successmsg);
		Assert.assertEquals(successmsg, expected);
		

}
}