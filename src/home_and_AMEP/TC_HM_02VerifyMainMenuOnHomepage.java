package home_and_AMEP;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_HM_02VerifyMainMenuOnHomepage {
	public WebDriver driver;
	List<WebElement> navigation_links;
	List<String> links;
	List<String> expected;
	
	public List<String> getNavigationLinks(){
		navigation_links = driver.findElements(By.xpath("//*[@id='mega-menu-primary-menu']/li/a"));
		links = new ArrayList<>();
		
		for(WebElement link: navigation_links){
			links.add(link.getText());
	}
		return links;
	}
	
	public void assertNavigationLinks(){
		expected = Arrays.asList("ABOUT AMES", "AMEP", "COURSES","CURRICULUM","PUBLICATIONS","PROFESSIONAL DEVELOPMENT");
		assertEquals(links,expected);
		System.out.println(links);
	}
	

	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://dev.ames.edu.au/shop/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	@Test
	public void verifyHomepageMenu()throws Exception {
		getNavigationLinks();
		assertNavigationLinks();

	}
	
	@After
	public void closeDriver(){
		driver.close();
	}
	

}
