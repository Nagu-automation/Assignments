package pages;

import org.openqa.selenium.By;
import base.BaseClassLT;

public class CreateLeadPageLT extends BaseClassLT {

	public CreateLeadPageLT enterCompanyName(String cName) {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		return this;
	}

	public CreateLeadPageLT enterFirstName(String fName) {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		return this;
	}

	public CreateLeadPageLT enterLastName(String lName) {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		return this;
	}

	public ViewLeadPageLT clickCreateLeadButton() {
		getDriver().findElement(By.className("smallSubmit")).click();
		return new ViewLeadPageLT();
	}

}
