package com.eBanking.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePageClass {
	
	public static WebDriver driver;
	public static Properties prop;
	static String url;
	public static Logger logger;
	public BasePageClass()
	{
		prop = new Properties();
		try
		{
		FileInputStream ip = new FileInputStream("C:\\Users\\jithi\\eclipse-workspace\\eBankin-V1\\src\\main\\java\\com\\eBank\\config\\config.properties");
		prop.load(ip);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
	public static void initialize()
	{

		String browser = prop.getProperty("driver");
		url = prop.getProperty("url");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jithi\\eclipse-workspace\\eBankin-V1\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\jithi\\eclipse-workspace\\eBankin-V1\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\jithi\\eclipse-workspace\\eBankin-V1\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get(url);

	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\jithi\\eclipse-workspace\\eBankin-V1\\ScreenShots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String generateNumber()
	{
		String randomNumber =RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	public static void main(String[] args) {
		
		

			
	}

}
