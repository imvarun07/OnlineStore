package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

	WebDriver driver;
	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Purchase')]") 
	private WebElement purchase;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Thank')]") 
	private WebElement ThankYouMessage;

	@FindBy(how = How.XPATH, using = "//p[@class='lead text-muted ']") 
	private WebElement purchaseDetails;

	@FindBy(how = How.ID, using = "name") 
	private WebElement name;

	@FindBy(how = How.ID, using = "country") 
	private WebElement country;

	@FindBy(how = How.ID, using = "city") 
	private WebElement city;

	@FindBy(how = How.ID, using = "card") 
	private WebElement card;

	@FindBy(how = How.ID, using = "month") 
	private WebElement month;

	@FindBy(how = How.ID, using = "year") 
	private WebElement year;

	@FindBy(how = How.CSS, using = ".sa-confirm-button-container>button") 
	private WebElement okButton;

	public void enterName(String username) {
		name.sendKeys(username);
	}

	public void enterCountry(String usercountry) {
		country.sendKeys(usercountry);
	}

	public void enterCity(String usercity) {
		city.sendKeys(usercity);
	}

	public void enterCard(String usercard) {
		card.sendKeys(usercard);
	}

	public void enterMonth(String usermonth) {
		month.sendKeys(usermonth);
	}

	public void enterYear(String useryear) {
		year.sendKeys(useryear);
	}

	public void clickPurchase() {
		purchase.click();
	}
	public String getPurchaseDetails() {
		return purchaseDetails.getText();
	}

	public String getThankYouMessage() {
		return ThankYouMessage.getText();
	}

	public void clickOk() {
		okButton.click();
	}

}
