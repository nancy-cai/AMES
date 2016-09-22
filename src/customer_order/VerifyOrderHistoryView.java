package customer_order;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import login_register.LoginFunction;

public class VerifyOrderHistoryView {
	public WebDriver driver;
	public LoginFunction login;
	
	
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}


	@Test
	public void verifyOrderLinks() throws Exception{
		login= new LoginFunction();
		login.loginFunction(driver,"test@gmail.com","adactin");
		
	}

}
