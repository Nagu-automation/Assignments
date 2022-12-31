package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BaseClassLT;

public class EditLeadPageLT extends BaseClassLT {

	public EditLeadPageLT editCompanyName(String cName) {
		WebElement cNameFindElement = getDriver().findElement(By.id("updateLeadForm_companyName"));
		cNameFindElement.clear();
		cNameFindElement.sendKeys(cName);
		return this;
	}

	public EditLeadPageLT editFirstName(String fName) {
		WebElement fNameFindElement = getDriver().findElement(By.id("updateLeadForm_firstName"));
		fNameFindElement.clear();
		fNameFindElement.sendKeys(fName);
		return this;
	}

	public EditLeadPageLT editLastName(String lName) {
		WebElement lNamefindElement = getDriver().findElement(By.id("updateLeadForm_lastName"));
		lNamefindElement.clear();
		lNamefindElement.sendKeys(lName);
		return this;
	}

	public ViewLeadPageLT clickUpdate() {
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLeadPageLT();
	}

}
