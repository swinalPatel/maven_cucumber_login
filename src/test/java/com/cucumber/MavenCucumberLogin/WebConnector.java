package com.cucumber.MavenCucumberLogin;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class WebConnector {

	Properties env = null;
	WebDriver driver = null;
	
	//create constructor 
	public WebConnector() {
		
		if(env==null) {
			try {
				env = new Properties();
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\cucumber\\MavenCucumberLogin\\env.properties" );
				env.load(fs);
				//System.out.println(env.getProperty("loginURL"));
				//System.out.println(env.getProperty("loginusername"));
			}catch(Exception e) {
				System.out.println("Error on initializing properties files");
			}
		}
	}
	
	//opening browser
	public void openBrowser(String browserType) {
		
		if (browserType.equals("Mozila") ) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\Driver\\geckodriver.exe");
			driver =  new FirefoxDriver();
		
		}else if (browserType.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Driver\\chromedriver.exe");
				driver =  new ChromeDriver();
		}else if (browserType.equals("IE")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\Driver\\IEDriverServer.exe");
				driver =  new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	//Navigating to the URL
	public void navigate(String URL) {
		driver.get(env.getProperty(URL));
	}
	
	//Find username and password field element
	public void field(String objectName, String text) {
		driver.findElement(By.xpath(env.getProperty(objectName))).sendKeys(text);
	}
	
	//click on loginButton
	public void click(String objectName) {
		driver.findElement(By.xpath(env.getProperty(objectName))).click();
	}
		
	//find element is present
	public boolean isElementPresent(String objectName) {
		int count = driver.findElements(By.xpath(env.getProperty(objectName))).size();
		if(count==0)
			return false;
		else
			return true;
		}

	public void close_Browser() {
		
		driver.close();
		
	}

}
