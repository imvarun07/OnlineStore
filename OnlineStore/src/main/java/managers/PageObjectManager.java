package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.PersonalDetailsPage;
import pageObjects.ProductDetailPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private ProductDetailPage productDetailPage;
	private CartPage cartPage;
	private PersonalDetailsPage personalDetailsPage;

	public PageObjectManager(WebDriver driver) {	 
		this.driver = driver;
	}
	
	
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}
	
	public ProductDetailPage getProductDetailPage(){

		return (productDetailPage == null) ? productDetailPage = new ProductDetailPage(driver) : productDetailPage;

	}
	
	public CartPage getCartPage(){

		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;

	}
	
	public PersonalDetailsPage getPersonalDetailsPage(){

		return (personalDetailsPage == null) ? personalDetailsPage = new PersonalDetailsPage(driver) : personalDetailsPage;

	}
}
