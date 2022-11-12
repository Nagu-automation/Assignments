package week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/control/login");
				driver.manage().window().maximize();
				
				//Enter UserName and Password Using Id Locator
				
				driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//Click on Login Button using Class Locator
				
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//Click on CRM/SFA Link
				
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//Click on Leads Button
				
				driver.findElement(By.linkText("Leads")).click();
				
				//Click on Create Lead 
				
				driver.findElement(By.linkText("Create Lead")).click();
				
				//Enter CompanyName Field Using id Locator
				
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
				
				//Enter FirstName Field Using id Locator
				
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nagaraj");
				
				//Enter LastName Field Using id Locator
				
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Arumugam");
				
				//Enter FirstName(Local) Field Using id Locator
				
				driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Nags");
				
				//Enter Department Field Using any Locator of Your Choice
				
				driver.findElement(By.name("departmentName")).sendKeys("Testing");
				
				//Enter Description Field Using any Locator of your choice 
				
				driver.findElement(By.name("description")).sendKeys("Week 2 Day 1 Assignments-1");
				
				//Enter your email in the E-mail address Field using the locator of your choice
				
				driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("xxyyzz+0101@gmail.com");
				
				//Select State/Province as NewYork Using Visible Text
				
				WebElement stateDrpDwn = driver.findElement(By.name("generalStateProvinceGeoId"));
				Select drpDwn = new Select(stateDrpDwn);
				drpDwn.selectByVisibleText("New York");
				
				//Click on Create Button
				
				driver.findElement(By.className("smallSubmit")).click();
				
				//Click on edit button
				
				driver.findElement(By.linkText("Edit")).click();
				
                //Clear the Description Field using .clear()
				
				driver.findElement(By.name("description")).clear();
				
				//Fill ImportantNote Field with Any text
				
				driver.findElement(By.name("importantNote")).sendKeys("Updating important notes field");
				
				//Click on update button 
				
				driver.findElement(By.name("submitButton")).click();
				
				//Get the Title of Resulting Page. refer the video  using driver.getTitle()
				
				System.out.println(driver.getTitle());
				
				driver.close();
	}

}
