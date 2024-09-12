package com.datadriven.test;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import com.datadriven.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test extends BaseClass{
	
	public void wishlist() throws IOException
	{
WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.jiomart.com");
		
		HomePage hmpg = new HomePage();
		//hmpg.searchProduct();
				
	}

}
