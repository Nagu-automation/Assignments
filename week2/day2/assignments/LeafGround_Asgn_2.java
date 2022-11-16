package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Asgn_2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click and Confirm title.
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		System.out.println(driver.getTitle());

		driver.navigate().back();

		// Confirm if the button is disabled.
		boolean fieldEnabled = driver.findElement(By.xpath(
				"//h5[text()='Find the position of the Submit button']/preceding::h5[text()='Confirm if the button is disabled.']/following-sibling::button"))
				.isEnabled();
		if (fieldEnabled) {
			System.out.println("The field is enabled");
		} else {
			System.out.println("The field is disabled");
		}

		// Find the position of the Submit button
		Point location = driver
				.findElement(
						By.xpath("//h5[text()='Find the Save button color']//preceding::button/span[text()='Submit']"))
				.getLocation();
		System.out.println(location);

		// Find the Save button color
		String cssValue = driver.findElement(By.xpath("//span[text()='Save']//ancestor::button"))
				.getCssValue("background");
		System.out.println(cssValue);

		// Find the height and width of this button
		Dimension submitButtonSize = driver.findElement(By.xpath(
				"//h5[text()='Find the height and width of this button']/following-sibling::button/span[text()='Submit']"))
				.getSize();
		System.out.println(submitButtonSize);

		/*
		 * //Problem Facing: Move is not pointed to the specified x-path
		 * 
		 * Actions action = new Actions(driver);
		 * action.moveToElement(driver.findElement(By.xpath(
		 * "//h5[text()='Mouse over and confirm the color changed']/following-sibling::button/span[text()='Success']"
		 * )));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * String buttonColorWhenHover = driver.findElement(By.xpath(
		 * "//h5[text()='Mouse over and confirm the color changed']/following-sibling::button/span[contains(@style,'background')]"
		 * )) .getAttribute("Style"); if (buttonColorWhenHover.contains("salmon")) {
		 * System.out.println("The color is changed"); } else {
		 * System.out.println("The color is not changed"); }
		 */

		// Click Image Button and Click on any hidden button
		driver.findElement(By.xpath("//span[text()='Image']")).click();
		driver.findElement(By.xpath(
				"//h5[text()='Find the position of the Submit button']/preceding::h5[text()='Confirm if the button is disabled.']/following-sibling::button"))
				.click();
		
		//How many rounded buttons are there?
		int size = driver.findElements(By.xpath("//h5[text()='How many rounded buttons are there?']/following-sibling::button[contains(@class,'rounded-button')]")).size();
		System.out.println("Number of round buttons :" + size);

	}

}
