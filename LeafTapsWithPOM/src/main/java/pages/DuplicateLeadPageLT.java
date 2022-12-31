package pages;

import org.openqa.selenium.By;
import base.BaseClassLT;

public class DuplicateLeadPageLT extends BaseClassLT {

	public ViewLeadPageLT clickCreateLead() {
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLeadPageLT();
	}

}
