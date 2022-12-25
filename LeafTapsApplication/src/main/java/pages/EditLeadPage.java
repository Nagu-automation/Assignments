package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClassPOM;

public class EditLeadPage extends BaseClassPOM {
	
	public EditLeadPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public EditLeadPage editCompanyName(String cName) {
		WebElement cNameFindElement = driver.findElement(By.id("updateLeadForm_companyName"));
		cNameFindElement.clear();
		cNameFindElement.sendKeys(cName);
		return this;
	}

	public EditLeadPage editFirstName(String fName) {
		WebElement fNameFindElement = driver.findElement(By.id("updateLeadForm_firstName"));
		fNameFindElement.clear();
		fNameFindElement.sendKeys(fName);
		return this;
	}

	public EditLeadPage editLastName(String lName) {
		WebElement lNamefindElement = driver.findElement(By.id("updateLeadForm_lastName"));
		lNamefindElement.clear();
		lNamefindElement.sendKeys(lName);
		return this;
	}

	public ViewLeadPage clickUpdate() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
