package basicWeb;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// Please change the extension of the file to .java before using

   public class SwitchWindow {
	private WebDriver driver;
	private String baseUrl; 

	@Before
	public void setUp() throws Exception 
	{
		System.setProperty ("webdriver.gecko.driver" , "/Volumes/DATA BANK/Java Selenium Files/Selenium java 3.0/MAC Drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {

//		
//		WebElement searchBox = driver.findElement(By.id("search-courses"));
//		searchBox.sendKeys("python");
		// Get the handle
		String parentHandle = driver.getWindowHandle();
		String child1 = null;
		System.out.println("Parent Handle: " + parentHandle);
		
		// Find Open Window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		// Get all handles
		Set<String> handles = driver.getWindowHandles();

		// Switching between handles
				for (String handle: handles) {
					System.out.println(handle);
					if (!handle.equals(parentHandle)) {
						driver.switchTo().window(handle);
						child1 = driver.getWindowHandle();
						Thread.sleep(2000);
						WebElement searchBox = driver.findElement(By.id("search-courses"));
						searchBox.sendKeys("python");
						Thread.sleep(2000);
						//driver.close();
						break;
					}
				}
				// Switch back to the parent window
				driver.switchTo().window(parentHandle);
				Thread.sleep(3000);
				driver.switchTo().window(child1);
				//driver.findElement(By.id("name")).sendKeys("Test Successful");
				
		
			}

			@After
			public void tearDown() throws Exception {
				Thread.sleep(2000);
				//driver.quit();
			}

}
