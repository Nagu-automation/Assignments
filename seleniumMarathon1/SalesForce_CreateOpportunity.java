package seleniumMarathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce_CreateOpportunity {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);

		// 1. Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.findElement(By.xpath("//div[@id='username_container']//input"))
				.sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input[@id='password']"))
				.sendKeys("Testleaf$321");
		
		driver.findElement(By.xpath("//div/following-sibling::input[@type='submit']")).click();
		
		// 2. Click on toggle menu button from the left corner
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		// 3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//lightning-button/button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();		
		
		// 4. Click on Opportunity tab
		WebElement oppTab = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", oppTab);
		
		// 5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();		
		
		// 6. Enter Opportunity name as 'Salesforce Automation by *Your Name*,Get the text and Store it
		driver.findElement(By.xpath("//lightning-input/div/input[@name='Name']")).sendKeys("Salesforce Automation by Nagaraj");
		//String opportunityName = driver.findElement(By.xpath("//lightning-input/div/input[@name='Name']")).getText();		
		
		// 7. Choose close date as Today
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
		
		// 8. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//button/span[text()='--None--']")).click();
		WebElement stage = driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", stage);
		
		
		// 9. click Save and VerifyOppurtunity Name"
		driver.findElement(By.xpath("//lightning-button/button[@name='SaveEdit']")).click();
		String oppName = driver.findElement(By.xpath("//span[text()='Opportunity']/a[@class='forceActionLink']/div")).getText();
		if(oppName.contains("Nagaraj"))
		{
			System.out.println("The opportunity for " + oppName + " is created successfully");
		}else
		{
			System.out.println("The opportunity for " + oppName + " is not created successfully");
		}

	}

}
