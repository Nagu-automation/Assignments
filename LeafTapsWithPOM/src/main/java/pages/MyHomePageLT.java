package pages;

import org.openqa.selenium.By;
import base.BaseClassLT;

public class MyHomePageLT extends BaseClassLT {

	@SuppressWarnings("finally")
	public MyHomePageLT clickLeadsTab() {
		try {
			if (getDriver().findElement(By.xpath("//td/input[@name='USERNAME']")).isDisplayed()) {
				getDriver().findElement(By.xpath("//td/input[@name='USERNAME']"))
						.sendKeys(prop.getProperty("userName"));
				getDriver().findElement(By.xpath("//td/input[@name='PASSWORD']"))
						.sendKeys(prop.getProperty("passWord"));
				getDriver().findElement(By.xpath("//td/input[@class='loginButton']")).click();
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			getDriver().findElement(By.linkText(prop.getProperty("tab_Lead"))).click();
			return this;
		}

	}

	public CreateLeadPageLT clickCreateLeadLink() {
		getDriver().findElement(By.linkText(prop.getProperty("link_Create_Lead"))).click();
		return new CreateLeadPageLT();
	}

	public FindLeadsPageLT clickFindLeadsLink() {
		getDriver().findElement(By.linkText("Find Leads")).click();
		return new FindLeadsPageLT();
	}

}
