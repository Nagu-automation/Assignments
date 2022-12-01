package week4.day2.assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssign {

	public static void main(String[] args) throws InterruptedException {

		// Setting up the driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// launching the desired application URL
		// 'https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0'
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node01qey7o6oowt9dc09s8l9hc4bu437441.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);

		// Draggable
		System.out.println("Dragging the element: ");
		WebElement draggable = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		Point location = draggable.getLocation();
		System.out.println("Before dragging the element: " + location);
		builder.dragAndDropBy(draggable, 400, location.getX()).perform();
		System.out.println("After dragging the element: " + draggable.getLocation());

		// Droppable
		System.out.println();
		System.out.println("Dropping the element: ");
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement target = driver.findElement(By.xpath("//p[text()='Drop here']"));
		builder.dragAndDrop(source, target).perform();
		System.out.println("Dropped the element successfully");

		// Draggable columns
		WebElement draggableColumnsName = driver.findElement(By.xpath(
				"//h5[text()='Draggable Columns']/following-sibling::div//table/thead/tr/th/span[text()='Name']"));
		WebElement draggableColumnsQuantity = driver.findElement(By.xpath(
				"//h5[text()='Draggable Columns']/following-sibling::div//table/thead/tr/th/span[text()='Quantity']"));
		builder.dragAndDrop(draggableColumnsName, draggableColumnsQuantity).perform();
		WebElement columnReordered = driver.findElement(By.xpath("//span[text()='Columns reordered']"));
		if (columnReordered.isDisplayed()) {
			System.out.println("The columns are reordered successfully");
		} else {
			System.out.println("The columns are not reordered successfully");
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(columnReordered));

		//Draggable Rows
		WebElement sourceRow = driver.findElement(
				By.xpath("//h5[text()='Draggable Rows']/following-sibling::div//table/tbody/tr[@data-ri='1']"));
		WebElement targetRow = driver.findElement(
				By.xpath("//h5[text()='Draggable Rows']/following-sibling::div//table/tbody/tr[@data-ri='5']"));
		builder.dragAndDrop(sourceRow, targetRow).perform();

		/*
		 * Confirmation popup is not coming while running in automation. So,
		 * commented this block of codes
		 * 
		 * WebElement rowReordered =
		 * driver.findElement(By.xpath("//div[@class='ui-growl-message']/span"));
		 * wait.until(ExpectedConditions.invisibilityOf(rowReordered));
		 * 
		 * String rowFromTo =
		 * driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText();
		 * if(rowReordered.isDisplayed()) { System.out.println("The rows are reordered "
		 * + rowFromTo); }else { System.out.println("The row are not reordered"); }
		 */

		// Progress Bar
		driver.findElement(By.xpath("//span[text()='Start']")).click();
		WebElement progressEle = driver.findElement(
				By.xpath("//h5[text()='Progress Bar']/following-sibling::div/div[@class='ui-progressbar-label']"));
		System.out.println("The progress are - ");
		int i = 0;
		do {
			String progress = progressEle.getText().replace("%", "");
			int a = Integer.parseInt(progress);
			if (a > i) {
				System.out.println(progress + "% ");
			}
			i = a + 1;

		} while (i <= 100);

		// Range Slider
		WebElement rightButton = driver.findElement(By.xpath("//span[contains(@style,'80%')]"));
		WebElement leftbutton = driver.findElement(By.xpath("//span[contains(@style,'30%')]"));
		builder.clickAndHold(rightButton).moveByOffset(400, 0).release().perform();
		builder.clickAndHold(leftbutton).pause(Duration.ofSeconds(2)).moveByOffset(-100, 0).release().perform();

	}

}
