package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClassLT;

public class FindLeadsPageLT extends BaseClassLT {

	public FindLeadsPageLT clickPhoneTab() {
		getDriver().findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}

	public FindLeadsPageLT enterPhoneAreaCode() {
		WebElement areaCode = getDriver().findElement(By.xpath("//input[@name='phoneNumber']"));
		areaCode.clear();
		areaCode.sendKeys("99");
		return this;
	}

	public FindLeadsPageLT clickFindLeadsBtn() {
		getDriver().findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}

	public ViewLeadPageLT clickLeadId() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(
				getDriver().findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))));
		getDriver().findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPageLT();
	}

}
