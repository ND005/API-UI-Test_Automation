package com.uiautomation.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class driverType {
	WebDriver driver;
	Properties prop = new Properties();

	public WebDriver getDriverType(File configFile) throws IOException {
		EdgeDriverManager.getInstance().browserVersion("win64").setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		InputStream stream = new FileInputStream(configFile);
		prop.load(stream);
		driver.get(prop.getProperty("swagLab"));
		return driver;
	}

	public WebDriver getDriver() {
		EdgeDriverManager.getInstance().browserVersion("win64").setup();
		return new EdgeDriver();
	}
	
	public WebDriver setDriver(WebDriver driver){
		return this.driver =driver;
	}
}
