package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import rahulshettyacademy.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css="div[class=\'cart\'] ul")
	List <WebElement> cartItems;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCartBy = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	By cartButton = By.cssSelector("button[routerlink*='cart']");
	By checkoutBtn = By.cssSelector("li[class='totalRow'] button");
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod =getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCartBy).click();
		waitForElementToAppear(toastContainer);
		waitForElementToDisappear(spinner);
	}
	
	
	public boolean verifyCartProduct(String productName)
	{
		driver.findElement(cartButton).click();	
		boolean match = cartItems.stream().anyMatch(item -> 
		item.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(productName));
		//Assert.assertTrue(match);    We should not write validations in Page Object files it should be in the main file only
		return match;
	}
	
	public ProductPayment goToPayment()
	{
		driver.findElement(checkoutBtn).click();
		ProductPayment productPayment = new ProductPayment(driver);
		return productPayment;
	}
	
}
