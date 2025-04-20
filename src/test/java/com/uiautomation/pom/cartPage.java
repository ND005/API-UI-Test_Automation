package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {
	WebDriver driver;

	public WebElement removeCart(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='item_pricebar']//button"));
	}

	public WebElement continousShopping(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='cart_footer']/button[@name='continue-shopping']"));
	}

	public WebElement checkout(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@class='cart_footer']/button[@name='checkout']"));
	}
}
