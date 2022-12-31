package pages;

import org.openqa.selenium.By;
import base.BaseClassLT;

public class ViewLeadPageLT extends BaseClassLT {

	public ViewLeadPageLT verifyCompanyName() {
		String cName = getDriver().findElement(By.xpath("//span[text()='Company Name']")).getText();
		if (cName.contains("CTS")) {
			System.out.println("Company name is updated correctly");
		}
		return this;
	}

	public EditLeadPageLT clickEdit() {
		getDriver().findElement(By.linkText("Edit")).click();
		return new EditLeadPageLT();
	}

	public DuplicateLeadPageLT clickDuplicate() {
		getDriver().findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPageLT();
	}

	public ViewLeadPageLT clickDelete() {
		getDriver().findElement(By.linkText("Delete")).click();
		return this;
	}

}
