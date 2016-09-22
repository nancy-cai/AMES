package login_register;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	
	public WebDriver driver;
	public WebElement my_account;
	public WebDriverWait wait;
	public WebElement logout_link;
    public LoginFunction logout; 
	
	public void clickLogoutButton(){
		Actions hover = new Actions(driver);		
		my_account = driver.findElement(By.cssSelector("#mega-menu-item-61 > a:nth-child(1)"));
		hover.moveToElement(my_account).perform();
		wait = new WebDriverWait(driver, 60); 
		logout_link=driver.findElement(By.linkText("Logout"));
		wait.until(ExpectedConditions.elementToBeClickable(logout_link));
		logout_link.click();

		
	}
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void logoutFunction() throws Exception{
		logout = new LoginFunction();
		logout.loginFunction(driver,"test@gmail.com", "adactin");
		clickLogoutButton();

	}
	
	@After
	public void closeDriver(){
		driver.close();
	}

}
