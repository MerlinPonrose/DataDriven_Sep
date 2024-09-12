package com.datadriven.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.datadriven.test.BaseClass;

public class HomePage extends BaseClass{
	
	public By searchbox = By.xpath("//input[@enterkeyhint='search']");
	public By minicarticon = By.id("btn_minicart");
	
	
	public void searchProduct(String product) throws IOException
	{
		com.sendValue(searchbox, product," Search Box");
		
		com.sendKeys_keyboard(searchbox, Keys.ENTER);
	}
	
	
	public void clickMiniCartIcon()
	{
		com.Click_Javascript(minicarticon);
		
	}

}
