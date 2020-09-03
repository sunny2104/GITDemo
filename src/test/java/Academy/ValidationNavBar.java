package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;
public class ValidationNavBar extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	    {
		driver = initializeDriver();
		log.info("Driver is initialised");
		//driver.get(Prop.getProperty("url"));
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to Home Page.");		
		}
	
	@Test
	public void TestNavigationBar() throws IOException
	{
	  /*driver = initializeDriver();
		driver.get(Prop.getProperty("url"));
		driver.get("http://qaclickacademy.com");*/
		
		
		LandingPage LP = new LandingPage(driver);
		Assert.assertTrue(LP.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
		
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}
	
	
}
