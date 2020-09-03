package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
public WebDriver driver;
public LoginPage(WebDriver driver) 
		{
		  	this.driver = driver;
		}
	
By Email=By.cssSelector("input[id='user_email']");
public WebElement getEmail()
	    	{
	    		return driver.findElement(Email);
	    	}
	
By Password=By.cssSelector("input[id='user_password']");
public WebElement getPassword()
			{
				return driver.findElement(Password);
			}

By LoginButton=By.cssSelector("input[value='Log In']");
public WebElement getLoginButton()
			{
				return driver.findElement(LoginButton);
			}

}
