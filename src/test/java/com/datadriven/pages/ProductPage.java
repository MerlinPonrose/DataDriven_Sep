package com.datadriven.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.datadriven.test.BaseClass;

public class ProductPage extends BaseClass{
	
	public By frstproductt = By.xpath("(//div[@class='plp-card-cont'])[1]");
	public By AddToCartButton = By.xpath("(//button[text()='Add to Cart'])[1]");
	
	
	
	public void clickFirstProduct() throws IOException
	{
		com.clickElement(frstproductt,"First Product");
	}
	
	
	public void clickAddToCart() throws IOException
	{
		com.clickElement(AddToCartButton,"Add to Cart Button");
	}

}
