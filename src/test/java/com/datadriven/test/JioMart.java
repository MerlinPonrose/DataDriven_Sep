package com.datadriven.test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.datadriven.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JioMart extends BaseClass{
	
	@Test(dataProvider="getdataa")
	public void addProductToCart(String product) throws InterruptedException, IOException
	{
		
		test = extent.createTest("addProductToCart");
		
		test.log(Status.INFO,"Test Case execution started" );
	
		hmpg.searchProduct(product);

		
		Thread.sleep(10000);
		
		prodpg.clickFirstProduct();
		
	
		prodpg.clickAddToCart();
	
		Thread.sleep(10000);
		
		hmpg.clickMiniCartIcon();
	
		cartpg.validateProduct();
		
		test.log(Status.INFO,"Test Case execution completed");
	}
	
	
	@DataProvider
	public String[][] getdataa() throws IOException	
	{
		return excell.excellread();
	}

}
