package week4.day2.assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 2. Get the count of number of rows
		List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		System.out.println("Number of rows: " + numberOfRows.size());
		
		// 3. Get the count of number of columns
		List<WebElement> numberOfColumns = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr/th"));
		System.out.println("Number of columns: " + numberOfColumns.size());
	}

}
