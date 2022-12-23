package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassCC extends AbstractTestNGCucumberTests{
	
	public static ChromeDriver driver;
	public static SoftAssert sa;
	public static String leadId;
	public static String leadIdExp;
	public static WebDriverWait wait;
	
	@BeforeMethod
	public void runLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sa = new SoftAssert();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();	
		
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@AfterMethod
	public void runCloseBrowser() {
		driver.close();
	}

}
