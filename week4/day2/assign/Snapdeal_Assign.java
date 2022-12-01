package week4.day2.assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal_Assign {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 2. Go to Mens Fashion
		WebElement menFashionEle = driver.findElement(By.xpath(
				"//div[text()='Top Categories']/following::a[contains(@class,'menuLinks')]/span[contains(text(),'Men')]"));
		builder.moveToElement(menFashionEle).perform();

		// 3. Go to Sports Shoes
		WebElement sportShoe = driver.findElement(By.xpath("//div[@id='category1Data']//span[text()='Sports Shoes']"));
		builder.moveToElement(sportShoe).click().perform();

		// 4. Get the count of the sports shoes
		String shoeCount = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div"))
				.getText();
		System.out.println("The count of sports shoes for men is: " + shoeCount);

		// 5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// 6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-index='1']")).click();

		// 7. Check if the items displayed are sorted correctly
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"))));
		List<WebElement> priceEles = driver
				.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
		List<Integer> priceValues = new ArrayList<Integer>();
		// Map<Integer, Integer> priceValues = new TreeMap<Integer, Integer>();
		for (int i = 1; i <= priceEles.size(); i++) {
			WebElement priceEle = driver
					.findElement(By.xpath("(//div[@id='products']//span[@class='lfloat product-price'])[" + i + "]"));
			wait.until(ExpectedConditions.visibilityOf(priceEle));
			priceValues.add(Integer.parseInt(priceEle.getText().replaceAll("[^0-9]", "")));
			// priceValues.put(i,Integer.parseInt(priceEle.getText().replaceAll("[^0-9]",
			// "")));
		}

		System.out.println("Raw price from application: " + priceValues);

		List<Integer> priceSort = new ArrayList<Integer>(priceValues);
		Collections.sort(priceSort);
		System.out.println("Price after sorting: " + priceSort);

		for (int i = 0; i < priceValues.size(); i++) {
			if (priceValues.get(i) == priceSort.get(i)) {
				continue;
			} else {
				System.out.println(priceValues.get(i) + " is not matching with " + priceSort.get(i));
			}

		}

		// 8.Select the price range (900-1200)

		WebElement leftScroll = driver.findElement(By.xpath("//a[contains(@class,'left-handle')]"));
		WebElement rightScroll = driver.findElement(By.xpath("//a[contains(@class,'right-handle')]"));
		//Point location = leftScroll.getLocation();
		//System.out.println(location);
		//System.out.println(rightScroll.getLocation());
		builder.pause(Duration.ofSeconds(5)).clickAndHold(leftScroll).pause(Duration.ofSeconds(5)).moveByOffset(64, 0)
				.release().perform();
		builder.pause(Duration.ofSeconds(5)).clickAndHold(rightScroll).pause(Duration.ofSeconds(5))
				.moveByOffset(-106, 0).release().perform();

		// 9.Filter with color Yellow
		Thread.sleep(3000);
		WebElement color = driver.findElement(By.xpath("//label[@for='Color_s-Yellow']/ancestor::div[contains(@class,'sdCheckbox')]"));
		//color.click();
		builder.moveToElement(color).click().perform();

		// 10 verify the all applied filters
		Thread.sleep(3000);
		List<WebElement> filterEles = driver
				.findElements(By.xpath("(//div[@class='filters-top-selected']/div[@class='filters']/div/a)"));
		List<String> filterValue = new ArrayList<String>();
		for (int i=1; i<=filterEles.size();i++) {
			WebElement filter = driver.findElement(By.xpath("(//div[@class='filters-top-selected']/div[@class='filters']/div/a)["+i+"]"));
			wait.until(ExpectedConditions.visibilityOf(filter));
			filterValue.add(i-1, filter.getText().replaceAll("[^A-Za-z0-9.-]", ""));
			
		}
		System.out.println(filterValue);

		// 11. Mouse Hover on first resulting Training shoes
		WebElement firstProduct = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		builder.moveToElement(firstProduct).perform();
		
		// 12. click QuickView button
		WebElement quickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		builder.moveToElement(quickView).pause(Duration.ofSeconds(5)).click().perform();
		
		// 13. Print the cost and the discount percentage
		WebElement price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		System.out.println("Total price is: " + price.getText().replaceAll("[^0-9]", ""));
		WebElement offDis = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]"));
		System.out.println("The off % is: " + offDis.getText());
		
		// 14. Take the snapshot of the shoes.
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File filePath = new File("./SnapDeal/snap.png");
		FileUtils.copyFile(screenshot, filePath);
		
		// 15. Close the current window
		driver.findElement(By.xpath("//div[contains(@class,'marR10')]/i[contains(@class,'sd-icon-delete-sign')]")).click();
		
		// 16. Close the main window
		driver.quit();
	}

}
