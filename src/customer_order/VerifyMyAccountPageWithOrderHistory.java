package customer_order;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import login_register.LoginFunction;

public class VerifyMyAccountPageWithOrderHistory {
	public WebDriver driver;
	public LoginFunction login;
	Boolean orderHistoryPresent;
	
	public Boolean orderHistory(){

			try {
				driver.findElement((By.xpath(".//*[@id='post-45']/div/div/div[2]/div[2]/div/div/table")));
				orderHistoryPresent = true;
			} catch (NoSuchElementException e) {
				orderHistoryPresent = false;
				System.out.println("No order history present");
			}
			return orderHistoryPresent;			
		}
	
	public void printTheResult(){
		
		if(orderHistoryPresent){
		System.out.println("The presence of order history is "+ orderHistoryPresent);
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
	public void test() {
		login= new LoginFunction();
		login.loginFunction(driver,"test@gmail.com","adactin");
		orderHistory();
		printTheResult();
	}
	
	@After
	public void closeDriver(){
		driver.close();
	}

}
