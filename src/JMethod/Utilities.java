package JMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Utilities {
	

		WebDriver driver;
		
		public Utilities(WebDriver driver) {
			this.driver = driver;
		}
		//Function to Open an Application
		public void OpenApp(String browserName , String appName){
			browserName = browserName.toLowerCase();
			switch(browserName){
			case "firefox":
				System.setProperty("webdriver.gecko.driver" , "C:\\Selenium_Browsers_Driver\\geckodriver.exe" );
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(appName);
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver" , "C:\\Selenium_Browsers_Driver\\IEdriver.exe" );
				/*
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
				caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				
				driver = new InternetExplorerDriver(caps);  
				*/
				//we put caps variable that carries all desired capabilities into the argument
				// as some times IE Have issues OR use the line below
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(appName);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver" , "C:\\Selenium_Browsers_Driver\\chromedriver.exe" );
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(appName);
				break;
			case "safari":
				driver = new SafariDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(appName);
				break;
			case "opera":
				System.setProperty("webdriver.opera.driver" , "C:\\Selenium_Browsers_Driver\\operadriver.exe" );
				driver = new OperaDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(appName);
				break;
			}
		}
		// Function to find Any Element on the Page
		public WebElement findMyElement(String type, String locator){
			type = type.toLowerCase();
			WebElement element = null;
			switch(type){
			case "id":
				element = this.driver.findElement(By.id(locator));
			break;
			case "name":
				element = this.driver.findElement(By.name(locator));
			break;
			case "css":
				element = this.driver.findElement(By.cssSelector(locator));
			break;
			case "xpath":
				element = this.driver.findElement(By.xpath(locator));
			break;
			case "classname":
				element = this.driver.findElement(By.className(locator));
			break;
			case "linktext":
				element = this.driver.findElement(By.linkText(locator));
			break;
			case "partiallinktext":
				element = this.driver.findElement(By.partialLinkText(locator));
			break;
			}
			
			if (element == null) {
				System.out.println("Element not found with " + type +": " + locator);
				
			} else {
				System.out.println("Element found with " + type +": " + locator);
			}
			return element;
			
		}
		
		public WebElement getElement(String locator, String type) {
			type = type.toLowerCase();
			WebElement element = null;
			if (type.equals("id")) {
				element = this.driver.findElement(By.id(locator));
			}
			else if (type.equals("name")) {
				element = this.driver.findElement(By.name(locator));
			}
			else if (type.equals("xpath")) {
				element = this.driver.findElement(By.xpath(locator));
			}
			else if (type.equals("css")) {
				element = this.driver.findElement(By.cssSelector(locator));
			}
			else if (type.equals("classname")) {
				element = this.driver.findElement(By.className(locator));
			}
			else if (type.equals("tagname")) {
				element = this.driver.findElement(By.tagName(locator));
			}
			else if (type.equals("linktext")) {
				element = this.driver.findElement(By.linkText(locator));
			}
			else if (type.equals("partiallinktext")) {
				element = this.driver.findElement(By.partialLinkText(locator));
			}
			else {
				System.out.println("Locator type not supported");
				}
			
			if (element == null) {
				System.out.println("Element not found with " + type +": " + locator);
				
			} else {
				System.out.println("Element found with " + type +": " + locator);
			}
			return element;
		}
		
		public List<WebElement> getElementList(String locator, String type) {
			type = type.toLowerCase();
			List<WebElement> elementList = new ArrayList<WebElement>();
			if (type.equals("id")) {
				elementList = this.driver.findElements(By.id(locator));
			}
			else if (type.equals("name")) {
				elementList = this.driver.findElements(By.name(locator));
			}
			else if (type.equals("xpath")) {
				elementList = this.driver.findElements(By.xpath(locator));
			}
			else if (type.equals("css")) {
				elementList = this.driver.findElements(By.cssSelector(locator));
			}
			else if (type.equals("classname")) {
				elementList = this.driver.findElements(By.className(locator));
			}
			else if (type.equals("tagname")) {
				elementList = this.driver.findElements(By.tagName(locator));
			}
			else if (type.equals("linktext")) {
				elementList = this.driver.findElements(By.linkText(locator));
			}
			else if (type.equals("partiallinktext")) {
				elementList = this.driver.findElements(By.partialLinkText(locator));
			}
			//If the above locator is not found, below statement is printed
			else {
				System.out.println("Locator type not supported");
				
			}
			if (elementList.isEmpty()) {
				System.out.println("Element not found with " + type +": " + locator);
				
			} else {
				System.out.println("Element found with " + type +": " + locator);
			}
			return elementList;
		}

		public boolean isElementPresent(String locator, String type) {
			List<WebElement> elementList = getElementList(locator, type);
			
			int size = elementList.size();
			
			if (size > 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	


