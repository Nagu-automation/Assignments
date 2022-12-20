package week6.day1.assign3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class BaseClass {
	
	public static ChromeDriver driver;
	public static Shadow shadowRoot;
	public static WebDriverWait wait;
	public static Actions builder;
	public static String incidentNo;
	
	@Parameters({"url","uName","pWord"})
	@BeforeMethod
	public void runLogin(@Optional("https://dev123377.service-now.com/login.do?") String url, @Optional("admin") String uName, @Optional("Nagu1990@8285") String pWord) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		shadowRoot = new Shadow(driver);
		shadowRoot.setImplicitWait(30);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		builder = new Actions(driver);
		
		//Launch ServiceNow application
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login with valid credentials
		WebElement uNameEle = driver.findElement(By.id("user_name"));
		uNameEle.clear();
		uNameEle.sendKeys(uName);
		WebElement pWordEle = driver.findElement(By.id("user_password"));
		pWordEle.clear();
		pWordEle.sendKeys(pWord);
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
