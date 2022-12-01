package week4.day2.assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nyka_Assign {

	public static void main(String[] args) {
		//Setting up the environments
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brandsTab = driver.findElement(By.xpath("//li/a[text()='brands']"));
		builder.moveToElement(brandsTab).perform();
		
		//3) Click L'Oreal Paris
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String lorealPageTitle = driver.getTitle();
		if(lorealPageTitle.contains("L'Oreal"))
		{
			System.out.println("L'Oreal Paris products page is opened");
		}else
		{
			System.out.println("Expected page is not opened");
		}
		
		//5) Click sort By and select customer top rated
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//ul[@class='css-z5o5ca']//span[contains(text(),'customer top rated')]")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Hair']"))));
		WebElement hairEle = driver.findElement(By.xpath("//span[text()='Hair']"));
		builder.moveToElement(hairEle).click().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]"))));
		WebElement hairCareEle = driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]"));
		builder.moveToElement(hairCareEle).click().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Shampoo']"))));
		WebElement shampooEle = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		builder.moveToElement(shampooEle).click().perform();
		
		//7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//8)check whether the Filter is applied with Shampoo
		String filter = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::div[@class='css-rtde4j']//span[text()='Shampoo']")).getText();
		if(filter.contains("Shampoo"))
		{
			System.out.println("The filter is applied with shampoo");
		}else
		{
			System.out.println("The filter is not applied with shampoo");
		}
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		//10) GO to the new window and select size as 175ml
		WebElement sizeDrpDwn = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select size = new Select(sizeDrpDwn);
		//size.deselectAll();
		size.selectByValue("0");		
		
		//11) Print the MRP of the product
		String mrpPrice = driver.findElement(By.xpath("//h1[contains(text(),'Paris Colour Protect Shampoo')]/following-sibling::div//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("The MRP of the product is: " + mrpPrice);
		
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class='css-vp18r8']//span[text()='Add to Bag']")).click();
		
		//13) Go to Shopping Bag 
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]/following::button[@class='css-g4vs13']")).click();
		
		//14) Print the Grand Total amount
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//iframe)[1]"))));
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));
		WebElement totalEle = driver.findElement(By.xpath("//span[text()='Grand Total']/ancestor::div[contains(@class,'footer-layout')]//span[contains(@class,'css-n8gwxi')]"));
		wait.until(ExpectedConditions.visibilityOf(totalEle));
		String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/ancestor::div[contains(@class,'footer-layout')]//span[contains(@class,'css-n8gwxi')]")).getText();
		System.out.println("The grand total is: "+grandTotal);
		
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'css-175whwo')]")).click();
		
		//17) Check if this grand total is the same in step 14
		String finalAmt = driver.findElement(By.xpath("//p[text()='Price Details']//parent::div/following-sibling::p")).getText();
		if(finalAmt == grandTotal)
		{
			System.out.println("The total amount is same");
		}else {
			System.out.println("Total is not matching because it includes shipping fee as well");
		}
		
		//18) Close all windows
		driver.quit();

	}

}
