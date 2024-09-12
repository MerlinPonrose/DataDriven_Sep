package com.datadriven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datadriven.test.BaseClass;

public class CartPage extends BaseClass{
	
	public By product = By.xpath("//div[text()='Beetroot 500 g']");
	
	
	public void validateProduct()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		
		WebElement prod = driver.findElement(product);
		String text = prod.getText();
		
		if(text.contains("Beetroot"))
		{
			System.out.println("product available");
		}
		else
		{
			System.out.println("product not available");
		}
	}

}
