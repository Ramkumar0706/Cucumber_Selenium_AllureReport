package com.allBirds.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties data;
	public static Logger logger = Logger.getLogger(TestBase.class);
	
	
	// Constructor to load properties file
	public TestBase() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("Log4j has been initialized.");
		data = new Properties();
		try {
			
			
			logger.info("Loading the configuration properties file.");
			FileInputStream file = new FileInputStream("D:\\Bridgelabz_Automation\\PageObjectModel\\src\\main\\java\\com\\allBirds\\qa\\config\\config.properties");
			data.load(file);
			logger.info("Configuration file loaded successfully.");
		} catch (Exception e) {
			logger.error("Failed to load the configuration file: " + e.getMessage(), e);
		}
	}
	
	public static void init() {
		String browser = data.getProperty("browser");
		logger.info("Browser selected from properties file: " + browser);
		
		if (browser.equalsIgnoreCase("chrome")) {
			logger.info("Initializing Chrome browser.");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			logger.info("Initializing Firefox browser.");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			logger.info("Initializing Internet Explorer browser.");
			driver = new InternetExplorerDriver();
		} else {
			logger.error("No valid browser specified. Initialization failed.");
			throw new RuntimeException("Browser not specified correctly in properties file.");
		}

		logger.info("Maximizing the browser window.");
		driver.manage().window().maximize();

		logger.info("Deleting all cookies.");
		driver.manage().deleteAllCookies();

		logger.info("Setting page load timeout to 20 seconds.");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		logger.info("Setting implicit wait timeout to 10 seconds.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Navigating to the URL specified in the properties file
		String url = data.getProperty("url");
		logger.info("Navigating to the URL: " + url);
		driver.get("https://www.allbirds.com/");
	}
}
