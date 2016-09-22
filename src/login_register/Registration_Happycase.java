package login_register;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration_Happycase {
	public WebDriver driver;
	public WebElement homepage_login;
	public WebElement email_input;
	public WebElement password_input;
	public WebElement confirm_password_input;
	public WebElement firstname_input;
	public WebElement lastname_input;
	public WebElement phone_input;
	public WebDriverWait wait;
	public WebElement register_button;
	public String expected_title;
	public String actual_title;
	
	
	
	public void clickHomepageLoginButton(){
		homepage_login = driver.findElement(By.linkText("Login"));
		homepage_login.click();
	}
	
	public void enterEmailAddress(String email){
		email_input= driver.findElement(By.id("reg_email"));
		email_input.sendKeys(email);
	}
	
	public void enterRegiterPassword(String password){
		password_input= driver.findElement(By.id("reg_password"));
		password_input.sendKeys(password);
	}
	
	public void confirmPassword(String password){
		confirm_password_input= driver.findElement(By.id("reg_password2"));
		confirm_password_input.sendKeys(password);
	}
	

	public void enterFirstName(String firstname){
		firstname_input = driver.findElement(By.id("reg_first_name"));
		firstname_input.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname){
		lastname_input = driver.findElement(By.id("reg_last_name"));
		lastname_input.sendKeys(lastname);
	}
	
	public void enterPhoneNumber(String phone){
		phone_input = driver.findElement(By.id("reg_phone"));
		phone_input.sendKeys(phone);
	}
	
	public void clickRegisterButton(){
		wait = new WebDriverWait(driver, 90); 
		register_button = driver.findElement(By.xpath(".//*[@id='customer_login']/div[2]/form/p[8]/input[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(register_button));
     	register_button.click();
	}
	
	public void assertTitle(){
		expected_title = "My Account - AMES";
		actual_title = driver.getTitle();
		assertEquals(actual_title, expected_title);
	}
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	@Test
	public void test() throws Exception{
		
		clickHomepageLoginButton();
		//Note enter different unregistered email address each time executing
		enterEmailAddress("a2@adactin.com");
		enterRegiterPassword("123456");
		confirmPassword("123456");
		enterFirstName("Adactin");
		enterLastName("test");
		enterPhoneNumber("0411111111");
		//Click "I'mnot a robot" manually
		Thread.sleep(60000);
		clickRegisterButton();
		assertTitle();
		
	}

}
