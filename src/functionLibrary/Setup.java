package funclib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Setup {
	WebDriver driver;

	public void OpenApp( String browserName , String appName, WebDriver driver){
	 this.driver = driver;
	
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
}
	

