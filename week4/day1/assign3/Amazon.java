package week4.day1.assign3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {

		// Setting up the driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the desired application URL 'https://www.amazon.in/'
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);

		// search as oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);

		// Get the price of the first product
		String priceRaw = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		String price = priceRaw.replace(",", "");
		int price_upd = Integer.parseInt(price);
		System.out.println("The first product of the price is: " + price_upd);

		// Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath(
				"//a[@class='a-popover-trigger a-declarative']//ancestor::span[@class='a-declarative']//following::a/span"))
				.getText();
		System.out.println("The customer rating of this product is: " + rating);

		// Click the first text link of the first image
		driver.findElement(By.xpath("//span[text()='RESULTS']//following::h2//span")).click();

		// Take a screen shot of the product displayed
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandle.get(1));

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File(".\\snapshot\\oneplus.png");
		FileUtils.copyFile(source, destination);

		// Click 'Add to Cart' button
		builder.moveToElement(
				driver.findElement(By.xpath("//div[@class='a-box-inner']//span[@id='submit.add-to-cart-announce']")))
				.click().perform();

		// Get the cart subtotal and verify if it is correct.
		int sub_Total = 0;
		WebElement cart = driver.findElement(By.xpath(
				"//div[@id='attach-desktop-sideSheet']//span[@id='attach-sidesheet-view-cart-button-announce']"));
		builder.pause(Duration.ofSeconds(10)).moveToElement(cart).pause(Duration.ofSeconds(10)).click().perform();
		String subtotalRaw = driver
				.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span[contains(@class,'sc-price')]"))
				.getText();
		
		// String subtotalRaw =
		// driver.findElement(By.xpath("//div[contains(@class,'attach-accessory-section')]//span[@id='attach-accessory-cart-subtotal']")).getText();
		String subTotal = subtotalRaw.replaceAll("[^0-9]", "");
		String sub_total = subTotal.substring(0, subTotal.length() - 2);
		sub_Total = Integer.parseInt(sub_total);

		if (price_upd == sub_Total) {
			System.out.println("The price '" + price_upd + "' is matching with the cart value: '" + sub_Total + "'");
		} else {
			System.out
					.println("The price '" + price_upd + "' is not matching with the cart value: '" + sub_Total + "'");
		}

		// close the browser
		driver.quit();

	}

}
