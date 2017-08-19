package FuctionLibraryDemo;

import org.testng.annotations.Test;

import functionLibrary.ELocator;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class ELocatorDemo {

	private WebDriver driver;
	private String BaseURL;
	private ELocator loc;
	
	
	
  @BeforeClass
  public void SetUp() {
	  System.setProperty("webdriver.gecko.driver", "C://Users//Shakour//Selenium Lib//chromedriver.exe");
	  driver = new FirefoxDriver();
	  BaseURL = "SavvyEra.com";
	  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  driver.manage().window().fullscreen();
  }
  
  @Test
  public void ElementDemo () {
	  driver.get(BaseURL);
	  
	  
	  
  }

  @AfterClass
  public void TearDown() {
	  
	  
  }

}
