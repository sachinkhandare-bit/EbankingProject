package testCases_Pagewise;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Guru99Bank.utilities.ReadConfig;



public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig rconfig=new ReadConfig();
	public String url=rconfig.getApplicationUrl();
	public String uname=rconfig.getUserName();
	public String pass=rconfig.getPassword();
	public static Logger logger;
	WebDriverWait w;
	
	String path=rconfig.getXLSPath();
	@Parameters("browserName")
	@BeforeClass(groups= {"Regression"}) 
	public void setUp(String browserName)
	{
				
		logger=Logger.getLogger("eBankingGuru99Bank");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rconfig.getChromePath());
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", rconfig.getIEPath());
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		
		w = new WebDriverWait(driver, 5);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	public static void getscreenShot(WebDriver driver2, String testName)
	{
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver2;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + testName+ ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return destination;
	}
	
	public static boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		//String alertText=driver.switchTo().alert().getText();
		//return alertText;
		//System.out.println("Alert Text is "+alertText);
		//driver.switchTo().alert().accept();
		return true;
		}catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public static void acceptAlert()
	{
		//driver.switchTo().alert();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	public static void dismissAlert()
	{
		//driver.switchTo().alert();
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
	}
	public static String getAlertText()
	{
		String alertText="false";
		try
		{
		driver.switchTo().alert();
		alertText=driver.switchTo().alert().getText();
		//return alertText;
		System.out.println("Alert Text is "+alertText);
		//driver.switchTo().alert().accept();
		return alertText;
		}catch(NoAlertPresentException e)
		{
			return alertText;
		}
	}

}
