package rahulshettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.testcomponent.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	String emailId = "aniketfune@gmail.com";
	String password = "Aniket20";
	String productName = "ADIDAS ORIGINAL";
	
	@Test(groups= {"ErrorValidations"})
	public void ErrorValidationsTest()
	{
		
		
		//LandingPage landingPage = launchApplication();
		ProductCatalog productCatalog = landingPage.loginApplication(emailId, password);
		Assert.assertEquals(landingPage.getErrorMsg(), "Incorrect email or password.");
		
	}
}
