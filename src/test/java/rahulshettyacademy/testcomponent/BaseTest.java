package rahulshettyacademy.testcomponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyacademy.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver ;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		// Hi cchanges from Person 2
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\anike\\OneDrive\\Documents\\Selenium\\SeleniumFrameworkDesign\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		// Read JSON to String
		String jsonContent = FileUtils.readFileToString(
			    new java.io.File(filePath),
			    StandardCharsets.UTF_8);

		
		// String to hashmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {	
		});
		
		return data;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		 landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
}
