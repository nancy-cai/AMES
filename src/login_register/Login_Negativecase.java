package login_register;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Negativecase {

	public WebDriver driver;
	public WebElement homepage_login;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	public WebElement error_msg;
	public String actual_msg;
	
	public void clickHomepageLoginButton(){
		homepage_login = driver.findElement(By.linkText("Login"));
		homepage_login.click();
	}

	public void enterUsername(String username){
		this.username=driver.findElement(By.id("username"));
		this.username.clear();
		this.username.sendKeys(username);
	}
	
	public void enterPassword(String password){
		this.password = driver.findElement(By.id("password"));
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickLogin(){
		login = driver.findElement(By.name("login"));
		login.click();
	}
	
	public void assertErrorMassage(String expected_msg){
		error_msg = driver.findElement(By.cssSelector(".woocommerce-error"));
		actual_msg = error_msg.getText();
		assertEquals(actual_msg, expected_msg);
	}
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws Exception {
		
		clickHomepageLoginButton();
		enterUsername("");
		enterPassword("adactin");
		clickLogin();
		assertErrorMassage("Error: Username is required.");

	}
	
	@After
	public void closeDriver(){
		driver.close();
	}
	
}
