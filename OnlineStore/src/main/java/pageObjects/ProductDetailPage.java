package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
	WebDriver driver;
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add to cart')]") 
	 private WebElement addToCartButton;
	 
	 @FindBy(how = How.XPATH, using = "//a[contains(text(),'Home')]") 
	 private WebElement homeButton;
	 
	 @FindBy(how = How.XPATH, using = "//a[contains(text(),'Cart')]") 
	 private WebElement CartButton;
	 
	 public void clickaddToCart() {
		 addToCartButton.click();
	 }
	 
	 public void clickHomeButton() {
		 homeButton.click();
	 }
	 
	 public void clickCartButton() {
		 CartButton.click();
	 }
	 
	 public void acceptCartAlert() {
		 new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		 System.out.print(driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();
	 }
}
