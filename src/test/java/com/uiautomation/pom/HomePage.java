package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driverType;

	public int getCountofItems(WebDriver driverType) {
		return driverType.findElements(By.xpath("//div[@class='inventory_list']/div")).size();
	}

	public WebElement getItem(int itemInPosition, WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@class='inventory_list']/div/div[" + itemInPosition + "]"));
	}

	public WebElement getItemLabel(int itemInPosition, WebDriver driverType) {
		return driverType.findElement(
				By.xpath("//div[@class='inventory_list']/div[" + itemInPosition + "]//a[@id='item_4_title_link']"));
	}

	public WebElement getItemAddCart(int itemInPosition, WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@class='inventory_list']/div[" + itemInPosition
				+ "]//button[@id='add-to-cart-sauce-labs-backpack']"));
	}
}
