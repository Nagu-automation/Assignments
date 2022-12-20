package week6.day1.assign3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateIncident extends BaseClass {

	@Test(alwaysRun = true, priority = 1)
	public void runCreateIncident() throws InterruptedException {

		// Enter Incident in filter navigator and press enter
		Thread.sleep(60000);
		wait.until(ExpectedConditions.visibilityOf(
				shadowRoot.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']")));
		WebElement allLink = shadowRoot
				.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']");
		allLink.click();
		shadowRoot.findElementByXPath("//input[@id='filter']").sendKeys("Incident");

		// Click on Create new option and fill the mandatory fields
		shadowRoot.findElementByXPath("//span[text()='Create New']").click();
		Thread.sleep(5000);
		WebElement iFrameEle = shadowRoot.findElementByXPath("//iframe[@id='gsft_main']");
		wait.until(ExpectedConditions.visibilityOf(iFrameEle));
		driver.switchTo().frame(iFrameEle);
		String defaultIncidentNo = shadowRoot.findElementByXPath("//input[@id='incident.number']")
				.getAttribute("value");
		shadowRoot.findElementByXPath("//input[@id='sys_display.incident.caller_id']").sendKeys("admin", Keys.ENTER);
		shadowRoot.findElementByXPath("//input[@id='incident.short_description']").sendKeys("Creating a new incident");
		shadowRoot.findElementByXPath("//div[@class='form_action_button_container']/button[text()='Submit']").click();

		// Verify the newly created incident ( copy the incident number and paste it in
		// search field and enter then verify the instance number created or not)
		shadowRoot.findElementByXPath("//div[@class='input-group']/input").sendKeys(defaultIncidentNo, Keys.ENTER);
		String searchedIncNo = shadowRoot.findElementByXPath("//table/tbody/tr/td[3]/a").getText();

		if (searchedIncNo.equals(defaultIncidentNo)) {
			incidentNo = searchedIncNo;
			System.out.println("The incident # '" + searchedIncNo + "' is created successfully");
		} else {
			System.out.println("The incident # '" + searchedIncNo + "' is not created");
		}

		driver.switchTo().defaultContent();
	}

}
