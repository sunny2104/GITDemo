package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Signin=By.cssSelector("a[href*='sign_in']");
	public LoginPage getLogin()
	{
		driver.findElement(Signin).click();
		LoginPage LG = new LoginPage(driver);
		return LG;
	}
	
	By Title=By.cssSelector(".text-center>h2");
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	By Navigation=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	public WebElement getNavigationBar()
	{
		return driver.findElement(Navigation);
	}
}
