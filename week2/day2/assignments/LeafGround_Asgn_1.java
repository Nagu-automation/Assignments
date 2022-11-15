package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Asgn_1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Type your name
		driver.findElement(By.xpath("//h5[text()='Type your name']/parent::form//div/input"))
				.sendKeys("Nagaraj Arumugam");

		// Append Country to this City.
		driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::div/input"))
				.sendKeys(" India");

		// Verify if text box is disabled
		boolean txtBoxEnabled = driver
				.findElement(By.xpath("//h5[text()='Verify if text box is disabled']/following::div//input"))
				.isEnabled();
		if (txtBoxEnabled) {
			System.out.println("The field is enabled");
		} else {
			System.out.println("The field is disabled");
		}

		// Clear the typed text.
		driver.findElement(By.xpath("//h5[text()='Clear the typed text.']/following::div//input")).clear();

		// Retrieve the typed text.
		String retrieveText = driver
				.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following::div//input"))
				.getAttribute("value");
		System.out.println(retrieveText);

		// Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.xpath("//h5[contains(text(),'email')]/following::div//input"))
				.sendKeys("Sample@testleaf.com", Keys.TAB);
		String typeAboutYourselfClassValue = driver
				.findElement(By.xpath("//h5[text()='Type about yourself']/following::div//textarea"))
				.getAttribute("class");
		if (typeAboutYourselfClassValue.contains("ui-state-focus")) {
			System.out.println("Control Moved to this tab from email field");
		} else {
			System.out.println("Control is notMoved to this tab from email field");
		}

		// Type about yourself
		driver.findElement(By.xpath("//h5[text()='Type about yourself']/following::div//textarea"))
				.sendKeys("Simple person having aim to achieve more");
		
		//Text Editor
		driver.findElement(By.xpath("//h5[text()='Text Editor']/following::div//button[@class='ql-bold']")).click();
		driver.findElement(By.xpath("//h5[text()='Text Editor']/following::div//button[@class='ql-italic']")).click();
		
		driver.findElement(By.xpath("//h5[text()='Text Editor']/following::div//div[contains(@class,'ql-editor')]")).sendKeys("This is sample check");
		

		// Just Press Enter and confirm error message*
		driver.findElement(By.xpath("//h5[text()='Just Press Enter and confirm error message*']/following::div/input"))
				.sendKeys(Keys.ENTER);
		String errorMessage = driver.findElement(By.xpath(
				"//h5[text()='Just Press Enter and confirm error message*']/following::div//span[@class='ui-message-error-detail']"))
				.getText();
		if (errorMessage.equalsIgnoreCase("Age is mandatory")) {
			System.out.println("The error message is '" + errorMessage + "'");
		} else {
			System.out.println("Wrong error message is displayed");
		}
		

	}

}
