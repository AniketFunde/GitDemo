package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	 WebDriver driver;

	 @FindBy(css = "tr td:nth-child(3)")
	 private List<WebElement> productNames;
	 
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductDisplay(String productName)
	{
		boolean match = productNames.stream().anyMatch(item -> 
		item.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
