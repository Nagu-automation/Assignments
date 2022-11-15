package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead_Asgn2 {

	public static void main(String[] args) throws InterruptedException {
		// http://leaftaps.com/opentaps/control/main

		// Launch the browser

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// Enter the username

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		// Enter the password

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click Login

		driver.findElement(By.className("decorativeSubmit")).click();

		// Click crm/sfa link

		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads link

		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads

		driver.findElement(By.linkText("Find Leads")).click();
		
		// Enter first name
		
		driver.findElement(By.xpath("(//form[@class=' x-form']//input[@name='firstName'])[3]")).sendKeys("Abi");
		
		// Click Find leads button
		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		
		// Click on first resulting lead
		
		driver.findElement(By.xpath("//td[contains(@class,'x-grid3-td-partyId')]/div[contains(@class,'x-grid3-col-partyId')]/a[@class='linktext']")).click();
		
		// Verify title of the page
		
		String title = driver.getTitle();
		
		if(title.contains("View"))
		{
			System.out.println("The page is navigated to view lead");
		}else
		{
			System.out.println("The page is not navigated to view lead");
		}
		
		// Click Edit
		
		driver.findElement(By.linkText("Edit")).click();
		
		// Change the company name
		
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("CTS");
		
		String updatedName = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		
		// Click Update
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		// Confirm the changed name appears
		
		String companyName_sp = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(companyName_sp.contains(updatedName))
		{
			System.out.println("The lead name is matching");
		}else
		{
			System.out.println("The lead name is not matching");
		}
		
		// Close the browser (Do not log out)
		
		driver.close();

	}

}
