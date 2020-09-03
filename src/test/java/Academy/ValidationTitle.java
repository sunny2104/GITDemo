package Academy;

import java.io.IOException;
import java.sql.Driver;

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
public class ValidationTitle extends Base{
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
	
	public void validateAppTitle() throws IOException
	{
		/*driver = initializeDriver();
		  driver.get(Prop.getProperty("URL"));
		  driver.get("http://qaclickacademy.com");*/
		
		
		LandingPage LP = new LandingPage(driver);
		// Compare the text from the browser with actual text.
		Assert.assertEquals(LP.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully validated Text Message");
		System.out.println(LP.getTitle().getText());
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}
	
}
