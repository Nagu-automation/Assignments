package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClassPOM;

public class MyHomePage extends BaseClassPOM {

	public MyHomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("finally")
	public MyHomePage clickLeadsTab() {
		try {
		if(driver.findElement(By.xpath("//td/input[@name='USERNAME']")).isDisplayed()) 
		{
			driver.findElement(By.xpath("//td/input[@name='USERNAME']")).sendKeys("DemoCSR");
			driver.findElement(By.xpath("//td/input[@name='PASSWORD']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//td/input[@class='loginButton']")).click();
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			driver.findElement(By.linkText("Leads")).click();
			return this;
		}
		
	}

	public CreateLeadPage clickCreateLeadLink() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage(driver);
	}

	public FindLeadsPage clickFindLeadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadsPage(driver);
	}

}
