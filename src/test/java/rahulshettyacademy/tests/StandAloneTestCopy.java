package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTestCopy {
	
/*
		
		// Creating Variables
		String emailId = "aniketfunde@gmail.com";
		String password = "Aniket@20";
		String productName = "ADIDAS ORIGINAL";
		
		// Creating driver object
		WebDriver driver = new ChromeDriver();
		
		// Landing on landing page, adding implicit wait, maximizing window
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Login 
		
		driver.findElement(By.id("userEmail")).sendKeys(emailId);
		driver.findElement(By.id("userPassword")).sendKeys(password);	
		driver.findElement(By.cssSelector("input[name=\'login\']")).click();
		
		
		// Selecting Product
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products =  driver.findElements(By.cssSelector(".mb-3"));
		
		//WebElement prod =products.stream().filter(product->
		//product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ADIDAS ORIGINAL")).findFirst().orElse(null);
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//productCatalog.getProductByName(productName);
	    
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();		
		
		
		// Checking if correct items are added in cart or not
		
		List <WebElement> cartItems = driver.findElements(By.cssSelector("div[class=\'cart\'] ul"));
		boolean match = cartItems.stream().anyMatch(item -> 
		item.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
	
		// Selecting Country
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("//button[contains(@class, 'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".action__submit ")).click();
		
		String orderPlaceText = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
		
		Assert.assertTrue(orderPlaceText.equalsIgnoreCase("Thankyou for the order."));
	
	*/
}
