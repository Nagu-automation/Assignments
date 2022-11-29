package week4.day1.assign2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {

		// Setting up the driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the desired application URL
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Switching to the corresponding frame using frame id to access the web element
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Test Leaf - Frames");

		// Switching to the corresponding frame using frame id to access the web element
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();

		// Switching back to the default frame to access the other frame which is not in
		// nested form
		driver.switchTo().defaultContent();

		// Switching to the corresponding frame using frame id to access the web element
		driver.switchTo().frame("frame2");
		WebElement animalsDropDown = driver.findElement(By.id("animals"));

		// Selecting the desired value from the dropdown using select by value option
		Select animalsSelect = new Select(animalsDropDown);
		animalsSelect.selectByValue("avatar");

		// Switching back to the default frame
		driver.switchTo().defaultContent();

		driver.close();
	}

}
