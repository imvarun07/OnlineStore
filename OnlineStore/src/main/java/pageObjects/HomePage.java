package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.XPATH, using = "//a[contains(text(),'Laptops')]") 
	 private WebElement laptopLink;
	 
	public WebElement getProduct(String productName) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]"));
	}
	
	public void clickLaptops() {
		laptopLink.click();
	}
	public void clickProduct(String product) {
		getProduct(product).click();
	}
	 
}
