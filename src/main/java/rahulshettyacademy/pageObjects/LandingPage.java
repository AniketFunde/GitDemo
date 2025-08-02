package rahulshettyacademy.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageFactory
	@FindBy(id="userEmail")
	WebElement emaidID;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(css="input[name=\'login\']")
	WebElement loginButton;
	
	//.ng-tns-c4-6.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css="div[class*='flyInOut']")
	WebElement errorMsg;
	
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
	}
	
	public String getErrorMsg()
	{
		waitForWebElementToAppear(errorMsg);
		return errorMsg.getText();
	}
	
	public ProductCatalog loginApplication(String email, String password)
	{
		emaidID.sendKeys(email);
		passwordEle.sendKeys(password);
		loginButton.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
}
