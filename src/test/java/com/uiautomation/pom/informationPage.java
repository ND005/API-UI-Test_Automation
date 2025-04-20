package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class informationPage {
	WebDriver driver;

	public boolean firstName(WebDriver driver, String firstName) {
		WebElement NameSpace = driver.findElement(By.id("first-name"));
		if (NameSpace.isDisplayed()) {
			NameSpace.sendKeys(firstName);
			return true;
		}
		return false;
	}

	public boolean lastName(WebDriver driver, String lastName) {
		WebElement NameSpace = driver.findElement(By.id("last-name"));
		if (NameSpace.isDisplayed()) {
			NameSpace.sendKeys(lastName);
			return true;
		}
		return false;
	}

	public boolean pincode(WebDriver driver, double zipcode) {
		WebElement NameSpace = driver.findElement(By.id("postal-code"));
		if (NameSpace.isDisplayed()) {
			NameSpace.sendKeys(Double.toString(zipcode));
			return true;
		}
		return false;
	}

	public WebElement contionuToCheckout(WebDriver driver) {
		return driver.findElement(By.id("continue"));
	}
}
