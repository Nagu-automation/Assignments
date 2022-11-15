package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead_Asgn2 {

	public static void main(String[] args) throws InterruptedException {
		//http://leaftaps.com/opentaps/control/main
		 
		//Launch the browser
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//Enter the username
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		//Enter the password
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click crm/sfa link
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Leads link
		
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click on Email
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//Enter Email
		
		driver.findElement(By.name("emailAddress")).sendKeys("priyadharshini.ceg@gmail.com");
		
		//Click find leads button
		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		
		//Capture name of First Resulting lead
		
		String firstName = driver.findElement(By.xpath("//td[contains(@class,'x-grid3-td-firstName')]/div[contains(@class,'x-grid3-col-firstName')]/a[@class='linktext']")).getText();
		Thread.sleep(2000);
		
		//Click First Resulting lead
		
		driver.findElement(By.xpath("//td[contains(@class,'x-grid3-td-partyId')]/div[contains(@class,'x-grid3-col-partyId')]/a[@class='linktext']")).click();
		
		//Click Duplicate Lead
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Verify the title as 'Duplicate Lead'
		
		String title = driver.getTitle();
		
		if(title.contains("Duplicate"))
		{
			System.out.println("Navigated to Duplicate Lead Page Successfully");
		}else
		{
			System.out.println("It's not Navigated to Duplicate Lead Page");
		}
		
		//Click Create Lead
		
		driver.findElement(By.name("submitButton")).click();
		
		//Confirm the duplicated lead name is same as captured name
		
		String firstName_sp = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		if(firstName.equalsIgnoreCase(firstName_sp))
		{
			System.out.println("The lead name is matching");
		}else
		{
			System.out.println("The lead name is not matching");
		}
		
		//Close the browser (Do not log out)
		
		driver.close();
		
		
	}

}
