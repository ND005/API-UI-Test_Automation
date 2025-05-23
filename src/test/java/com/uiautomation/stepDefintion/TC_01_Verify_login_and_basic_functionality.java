package com.uiautomation.stepDefintion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.uiautomation.pom.homePage;
import com.uiautomation.pom.informationPage;
import com.uiautomation.pom.menuBarPage;
import com.uiautomation.pom.overViewPage;
import com.uiautomation.pom.cartPage;
import com.uiautomation.pom.driverType;
import com.uiautomation.pom.productDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_01_Verify_login_and_basic_functionality {
	WebDriver driver;

	homePage HP = new homePage();
	productDetailsPage PD = new productDetailsPage();
	cartPage CP = new cartPage();
	menuBarPage MBP = new menuBarPage();
	driverType Dvt = new driverType();
	informationPage INFP = new informationPage();
	overViewPage OVP = new overViewPage();
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
			driver = Dvt.getDriver();
			driver.manage().window().maximize();
			Dvt.setDriver(driver);
			InputStream stream = new FileInputStream(configFile);
			prop.load(stream);
			driver.get(prop.getProperty("swagLab"));
			// driver = Dvt.getDriverType(configFile);
			PageFactory.initElements(driver, this);
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
					Assert.assertTrue("  <INFO> Label and cart buttons are visisble ", true);
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

	@When("User logged into standard profile")
	public void user_logged_into_standard_profile() {
		try {

			if (HP.getCountofItems(driver) > 0) {
				if (HP.getItemLabel(1, driver).isDisplayed() && HP.getItemAddCart(1, driver).isDisplayed()) {
					Assert.assertTrue("  <INFO> Label and cart buttons are visisble ", true);
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

	@Then("Verify the sort functionality based on price")
	public void verify_the_sort_functionality_based_on_price() {
		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\Test_Cases_and_Scenarios.xlsx");
			XSSFWorkbook EXCEL = new XSSFWorkbook(fis);
			XSSFSheet SHEET = EXCEL.getSheet("Test Data");

			if (HP.sortFilter(driver).isDisplayed()) {
				Thread.sleep(1000);
				for (int dataOfSort = 1; dataOfSort <= 3; dataOfSort++) {
					Row ROW = SHEET.getRow(dataOfSort);
					Cell CELL = ROW.getCell(0);
					if (HP.getSort(driver, CELL.getStringCellValue().toString())) {
						Thread.sleep(3000);
					} else {
						Assert.assertTrue("  <INFO> " + CELL.getStringCellValue().toString() + " - Unable select ",
								false);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify all the string value in menu bar with expected texts")
	public void verify_all_the_string_value_in_menu_bar_with_expected_texts() {
		try {
			if (HP.getMenuBar(driver).isDisplayed()) {
				HP.getMenuBar(driver).click();
				Thread.sleep(1000);
				Assert.assertTrue(" <INFO> ",
						MBP.getAllItems(driver).isDisplayed() && MBP.getResetAppState(driver).isDisplayed()
								&& MBP.getAbout(driver).isDisplayed() && MBP.getLogout(driver).isDisplayed());
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify all navigation of menu bar")
	public void verify_all_navigation_of_menu_bar() {
		try {
			Thread.sleep(1000);
			MBP.getAbout(driver).click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			if (HP.getMenuBar(driver).isDisplayed()) {
				HP.getMenuBar(driver).click();
			}
			MBP.getLogout(driver);
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify multiple products select process")
	public void verify_multiple_products_select_process() {
		try {
			if (HP.getCountofItems(driver) > 0) {
				Assert.assertTrue("  <INFO> Label and cart buttons are visisble ",
						HP.getItemLabel(1, driver).isDisplayed() && HP.getItemAddCart(1, driver).isDisplayed());
				HP.addCartOfSpecificItem(1, driver).click();
				Thread.sleep(3000);
				HP.addCartOfSpecificItem(2, driver).click();
				Thread.sleep(1000);
			} else {
				Assert.assertTrue("  <INFO> Items are 0", false);
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify order procedure till checkout")
	public void verify_order_procedure_till_checkout() {
		try {
			if (HP.cartDetails(driver).isDisplayed()) {
				HP.cartDetails(driver).click();
				Thread.sleep(1000);
				CP.checkout(driver).click();
			} else {
				Assert.assertTrue("  <INFO> Cart button not visible ", false);
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify checkout information section with and without data")
	public void verify_checkout_information_section_with_and_without_data() {
		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\Test_Cases_and_Scenarios.xlsx");
			XSSFWorkbook EXCEL = new XSSFWorkbook(fis);
			XSSFSheet SHEET = EXCEL.getSheet("Test Data");
			Assert.assertTrue(INFP.firstName(driver, SHEET.getRow(1).getCell(1).getStringCellValue()));
			Assert.assertTrue(INFP.lastName(driver, SHEET.getRow(2).getCell(1).getStringCellValue()));
			Assert.assertTrue(INFP.pincode(driver, SHEET.getRow(3).getCell(1).getNumericCellValue()));
			Thread.sleep(1000);
			INFP.contionuToCheckout(driver).click();
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@Then("Verify checkout overview section and its all expected fields")
	public void verify_checkout_overview_section_and_its_all_expected_fields() {
		try {
			if (OVP.cancelButton(driver).isDisplayed() && OVP.finishButton(driver).isDisplayed()) {
				Assert.assertTrue("  <INFO> ",
						OVP.paymentInformation(driver).getText().contains("Payment Information:"));
				Assert.assertTrue("  <INFO> ",
						OVP.shippmentInformation(driver).getText().contains("Shipping Information:"));
				Assert.assertTrue("  <INFO> ", OVP.priceTotalInformation(driver).getText().contains("Price Total"));
				Thread.sleep(1000);
				OVP.finishButton(driver).click();
			} else {
				Assert.assertTrue("  <INFO> Cancel button - ", OVP.cancelButton(driver).isDisplayed());
				Assert.assertTrue("  <INFO> Finish button - ", OVP.finishButton(driver).isDisplayed());
			}
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}

	@And("Verify order confirmation section and get back to Home page")
	public void verify_order_confirmation_section_and_get_back_to_home_page() {
		try {
			Assert.assertTrue("  <INFO> Verify the text - ",
					OVP.OrderConformationUI(driver).getText().contains("Thank you for your order!"));
			Assert.assertTrue("  <INFO> Verify the text - ", OVP.GetBacktoHome(driver).isDisplayed());
			Thread.sleep(1000);
			OVP.GetBacktoHome(driver).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("  <INFO> " + e.toString());
		}
	}
}
