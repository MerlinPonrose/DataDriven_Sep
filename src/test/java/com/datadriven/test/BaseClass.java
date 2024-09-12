package com.datadriven.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.datadriven.pages.CartPage;
import com.datadriven.pages.HomePage;
import com.datadriven.pages.ProductPage;
import com.datadriven.utility.Common;
import com.datadriven.utility.ExcelRead;
import com.datadriven.utility.ExcelRead_Array;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static HomePage hmpg = new HomePage();
	
	public static ProductPage prodpg = new ProductPage();
	
	public static CartPage cartpg = new CartPage();
	
	public static Common com = new Common();
	
	public static	HashMap<String, String> map = new HashMap<String, String>();
	
	public static	DataFormatter data = new DataFormatter();
	
	public static ExcelRead excel = new ExcelRead();
	
	public static ExcelRead_Array excell = new ExcelRead_Array();
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	public String getDataa(String key) throws IOException
	{
		return excel.getData(key);
	}

	@BeforeMethod
	public void browserlaunch() throws IOException
	{
		File f = new File("C:\\neworkspace\\DataDriven_Aug\\src\\test\\java\\com\\datadriven\\config\\environment.properties");
		
		FileInputStream fis = new FileInputStream(f);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url = prop.getProperty("URL");
		String browser = prop.getProperty("Browser");
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	
	@BeforeTest
	public void generateReport()
	{
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter("target/extentreport.html");
		extent.attachReporter(spark);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
}
