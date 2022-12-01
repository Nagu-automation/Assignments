package seleniumMarathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		// 01) Launch Firefox / Chrome
		// 02) Load https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// 03) Type ""Chennai"" in the FROM text box and select the first option
		driver.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@data-message='Please enter a source city']/following-sibling::ul/li[@data-no='2']")).click();
		
		// 04) Type ""Bangalore"" in the To text box and select the first option
		driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']/following-sibling::ul/li[@data-no='2']")).click();
		
		// 05) Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		driver.findElement(By.xpath("//table[contains(@class,'monthTable')]/tbody/tr/td[@class='next']")).click();
		driver.findElement(By.xpath("//table[contains(@class,'monthTable')]/tbody/tr[3]/td[text()='1']")).click();
		
		// 06) Click Search Buses
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		WebElement gotit = driver.findElement(By.xpath("//span[contains(text(),'got it')]"));
		driver.executeScript("arguments[0].click()", gotit);

		// 07) Print the number of buses shown as results
		String busCountRaw = driver.findElement(By.xpath("//span[contains(@class,'busFound')]")).getText();
		String busCount = busCountRaw.replaceAll("[^0-9]", "");
		System.out.println("The buses count is: " + busCount);
		
		// 08) Choose SLEEPER in the left menu
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		
		
		// 09) Print the name of the second resulting bus
		String secondListedBus = driver.findElement(By.xpath("(//ul[@class='bus-items']/div//div[contains(@class,'travels')])[2]")).getText();
		System.out.println("The second listed bus is: " + secondListedBus);
		
		// 10) Click the VIEW SEATS of that bus
		driver.findElement(By.xpath("(//ul[@class='bus-items']//div[@class='clearfix bus-item']//div[text()='View Seats'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Lower Deck']"))));
		
		// 11) Take screenshot and close browser
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./redbus/viewseat.png");
		FileUtils.copyFile(screenshotAs, dest);
		System.out.println("Screenshot is taken successfully");
	}

}
