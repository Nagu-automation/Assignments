package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnList {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone", Keys.ENTER);
		List<WebElement> allMblePriceEle = driver
				.findElements(By.xpath("//span[@class='a-price']//span[@class='a-price-whole']"));

		List<Integer> price = new ArrayList<Integer>();

		for (WebElement priceMbleEle : allMblePriceEle) {
			String priceOfEchMbe = priceMbleEle.getText().replace(",", "");
			price.add(Integer.parseInt(priceOfEchMbe));

		}

		Collections.sort(price);

		System.out.println(price);
		System.out.println("The least amount of the mobile: " + price.get(0));

	}

}
