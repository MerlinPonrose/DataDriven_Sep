package com.datadriven.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.datadriven.test.BaseClass;

public class Common extends BaseClass{
	
	
	public void clickElement(By locator, String element) throws IOException
	{
		try
		{
			WebElement ele = driver.findElement(locator);
			ele.click();
			test.log(Status.PASS, element+" is clicked successfully");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, element+" is not clicked ");
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("C:\\neworkspace\\Selenium8PM\\Screenshot\\Image.png");
			
			FileUtils.copyFile(src, destination);
			
			test.addScreenCaptureFromPath("C:\\neworkspace\\Selenium8PM\\Screenshot\\Image.png");
			
		}
	}
	
	public void sendValue(By locator,String values, String element)
	{
		try
		{
			WebElement ele = driver.findElement(locator);
			ele.click();
			ele.clear();
			ele.sendKeys(values);
			test.log(Status.PASS, values+" entered successfuly in "+element);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, values+" not entered in "+element);
		}
	}
	
	public void sendKeys_keyboard(By locator,Keys key)
	{
		WebElement ele = driver.findElement(locator);
		ele.sendKeys(key);
	}
	
	public void Click_Javascript(By locator)
	{
		WebElement minicart = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", minicart);
	}

}
