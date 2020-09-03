package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties Prop;

	public WebDriver initializeDriver() throws IOException
	{
        Prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\StartToEndProject\\src\\main\\java\\Resources\\Data.properties");
		Prop.load(fis);
		String BrowserName = Prop.getProperty("Browser");
		System.out.println(BrowserName);
		
		if (BrowserName.contains("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(BrowserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			 driver = new ChromeDriver(options);
		}
		else if(BrowserName.equals("Firefox"))
		{
			//driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE"));
		{
			//Execute in IE
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
		public String getScreenShotPath(String TestCaseName, WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
			FileUtils.copyFile(source, new File(destinationFile));
			return destinationFile;
		}

}
