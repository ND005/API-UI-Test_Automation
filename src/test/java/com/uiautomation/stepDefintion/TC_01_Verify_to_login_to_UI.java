package com.uiautomation.stepDefintion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.uiautomation.pom.HomePage;
import com.uiautomation.pom.cartPage;
import com.uiautomation.pom.productDetailsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class TC_01_Verify_to_login_to_UI {
	WebDriver driver = null;
	Properties prop = new Properties();
	HomePage HP = new HomePage();
	productDetailsPage PD = new productDetailsPage();
	cartPage CP = new cartPage();

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
			// System.out.println(EdgeDriverManager.getInstance().getDriverVersions());
			// WebDriverManager.edgedriver().setup();
			EdgeDriverManager.getInstance().browserVersion("win64").setup();
			driver = new EdgeDriver();

			driver.manage().window().maximize();
			driver.get(prop.getProperty("swagLab"));
			PageFactory.initElements(driver, this);

			// Login functionality using page factory

			username.sendKeys(UserID);
			Thread.sleep(1000);
			password.sendKeys(Password);
			Thread.sleep(1000);
			lgnBtn.click();
			Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@When("Verify the user profile and home page")
	public void verify_the_user_profile_and_home_page() {
		try {
			// Thread.sleep(10000);
			// System.out.println(" <INFO> " + HP.getCountofItems(driver));
			if (HP.getCountofItems(driver) > 0) {
				if (HP.getItemLabel(1, driver).isDisplayed() && HP.getItemAddCart(1, driver).isDisplayed()) {

				} else {
					Assert.assertTrue("  <INFO> Label is 'Not Displayed' ", HP.getItemLabel(1, driver).isDisplayed());
					Assert.assertTrue("  <INFO> Add cart button is 'Not Displayed' ",
							HP.getItemAddCart(1, driver).isDisplayed());
				}

			} else {
				Assert.assertTrue("  <INFO> Items are 0", false);
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify the first product details and add to cart")
	public void verify_the_firstProduct_details_and_addToCart() {
		try {
			String getTextInfo = HP.getItemLabel(1, driver).getText();
			HP.getItemLabel(1, driver).click();
			Thread.sleep(3000);
			Assert.assertTrue(PD.getProductNameinDetails(driver).getText().contains(getTextInfo));
			PD.AddCart(driver).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify the cart, remove the item from cart and continue the shopping")
	public void verify_the_cart_and_continue_the_shopping() {
		try {
			if (PD.cartButton(driver).isDisplayed()) {
				PD.cartButton(driver).click();
				Thread.sleep(3000);
				if (CP.removeCart(driver).isDisplayed()) {
					CP.removeCart(driver).click();
					Assert.assertTrue("  <INFO> Clicked on remove from cart button", true);
				} else {
					Assert.assertTrue("  <INFO> Remove from cart button not visible", false);
				}
				if (CP.continousShopping(driver).isDisplayed()) {
					CP.continousShopping(driver).click();
					Assert.assertTrue("  <INFO> Clicked on continue the shopping", true);
				} else {
					Assert.assertTrue("  <INFO> Continue shopping button not visible", false);
				}
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
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
