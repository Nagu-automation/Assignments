package week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestLeafApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Setting up the browser driver
		WebDriverManager.chromedriver().setup();
		
		//Creating object to use the Chrome driver class methods
		ChromeDriver driver = new ChromeDriver();
		
		//Launching the application in browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Maximizing the browser
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nagaraj");
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Arumugam");
		
		WebElement sourceDrpDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		Select sourceDrpDownSelect = new Select(sourceDrpDown);
		
		sourceDrpDownSelect.selectByValue("LEAD_DIRECTMAIL");
		
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(2000);
		
		driver.close();
		
		

	}
}
