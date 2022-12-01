package week4.day2.assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);

		// 1. Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2. Click on stock market
		driver.findElement(By.linkText("STOCK MARKET")).click();

		// 3. Click on NSE bulk Deals
		driver.findElement(By.linkText("NSE Bulk Deals")).click();

		// 4. Get all the Security names
		Thread.sleep(3000);
		builder.scrollToElement(driver.findElement(By.xpath("//h2[contains(text(),'NSE Bulk Deals')]"))).perform();
		List<WebElement> securityNameEles = driver.findElements(
				By.xpath("(//h2[contains(text(),'NSE Bulk Deals')]/following-sibling::div/table/tbody/tr/td[3])"));
		List<String> securityName = new ArrayList<String>();
		for (int i = 1; i <= securityNameEles.size(); i++) {
			securityName.add(driver.findElement(By.xpath(
					"(//h2[contains(text(),'NSE Bulk Deals')]/following-sibling::div/table/tbody/tr/td[3])[" + i + "]"))
					.getText());
			System.out.println(securityName.get(i - 1));
		}

		Set<String> securityNameUnique = new LinkedHashSet<String>(securityName);

		// 5. Ensure whether there are duplicate Security names
		if (securityNameUnique.size() == securityName.size()) {
			System.out.println("Security names dont have duplicates");
		} else {
			System.out.println("Security names have duplicates");
		}

	}

}
