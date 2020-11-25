package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static WebDriver driver;
	public static WebDriver navigateToHomePage(String url, WebDriver driver) {

//		if(browser.equals("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		if(browser.equals("Firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver() {
		 if(driver == null) {
			 if(new ConfigFileReader().getBrowser().equals("Chrome"))
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 return driver;
		 }
	
	public static void closeBrowser() {
		getDriver().quit();
	}

}
