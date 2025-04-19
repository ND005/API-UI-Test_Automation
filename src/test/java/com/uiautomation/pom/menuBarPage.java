package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class menuBarPage {
	WebDriver driverType;

	public WebElement getAllItems(WebDriver driverType) {
		return driverType.findElement(By.id("inventory_sidebar_link"));
	}

	public WebElement getResetAppState(WebDriver driverType) {
		return driverType.findElement(By.id("reset_sidebar_link"));
	}

	public WebElement getAbout(WebDriver driverType) {
		return driverType.findElement(By.id("about_sidebar_link"));
	}

	public WebElement getLogout(WebDriver driverType) {
		return driverType.findElement(By.id("logout_sidebar_link"));
	}
}
