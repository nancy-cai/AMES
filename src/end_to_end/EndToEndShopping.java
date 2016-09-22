package end_to_end;

import static org.junit.Assert.*;
import login_register.LoginFunction;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EndToEndShopping {
	
	public WebDriver driver;
	LoginFunction shopping;
	public WebDriverWait wait;
	public WebElement courses;
	public WebElement nurse_English; 
	public WebElement quantity;
	public WebElement add_cart;
	public WebElement to_cart;
	public String expected_name;
	public String actual_name;
	public WebElement proceed;
	public String fisrt_name;
	public WebElement continue_;
	public WebElement term;
	public WebElement place_order;
	public WebElement paypal_username;
	public WebElement paypal_password;
	public WebElement paypal_login;
	public WebElement paypal_continue;
	
	
	public void chooseACourse(){
		Actions hover = new Actions(driver);		
		courses = driver.findElement(By.linkText("COURSES"));
		hover.moveToElement(courses).perform();
		wait = new WebDriverWait(driver, 60); 
		nurse_English =driver.findElement(By.linkText("English for Health Professionals: Nurses"));
		wait.until(ExpectedConditions.elementToBeClickable(nurse_English));
		nurse_English.click();

	}
	
	
	public void changeQuantity(){
		quantity=driver.findElement(By.xpath("//*[@id='simpleproduct']/tbody/tr[1]/td[2]/div/input"));
		quantity.clear();
		quantity.sendKeys("2");
		
	}
	
	public void clickAddToCart(){
		add_cart = driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt"));
		add_cart.click();
	}
	
	public void goToCart(){
		to_cart = driver.findElement(By.cssSelector(".et-cart-info"));
		to_cart.click();
	}
	
	public void assertProductName(){
		actual_name = driver.findElement(By.cssSelector(".product-name>a")).getText();
		expected_name = "English For Health Professionals: Nurses";
		assertEquals(actual_name,expected_name);
	}
	
	public void clickProceedToCheckout(){
		
		proceed = driver.findElement(By.linkText("Proceed to Checkout"));
		proceed.click();
	}
	
	public void assertFirstName(){
		fisrt_name=driver.findElement(By.id("billing_first_name")).getAttribute("value");
		assertEquals(fisrt_name,"Adactin");		
	}
	
	public void clickContinue1(){
		continue_ =driver.findElement(By.linkText("Continue"));
		wait.until(ExpectedConditions.elementToBeClickable(continue_));
		continue_.click();
	}
	
	public void clickContinue2(){
		continue_ =driver.findElement(By.linkText("Continue"));
		wait.until(ExpectedConditions.elementToBeClickable(continue_));
		continue_.click();
	}

	public void acceptTerm(){
		term=driver.findElement(By.id("terms"));
		term.click();
	}
	
	public void placeOrder(){
		place_order = driver.findElement(By.id("place_order"));
		place_order.click();
	}
	
	public void enterPaypalUsername(String paypalusername){		
		paypal_username = driver.findElement(By.id("login_email"));
		paypal_username.clear();
		paypal_username.sendKeys(paypalusername);
	}
	
	public void enterPaypalPassword(String paypalpassword){		
		paypal_username = driver.findElement(By.id("login_password"));
		paypal_username.clear();
		paypal_username.sendKeys(paypalpassword);
	}
	
	public void clickPaypalLogin(){
		paypal_login = driver.findElement(By.id("submitLogin"));
		paypal_login.click();
	}
	
	public void clickPayNow(){
		paypal_continue =driver.findElement(By.id("continue"));
		paypal_continue.click();
	}
	

	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}


	@Test
	public void test() throws InterruptedException {
		shopping = new LoginFunction();
		shopping.loginFunction(driver,"test@gmail.com", "adactin");
		chooseACourse();
		changeQuantity();
		clickAddToCart();
		goToCart();
		assertProductName();
		clickProceedToCheckout();
		assertFirstName();
		Thread.sleep(5000);
		clickContinue1();
		Thread.sleep(5000);
		clickContinue2();
		acceptTerm();
		placeOrder();
		enterPaypalUsername("adactin.sandbox-buyer@gmail.com");
		enterPaypalPassword("Paypal@sandbox");
		clickPaypalLogin();
		clickPayNow();
	}
	
	
	@After
	public void closeDriver(){
		driver.close();
	}

}
