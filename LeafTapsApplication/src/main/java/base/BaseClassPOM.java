package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class BaseClassPOM {
	
	public RemoteWebDriver driver;
	public static WebDriverWait wait;
	public String fileName;
	public String sheetName;
	
	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(5000));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
	
	@DataProvider(name = "featchData")
	public String[][] readData() throws IOException {
		return ReadExcelData.readData(fileName, sheetName);
	}

}
