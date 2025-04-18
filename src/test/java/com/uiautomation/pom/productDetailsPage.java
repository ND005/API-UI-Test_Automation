package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productDetailsPage {
	WebDriver driver;

	public WebElement getProductNameinDetails(WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[@id='inventory_item_container']//div[@class='inventory_details_name large_size']"));
	}

	public WebElement AddCart(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='inventory_item_container']//button"));
	}
}
