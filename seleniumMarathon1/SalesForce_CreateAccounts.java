package seleniumMarathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce_CreateAccounts {

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

		// 4. Click on Accounts tab
		WebElement accountTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", accountTab);

		// 5. Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();

		// 6. Enter 'your name' as account name
		driver.findElement(By.xpath("//div/input[@name='Name']")).sendKeys("Nagaraj");

		// 7. Select Ownership as Public
		driver.findElement(By
				.xpath("//label[text()='Ownership']/following::button[@data-value='--None--']/span[text()='--None--']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();

		// 8. Click save and verify Account name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String accountName = driver.findElement(By.xpath("//span[text()='Account']/a/div")).getText();
		if(accountName.contains("Nagaraj"))
		{
			System.out.println("The account is created for " + accountName);
		}else
		{
			System.out.println("The account is not created for " + accountName);
		}
	}

}
