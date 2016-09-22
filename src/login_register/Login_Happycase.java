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

public class Login_Happycase {

	public WebDriver driver;
	public String baseURL;
	public WebElement menu_login;
	public WebElement username;
	public WebElement password;
	public WebElement login1;
	public String expected;
	public String actual;
	
	public void clickMenuLoginButton(){
		menu_login = driver.findElement(By.linkText("Login"));
		menu_login.click();
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
		login1 = driver.findElement(By.name("login"));
		login1.click();
	}
	
	public void assertTitle(){
		expected = "My Account - AMES";
		actual = driver.getTitle();
		assertEquals(actual, expected);
	}
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		//Pass different url to test whether user is able to login from all the pages
		//baseURL = ¡°http://dev.ames.edu.au/shop/course/¡±
		baseURL = "http://dev.ames.edu.au/shop/";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws Exception {
		
		clickMenuLoginButton();
		enterUsername("test@gmail.com");
		enterPassword("adactin");
		clickLogin();
		assertTitle();

	}
	
	@After
	public void closeDriver(){
		driver.close();
	}
	
}
