package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClassPOM;

public class DuplicateLeadPage extends BaseClassPOM{
	
	public DuplicateLeadPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public ViewLeadPage clickCreateLead() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
