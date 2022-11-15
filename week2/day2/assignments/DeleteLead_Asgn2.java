package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead_Asgn2 {

	public static void main(String[] args) throws InterruptedException {
//		http://leaftaps.com/opentaps/control/main
		 
//		Delete Lead:
//		1	Launch the browser
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
//		2	Enter the username
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
				
//		3	Enter the password
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
//		4	Click Login
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		5	Click crm/sfa link
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
//		6	Click Leads link
		
		driver.findElement(By.linkText("Leads")).click();
		
//		7	Click Find leads
		
		driver.findElement(By.linkText("Find Leads")).click();
		
//		8	Click on Phone
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
//		9	Enter phone number
		
		WebElement phoneCountryCode = driver.findElement(By.name("phoneCountryCode"));
		phoneCountryCode.clear();
		phoneCountryCode.sendKeys("91");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("878");
		driver.findElement(By.name("phoneNumber")).sendKeys("9402088");
		
//		10	Click find leads button
		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(2000);
		
//		11	Capture lead ID of First Resulting lead
		
		String partyID = driver.findElement(By.xpath("//td[contains(@class,'x-grid3-td-partyId')]/div[contains(@class,'x-grid3-col-partyId')]/a[@class='linktext']")).getText();
		
//		12	Click First Resulting lead
		
		driver.findElement(By.xpath("//td[contains(@class,'x-grid3-td-partyId')]/div[contains(@class,'x-grid3-col-partyId')]/a[@class='linktext']")).click();
		
//		13	Click Delete
		
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
//		14	Click Find leads
		
		driver.findElement(By.linkText("Find Leads")).click();
		
//		15	Enter captured lead ID
		
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(partyID);
		
//		16	Click find leads button
		
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		
		String searchMsg = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		
		if(searchMsg.equalsIgnoreCase("No records to display"))
		{
			System.out.println("The lead "+ partyID + " is successfully deleted");
		}else
		{
			System.out.println("The lead "+ partyID + " is not deleted");
		}
		
//		18	Close the browser (Do not log out)
		
		driver.close();

	}

}
