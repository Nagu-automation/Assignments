package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_Asgn2 {

	public static void main(String[] args) {

		//	Pseudo Code
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		

		//	1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//	2. Enter UserName and Password Using Id Locator
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//	3. Click on Login Button using Class Locator
		
		driver.findElement(By.className("decorativeSubmit")).click();

		//	4. Click on CRM/SFA Link
		
		driver.findElement(By.linkText("CRM/SFA")).click();

		//	5. Click on contacts Button
		
		driver.findElement(By.linkText("Contacts")).click();

		//	6. Click on Create Contact
		
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Create Contact']")).click();

		//	7. Enter FirstName Field Using id Locator
		
		driver.findElement(By.id("firstNameField")).sendKeys("TestLeaf");

		//	8. Enter LastName Field Using id Locator
		
		driver.findElement(By.id("lastNameField")).sendKeys("Contact");

		//	9. Enter FirstName(Local) Field Using id Locator
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Create");

		//	10. Enter LastName(Local) Field Using id Locator
		
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Contact");

		//	11. Enter Department Field Using any Locator of Your Choice
		
		driver.findElement(By.xpath("//td/input[@name='departmentName']")).sendKeys("Testing");

		//	12. Enter Description Field Using any Locator of your choice 
		
		driver.findElement(By.name("description")).sendKeys("Create Contact");

		//	13. Enter your email in the E-mail address Field using the locator of your choice
		
		driver.findElement(By.name("primaryEmail")).sendKeys("createContact@testleaf.com");

		//	14. Select State/Province as NewYork Using Visible Text
		
		Select selectState = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		
		selectState.selectByVisibleText("New York");

		//	15. Click on Create Contact
		
		driver.findElement(By.className("smallSubmit")).click();

		//  16. Click on edit button 
		
		driver.findElement(By.linkText("Edit")).click();

		//  17. Clear the Description Field using .clear
		
		driver.findElement(By.name("description")).clear();

		//  18. Fill ImportantNote Field with Any text
		
		driver.findElement(By.xpath("//span[contains(text(),'Note')]//parent::td[@class='label']/following-sibling::td/textarea[@name='importantNote']")).sendKeys("updating important note section");

		//  19. Click on update button using Xpath locator
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		//  20. Get the Title of Resulting Page.
		
		System.out.println(driver.getTitle());

	}

}
