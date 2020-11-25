package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import java.io.File;
import java.util.Random;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.PersonalDetailsPage;
import pageObjects.ProductDetailPage;
import utility.BrowserFactory;

public class Steps {

	WebDriver driver;
	HomePage homePage;
	ConfigFileReader config;
	ProductDetailPage productDetailPage;
	CartPage cartPage;
	PersonalDetailsPage personalDetailsPage;
	String cartTotal;

	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		config = new ConfigFileReader();
		driver = BrowserFactory.getDriver();
		driver = BrowserFactory.navigateToHomePage(config.getApplicationUrl(), driver);
	}

	@When("^he Choose to View Laptops$")
	public void he_Choose_to_View_Laptops() throws Throwable {
		homePage = new PageObjectManager(driver).getHomePage();
		homePage.clickLaptops();
	}

	@When("^he adds \"([^\"]*)\" to cart$")
	public void he_adds_to_cart(String product) throws Throwable {
		homePage.clickProduct(product);
		productDetailPage = new PageObjectManager(driver).getProductDetailPage();
		productDetailPage.clickaddToCart();
		productDetailPage.acceptCartAlert();
	}

	@When("^he clicks on Home Page$")
	public void he_clicks_on_Home_Page() throws Throwable {
		productDetailPage.clickHomeButton();
	}

	@When("^he navigates to Cart Page$")
	public void he_navigates_to_Cart_Page() throws Throwable {
		productDetailPage.clickCartButton();
	}

	@When("^he deletes \"([^\"]*)\" from cart$")
	public void he_deletes_from_cart(String product) throws Throwable {
		cartPage = new PageObjectManager(driver).getCartPage();
		cartPage.deleteProduct(product);
		Thread.sleep(7000);
	}

	@When("^he clicks on place order$")
	public void he_clicks_on_place_order() throws Throwable {
		cartTotal = cartPage.clickPlaceOrder();
		Reporter.addStepLog("Cart Total Amount - "+cartTotal);
		Thread.sleep(2000);
	}

	@When("^he enters his personal information$")
	public void he_enters_his_personal_information() throws Throwable {
		personalDetailsPage = new PageObjectManager(driver).getPersonalDetailsPage();
		personalDetailsPage.enterName("Name");
		personalDetailsPage.enterCountry("usercountry");
		personalDetailsPage.enterCity("usercity");
		personalDetailsPage.enterCard("425221718");
		personalDetailsPage.enterMonth("10");
		personalDetailsPage.enterYear("2020");
	}

	@When("^he clicks on purchase$")
	public void he_clicks_on_purchase() throws Throwable {
		personalDetailsPage.clickPurchase();
		Thread.sleep(2000);
		takeScreenShot();
	}

	@Then("^he is shown a confirmation message$")
	public void he_is_shown_a_confirmation_message() throws Throwable {
		Assert.assertFalse("Thank You Message Not Shown",personalDetailsPage.getThankYouMessage().isEmpty());
	}

	@Then("^is able to validate the amount$")
	public void is_able_to_validate_the_amount() throws Throwable {
		String amountDetails = personalDetailsPage.getPurchaseDetails().split("\\r?\\n")[1];
		String amount = amountDetails.split(" ")[1];
		Reporter.addStepLog("Order total on confirmation Page - "+amount);
		Assert.assertTrue("Cart Total Not Matching on Order Confirmation Page",cartTotal.equals(amount));
	}
	
	@Then("^he clicks on OK$")
	public void he_clicks_on_OK() throws Throwable {
	   personalDetailsPage.clickOk();
	}

	public void takeScreenShot() throws Throwable {
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		int num = 100 + new Random().nextInt(900);
		File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/screenshotName"+num+".png");
		Files.copy(sourcePath, destinationPath);   
		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}

}
