package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClassPOM;

public class FindLeadsPage extends BaseClassPOM {

	public FindLeadsPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public FindLeadsPage clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}

	public FindLeadsPage enterPhoneAreaCode() {
		WebElement areaCode = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		areaCode.clear();
		areaCode.sendKeys("99");
		return this;
	}

	public FindLeadsPage clickFindLeadsBtn() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}

	public ViewLeadPage clickLeadId() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPage(driver);
	}

}
