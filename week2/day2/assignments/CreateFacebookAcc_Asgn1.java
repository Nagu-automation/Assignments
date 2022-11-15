package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateFacebookAcc_Asgn1 {

	public static void main(String[] args) {
		// Step 1: Download and set the path

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL https://en-gb.facebook.com/

		driver.get("https://en-gb.facebook.com/");

		// Step 4: Maximise the window

		driver.manage().window().maximize();

		// Step 5: Add implicit wait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 6: Click on Create New Account button
		
		driver.findElement(By.xpath("//input[@name='jazoest']/parent::form[@method='post']//a[text()='Create New Account']")).click();

		// Step 7: Enter the first name
		
		driver.findElement(By.xpath("//div[@id='fullname_field']//input[@name='firstname']")).sendKeys("TestLeaf");
		
		// Step 8: Enter the last name
		
		driver.findElement(By.xpath("//div[text()='Surname']/following-sibling::input[@name='lastname']")).sendKeys("demo");
		
		// Step 9: Enter the mobile number
		
		driver.findElement(By.name("reg_email__")).sendKeys("9842712345");
		
		// Step 10: Enter the password
		
		driver.findElement(By.xpath("//div[@id='password_field']//input[@name='reg_passwd__']")).sendKeys("Testleaf@demo");
		
		// Step 11: Handle all the three drop downs
		
		WebElement dobDay = driver.findElement(By.id("day"));
		WebElement dobMonth = driver.findElement(By.id("month"));
		WebElement dobYear = driver.findElement(By.id("year"));
		
		Select sltDay = new Select(dobDay);
		Select sltMonth = new Select(dobMonth);
		Select sltYear = new Select(dobYear);
		
		sltDay.selectByValue("19");
		sltMonth.selectByVisibleText("Dec");
		sltYear.selectByValue("1990");
		
		
		// Step 12: Select the radio button "Female" ( A normal click will do for this step)
		
		driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).click();
		
	}

}
