package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;
public class HomePage extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	    {
		driver = initializeDriver();
		log.info("Driver is initialised");
		/*driver.get(Prop.getProperty("url"));
		driver.get("http://qaclickacademy.com");*/
		}
	
	@Test(dataProvider = "getData")
	
	public void TestHomePage(String Username, String Password, String Text) throws IOException
	{
		/*driver = initializeDriver();
		driver.get(Prop.getProperty("URL"));*/
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to Home Page.");
		//Two Ways Call the Method from different class
		//1. Is Inheritance
		//2. Creating the Object to that class and invokes methods of it
		LandingPage LP = new LandingPage(driver);
		LoginPage LG=LP.getLogin();
		log.info("Login Button Get Clicked.");
		LG.getEmail().sendKeys(Username);
		LG.getPassword().sendKeys(Password);
		log.info(Text);
		//System.out.println(Text);
		LG.getLoginButton().click();
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stand for how many different data types test should run
		//Column stand for how many vlaues per each test 
		Object[][] data= new Object[2][3];
		//1st Row
		data[0][0] = "sunny.sinha@gmail.com";
		data[0][1] = "Destiny";
		data[0][2] = "1st User";
		//2nd Row
		data[1][0] = "sinha.sunny@gmail.com";
		data[1][1] = "Kismat";
		data[1][2] = "2nd User";
		return data;
	}

}
