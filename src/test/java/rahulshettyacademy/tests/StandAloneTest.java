package rahulshettyacademy.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.OrdersPage;
import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.pageObjects.ProductPayment;
import rahulshettyacademy.testcomponent.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StandAloneTest extends BaseTest{
	
	
	
		@Test(dataProvider="getData")
		
		public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
		{
			
			
			//LandingPage landingPage = launchApplication();
			ProductCatalog productCatalog = landingPage.loginApplication(input.get("emailId"), input.get("password")); // instead of creating new object for ProductCatalog here we have created that object inside the loginApplication method and returned it from there. 
			List <WebElement> products = productCatalog.getProductList();
			productCatalog.addProductToCart(input.get("productName"));
			boolean match = productCatalog.verifyCartProduct(input.get("productName"));
			Assert.assertTrue(match);
			ProductPayment productPayment = productCatalog.goToPayment();
			productPayment.selectCountryName("india");
			productPayment.checkoutAndConfirm();
		}
	
	
		@Test(dependsOnMethods= {"submitOrder"})
		
		public void ordersHistoryTest()
		{
			ProductCatalog productCatalog = landingPage.loginApplication("aniketfunde@gmail.com", "Aniket@20");
			OrdersPage ordersPage = productCatalog.goToOrdersPage();
			Assert.assertTrue(ordersPage.verifyProductDisplay("ADIDAS ORIGINAL")); 
		}
		
		@DataProvider
		
		
		public Object[][] getData() throws IOException
		{
			List<HashMap<String,String>> data =  getJsonDataToMap("C:\\Users\\anike\\OneDrive\\Documents\\Selenium\\SeleniumFrameworkDesign\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
			//return new Object[][]  {{"aniketfunde@gmail.com", "Aniket@20", "ADIDAS ORIGINAL"}, {"aniee@gmail.com", "Aniket@20", "ZARA COAT 3"}};
			return new Object[][] {{data.get(0)}, {data.get(1)}};
		}
	

}
