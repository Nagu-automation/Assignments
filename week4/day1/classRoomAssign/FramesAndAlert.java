package week4.day1.classRoomAssign;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAndAlert {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new  ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//h2[text()='JavaScript Prompt']/following-sibling::button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Nagaraj");
		alert.accept();
		
		String text = driver.findElement(By.xpath("//h2[text()='JavaScript Prompt']/following-sibling::p")).getText();
		
		if(text.contains("Nagaraj"))
		{
			System.out.println("Yes, I can able to achieve it");
		}

	}

}
