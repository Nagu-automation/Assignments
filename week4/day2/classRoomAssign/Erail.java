package week4.day2.classRoomAssign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MAS");
		driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();

		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("CBE");
		driver.findElement(By.xpath("//div[text()='Coimbatore Jn']")).click();

		driver.findElement(By.id("chkSelectDateOnly")).click();

		List<WebElement> trainNameListWebEle = driver
				.findElements(By.xpath("//table[contains(@class,'TrainList')]/tbody/tr/td[2]/a"));

		List<String> trainNameList = new ArrayList<String>();
		System.out.println("The train names are: ");
		for (WebElement trainNameListEle : trainNameListWebEle) {

			trainNameList.add(trainNameListEle.getText());
			System.out.println(trainNameListEle.getText());

		}

		Set<String> trainNameSet = new LinkedHashSet<String>(trainNameList);

		if (trainNameList.size() == trainNameSet.size()) {
			System.out.println("No Duplicate Trains");
		} else {

		}
		System.out.println("There are few Duplicate Trains");

	}

}
