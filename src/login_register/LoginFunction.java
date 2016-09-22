package login_register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunction {
	
	
	public WebElement homepage_login;
	public WebElement username;
	public WebElement password;
	public WebElement login;

	
	
	
	public void loginFunction(WebDriver driver, String usernames, String passwords){
	    
	 
	
		homepage_login = driver.findElement(By.linkText("Login"));
		homepage_login.click();

		username=driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys(usernames);

		password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(passwords);

		login = driver.findElement(By.name("login"));
		login.click();
	}
	



	

}
