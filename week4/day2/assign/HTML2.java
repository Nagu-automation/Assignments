package week4.day2.assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2. You have to print the respective values based on given Library
		List<WebElement> marketSharesEle = driver.findElements(By.xpath(
				"//caption[contains(text(),'Libraries')]//parent::table/tbody/tr/td[text()='Market Share']/following-sibling::td"));
		System.out.print("Market Share: ");
		for (int i = 0; i < marketSharesEle.size(); i++) {
			System.out.print(marketSharesEle.get(i).getText() + " ");
		}
		System.out.println();
		List<WebElement> absoluteUsageEle = driver.findElements(By.xpath(
				"//caption[contains(text(),'Libraries')]//parent::table/tbody/tr/td[text()='Absolute Usage']/following-sibling::td"));
		System.out.print("Absolute Usage: ");
		for (int i = 0; i < absoluteUsageEle.size(); i++) {
			System.out.print(absoluteUsageEle.get(i).getText() + " ");
		}
	}

}
