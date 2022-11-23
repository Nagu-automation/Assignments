package week3.day2.Assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioProductList {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// 1. Launch the URL https://www.ajio.com/
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// 2. In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);

		// 3. To the left of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();

		// 4. Under "Category" click "Fashion Bags"
		WebElement fashionBagsCheckBox = driver.findElement(By.xpath("//label[contains(@for,'Fashion Bags')]"));
		driver.executeScript("arguments[0].click()", fashionBagsCheckBox);

		// 5. Print the count of the items Found.
		String itemsCount = driver.findElement(By.xpath("//div[@id='products']//div[@class='length']")).getText();
		String[] itemsCountAry = itemsCount.split(" ");
		String items = itemsCountAry[0].replace(",", "");
		System.out.println("The total count of the select items: " + items);

		// 6. Get the list of brand of the products displayed in the page and print the
		// list.
		List<WebElement> listOfBrands = driver.findElements(By.xpath("//div[@class='items']//div[@class='brand']"));
		System.out.println(" ");
		System.out.println("The list of brands are:");
		System.out.println(" ");
		for (WebElement listOfBrand : listOfBrands) {

			System.out.println(listOfBrand.getText());

		}

		// 7. Get the list of names of the bags and print it
		List<WebElement> listOfBags = driver.findElements(By.xpath("//div[@class='items']//div[@class='nameCls']"));
		System.out.println(" ");
		System.out.println("The list of bag names are:");
		System.out.println(" ");
		for (WebElement listOfBag : listOfBags) {

			System.out.println(listOfBag.getText());

		}

	}

}
