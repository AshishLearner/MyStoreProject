package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

public class BaseClass {
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getdriver() {
		return driver.get();
	}
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	//initialize log4j.xml
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	try {
			
			FileInputStream ip= new FileInputStream(
					System.getProperty("user.dir")+ "\\Configuration\\Config.Properties");
			prop = new Properties();
			System.out.println("super constructor invoked");
			prop.load(ip);
			System.out.println("driver: "+driver);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}

	
	public static void launchApp(String browserName) {
		//WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}else if (browserName.contains("FireFox")) {
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
			
		}else if(browserName.contains("IE")) {
		//driver = new InternetExplorerDriver();
			driver.set(new EdgeDriver());
		}
		getdriver().manage().window().maximize();
		Action.implicitWait(getdriver(),10);
		Action.pageLoadTimeOut(getdriver(),30);
		getdriver().get(prop.getProperty("url"));
		
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	

}
