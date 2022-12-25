package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClassPOM;

public class ViewLeadPage extends BaseClassPOM {

	public ViewLeadPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public ViewLeadPage verifyCompanyName() {
		String cName = driver.findElement(By.xpath("//span[text()='Company Name']")).getText();
		if (cName.contains("CTS")) {
			System.out.println("Company name is updated correctly");
		}
		return this;
	}

	public EditLeadPage clickEdit() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);
	}
	
	public DuplicateLeadPage clickDuplicate() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);
	}
	
	public ViewLeadPage clickDelete() {
		driver.findElement(By.linkText("Delete")).click();
		return this;
	}

}
