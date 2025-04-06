package com.uiautomation.stepDefintion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_Verify_to_login_to_UI {

	WebDriver driver = null;

	@Given("^Logging to Swag Labs with (.*) and (.*)$")
	public void logging_to_swag_labs_with_userID_and_password(String UserID, String Password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@When("Verify the user profile and home page")
	public void verify_the_user_profile_and_home_page() {

	}

	@Then("Verify the basic user UI elements")
	public void verify_the_basic_user_ui_elements() {

	}
}
