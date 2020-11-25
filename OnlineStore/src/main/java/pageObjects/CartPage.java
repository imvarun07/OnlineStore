package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add to cart')]") 
	 private WebElement addToCartButton;
	 
	 @FindBy(how = How.XPATH, using = "//button[contains(text(),'Place Order')]") 
	 private WebElement placeOrderButton;
	 
	 @FindBy(how = How.CSS, using = ".panel-heading>h3") 
	 private WebElement cartTotal;
	 
	 public String clickPlaceOrder() {
		 placeOrderButton.click();
		 return cartTotal.getText();
	 }
	 public void deleteProduct(String product) {
		 List<WebElement> rowsInTable = driver.findElements(By.xpath("//table/tbody/tr"));
		 for(WebElement row:rowsInTable) {
			 if(row.findElement(By.xpath("./td[2]")).getText().contains(product)) {
				row.findElement(By.xpath("./td[4]/a")) .click();
			 }
		 }
	 }
	 
	
}
