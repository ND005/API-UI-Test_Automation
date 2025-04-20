package com.uiautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class homePage {
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

	public boolean getSort(WebDriver driverType, String expectedData) {
		Select Options = new Select(driverType.findElement(By.xpath("//select[@class='product_sort_container']")));
		switch (expectedData) {
		case "Name (A to Z)":
			Options.selectByContainsVisibleText(expectedData);
			return true;
		case "Name (Z to A)":
			Options.selectByContainsVisibleText(expectedData);
			return true;
		case "Price (low to high)":
			Options.selectByContainsVisibleText(expectedData);
			return true;
		case "Price (high to low)":
			Options.selectByContainsVisibleText(expectedData);
			return true;
		default:
			return false;
		}
	}

	public WebElement sortFilter(WebDriver driverType) {
		return driverType.findElement(By.xpath("//select[@class='product_sort_container']"));
	}

	public WebElement getMenuBar(WebDriver driverType) {
		return driverType.findElement(By.id("react-burger-menu-btn"));
	}

	public WebElement addCartOfSpecificItem(int listOfItem, WebDriver driverType) {
		return driverType.findElement(
				By.xpath("//div[@class='inventory_list']/div[" + listOfItem + "]//div[@class='pricebar']/button"));
	}

	public WebElement cartDetails(WebDriver driverType) {
		return driverType.findElement(By.xpath("//div[@id='shopping_cart_container']//a[@class='shopping_cart_link']"));
	}
}
