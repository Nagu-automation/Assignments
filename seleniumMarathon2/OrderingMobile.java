package seleniumMarathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile {
	
	static String url = "https://dev138589.service-now.com/";
	static String username = "admin";
	static String password = "mc/-vASs9V1E";

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		Shadow shadowDom = new Shadow(driver);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		//1. Launch ServiceNow application
		driver.get(url);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		shadowDom.setImplicitWait(50);
		
		//2. Login with valid credentials username as admin and password as 
		driver.findElement(By.xpath("//div[@class='login-form-field']/input[@id='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//div[@class='login-form-field']/div/input[@id='user_password']")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		//Thread.sleep(10000);
		shadowDom.findElementByXPath("//div[@id='all']").click();
		WebElement filter = shadowDom.findElementByXPath("//div[@aria-lable='All menu']//label[text()='All filter navigator']/following-sibling::input[@id='filter']");
		wait.until(ExpectedConditions.visibilityOf(filter));
		filter.sendKeys("Service Catalog", Keys.ENTER);
		
		//4. Click on  mobiles
		driver.findElement(By.xpath("//span/h2[contains(text(),'Mobiles')]")).click();
		
		//5. Select Apple iphone6s
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a/strong[text()='iPhone 6s']")).click();
		
		//6. Update color field to rose gold and storage field to 128GB
		Select colorDpdwn = new Select(driver.findElement(By.xpath("//span[text()='What color would you like?']//parent::label/following::select")));
		colorDpdwn.selectByValue("gold");
		
		Select sizeDpdwn = new Select(driver.findElement(By.xpath("//span[text()='How many gigs of storage?']//parent::label/following::select")));
		sizeDpdwn.selectByValue("128");
		
		//7. Select  Order now option
		driver.findElement(By.xpath("//table[@id='qty']/tbody/tr[@class='order_buttons']//button")).click();
		
		//8. Verify order is placed and copy the request number"
		String requestId = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("The request id is: " + requestId);
		

	}

}
