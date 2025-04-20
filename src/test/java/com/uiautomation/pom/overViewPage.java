package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class overViewPage {
	WebDriver driverType;

	public WebElement finishButton(WebDriver driverType) {
		return driverType.findElement(By.xpath("//button[@id='finish']"));
	}

	public WebElement cancelButton(WebDriver driverType) {
		return driverType.findElement(By.xpath("//button[@id='cancel']"));
	}

	public WebElement paymentInformation(WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@class='summary_info']/div[1]"));
	}

	public WebElement shippmentInformation(WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@class='summary_info']/div[3]"));
	}

	public WebElement priceTotalInformation(WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@class='summary_info']/div[5]"));
	}

	public WebElement OrderConformationUI(WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@id='checkout_complete_container']/h2"));
	}

	public WebElement GetBacktoHome(WebDriver driverType) {
		return driverType.findElement(By.id("back-to-products"));
	}
}
