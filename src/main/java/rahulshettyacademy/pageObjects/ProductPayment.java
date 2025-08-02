package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponent;

public class ProductPayment extends AbstractComponent {

	WebDriver driver;
	
	public ProductPayment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[contains(@class, 'ta-item')][2]")
	WebElement selectedCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderBtn;
	
	@FindBy(css="h1.hero-primary")
	WebElement orderPlaceTextElement;
	
	By selectCountry = By.cssSelector("[placeholder='Select Country']");
	By countriesList = By.cssSelector(".ta-results");
	
	public void selectCountryName(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(selectCountry), countryName).build().perform();
		waitForElementToAppear(countriesList);
		selectedCountry.click();
	}
	
	public void checkoutAndConfirm()
	{	
		placeOrderBtn.click();
		String orderPlaceText = orderPlaceTextElement.getText();
		Assert.assertTrue(orderPlaceText.equalsIgnoreCase("Thankyou for the order."));
	}
	
}
