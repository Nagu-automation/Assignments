package seleniumMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce_CreateTask {

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
		
		// 4) Click on Global Actions SVG icon (can see as + icon at right corner)
		WebElement add = driver.findElement(By.xpath("//div/a[contains(@class,'globalCreateTrigger')]"));
		driver.executeScript("arguments[0].click()", add);
		
		// 5) Click New Task
		WebElement newTask = driver.findElement(By.xpath("//span[@class='actionIcon']/following-sibling::span[text()='New Task']"));
		driver.executeScript("arguments[0].click()", newTask);
		
		// 6) Enter subject as ""Bootcamp ""
		driver.findElement(By.xpath("//label[text()='Subject']/parent::lightning-grouped-combobox//input")).sendKeys("Bootcamp");
		
		// 7) Select status as 'Waiting on someone else'
		WebElement status = driver.findElement(By.xpath("//div/a[text()='Not Started']"));
		driver.executeScript("arguments[0].click()", status);
		
		WebElement statusOption = driver.findElement(By.xpath("//li/a[@title='Waiting on someone else']"));
		driver.executeScript("arguments[0].click()", statusOption);
		
		// 9) Save and verify the 'Task created' message"
		driver.findElement(By.xpath("//div[contains(@class,'bottomBarRight')]//span[text()='Save']")).click();
		String taskCreated = driver.findElement(By.xpath("//span[text()='Task']/a[@title='Bootcamp']/div")).getText();
		if(taskCreated.equalsIgnoreCase("Bootcamp"))
		{
			System.out.println("The task is created");
		}else
		{
			System.out.println("The task is not created");
		}
	}

}
