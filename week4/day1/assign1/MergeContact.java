package week4.day1.assign1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		  //Pseudo Code
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new  ChromeDriver();
				  
		  //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  
		  //2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");	  
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		  //3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		  
		  //4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		  
		  //5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		  	
		  //6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		  
		  //7. Click on Widget of From Contact (Note: when i click on the field, no options were listed by default, So keyed a letter)
		driver.findElement(By.id("ComboBox_partyIdFrom")).sendKeys("a");
		  
		  //8. Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@id='widget_ComboBox_partyIdFrom_dropdown']//div[text()='Previous choices']/following-sibling::div")).click();
		  
		  //9. Click on Widget of To Contact (Note: when i click on the field, no options were listed by default, So keyed a letter)
		driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys("p");
		  
		  //10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@id='widget_ComboBox_partyIdTo_dropdown']/div[@class='dijitMenu']/div)[3]")).click();
		  
		  //11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		  
		  //12. Accept the Alert
		driver.switchTo().alert().accept();
		  
		  //13. Verify the title of the page
		
		String title = driver.getTitle();
		
		if(title.contains("View Contact"))
		{
			System.out.println("Merge happened successfully");
		}else {
			System.out.println("Merge not happened successfully");
		}
		 
	}

}
