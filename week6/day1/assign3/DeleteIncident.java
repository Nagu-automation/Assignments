package week6.day1.assign3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

public class DeleteIncident extends BaseClass {

	@Test
	public void runDeleteIncident() throws InterruptedException {
		// Enter Incident in filter navigator and press enter"
		Thread.sleep(60000);
		wait.until(ExpectedConditions.visibilityOf(
				shadowRoot.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']")));
		WebElement allLink = shadowRoot
				.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']");
		allLink.click();
		WebElement filterEle = shadowRoot.findElementByXPath("//input[@id='filter']");
		filterEle.sendKeys("Incidents");
		WebElement incEle = shadowRoot.findElementByXPath("//span[@class='menu-item-row']//mark[text()='Incident']");
		wait.until(ExpectedConditions.visibilityOf(incEle));
		incEle.click();

		// Search for the existing incident and navigate into the incident
		WebElement numberHeader = shadowRoot.findElementByXPath("//a[contains(text(),'Number')]");
		wait.until(ExpectedConditions.visibilityOf(numberHeader));
		numberHeader.click();
		WebElement inciEle = shadowRoot.findElementByXPath("(//table/tbody/tr/td[3]/a)[1]");
		String incNum = inciEle.getText();
		wait.until(ExpectedConditions.visibilityOf(inciEle));
		inciEle.click();

		// Delete the incident
		shadowRoot.findElementByXPath("//span[@class='navbar_ui_actions']/button[contains(text(),'Delete')]").click();

		// Verify the deleted incident
		boolean incDisStatus = shadowRoot
				.findElementByXPath("//table/tbody/tr/td[3]/a[contains(text='" + incNum + "')]").isDisplayed();
		if (incDisStatus) {
			System.out.println("The incident is not deleted");
		} else {
			System.out.println("The incident is deleted successfully");
		}
	}

}
