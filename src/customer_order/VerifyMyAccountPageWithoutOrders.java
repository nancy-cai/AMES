package customer_order;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

import login_register.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyMyAccountPageWithoutOrders {
	
	public WebDriver driver;
	public LoginFunction login;
	

	public void orderHistory(){
		
		Boolean orderHistoryTablePresent = (driver.findElements(By.xpath(".//*[@id='post-45']/div/div/div[2]/div[2]/div/div/table") )).size() > 0;
		if(!orderHistoryTablePresent){
			System.out.println("No order history present, pass the test");
		}
	}
		

	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void VerifyOrders() throws Exception {
		login= new LoginFunction();
		login.loginFunction(driver,"as@adactin.com","123456");
		orderHistory();
	}
	
	@After
	public void closeDriver(){
		driver.close();
	}

}
