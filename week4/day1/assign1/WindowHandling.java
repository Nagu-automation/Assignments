package week4.day1.assign1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {

		// Setting up the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launching the application
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ssnceyfd5mtq1u38yu3inp0zh436503.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Click and Confirm new Window Opens
		driver.findElement(By.xpath(
				"//h5[text()='Click and Confirm new Window Opens']/following-sibling::button/span[text()='Open']"))
				.click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowHandle.get(1));
		String childWindowTitle_1 = driver.getTitle();
		if (childWindowTitle_1.equalsIgnoreCase("Dashboard")) {
			System.out.println("New window '" + childWindowTitle_1 + "' is opened");
		} else {
			System.out.println("New window '" + childWindowTitle_1 + "' is not opened");
		}

		driver.close();
		driver.switchTo().window(windowHandle.get(0));

		// Find the number of opened tabs
		String PrimaryWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		windowHandles = driver.getWindowHandles();
		windowHandle = new ArrayList<String>(windowHandles);
		System.out.println("Number of opened tabs are: " + windowHandles.size());
		for (String window : windowHandle) {
			if (window.equalsIgnoreCase(PrimaryWindow)) {
				continue;
			} else {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(windowHandle.get(0));

		// Close all windows except Primary

		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		windowHandles = driver.getWindowHandles();
		windowHandle = new ArrayList<String>(windowHandles);
		for (String window : windowHandle) {
			if (window.equalsIgnoreCase(PrimaryWindow)) {
				continue;
			} else {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(windowHandle.get(0));

		// Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		windowHandles = driver.getWindowHandles();
		windowHandle = new ArrayList<String>(windowHandles);
		for (String window : windowHandle) {
			if (window.equalsIgnoreCase(PrimaryWindow)) {
				continue;
			} else {
				String childWindow = driver.switchTo().window(window).getTitle();
				System.out.println("New Child window '" + childWindow + "' is opened");
			}
		}
		
		driver.quit();

	}

}
