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

public class Homepage_Login_Happycase {

	public WebDriver driver;
	public WebElement homepage_login;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	public String expected;
	public String actual;
	
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
	
	public void assertTitle(){
		expected = "My Account - AMES";
		actual = driver.getTitle();
		assertEquals(actual, expected);
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
		enterUsername("cainaisi@qq.com");
		enterPassword("sj191013");
		clickLogin();
		assertTitle();

	}
	
	@After
	public void closeDriver(){
		driver.close();
	}
	
}
