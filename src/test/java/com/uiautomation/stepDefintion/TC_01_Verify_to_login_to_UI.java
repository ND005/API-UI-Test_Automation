package com.uiautomation.stepDefintion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_Verify_to_login_to_UI {
	WebDriver driver = null;
	Properties prop = new Properties();
	File configFile = new File("src\\test\\resources\\baseURL.properties");
	
	@FindBy(id = "user-name")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login-button")
	WebElement lgnBtn;

	@Given("^Logging to Swag Labs with (.*) and (.*)$")
	public void logging_to_swag_labs_with_userID_and_password(String UserID, String Password) throws IOException {
		try {
			InputStream stream = new FileInputStream(configFile);
			prop.load(stream);

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("swagLab"));
			PageFactory.initElements(driver, this);
			
			// Need to pass the driver to fetch the data
			
			username.sendKeys(UserID);
			Thread.sleep(1000);
			password.sendKeys(Password);
			Thread.sleep(1000);
			lgnBtn.click();
			Thread.sleep(1000);
			
		}
		catch (Exception e) {
			System.out.println(" <INFO> " + e.toString());
		}
	}

	@When("Verify the user profile and home page")
	public void verify_the_user_profile_and_home_page() {

	}

	@Then("Verify the basic user UI elements")
	public void verify_the_basic_user_ui_elements() {

	}

	@And("Terminate the browser")
	public void tesrminate_the_browser() {
		try {
			Thread.sleep(1000);
			driver.quit();
		} catch (Exception e) {
			System.out.println(" <INFO> " + e.toString());
		}
	}

}
