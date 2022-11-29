package week4.day2.classRoomAssign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		WebElement menFashionEle = driver.findElement(By.xpath("//a[contains(@class,'menuLinks')]/span[contains(text(),'Men')]"));
		builder.moveToElement(menFashionEle).perform();
		
		WebElement shirts = driver.findElement(By.xpath("//div[@class='colDataInnerBlk']//p//span[text()='Jeans']/preceding::span[text()='Shirts']"));
		builder.moveToElement(shirts).click().perform();
		
		WebElement firstProduct = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]"));
		builder.pause(Duration.ofSeconds(5)).moveToElement(firstProduct).pause(Duration.ofSeconds(5)).perform();
		
		driver.findElement(By.xpath("(//div[@class='product-tuple-image ']/div/div[contains(text(),'Quick View')])[1]")).click();
		
		
	}

}
