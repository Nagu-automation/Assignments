package week6.day1.assign3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

public class AssignIncident extends BaseClass {

	@Test(priority = 2, dependsOnMethods = "week6.day1.assign3.CreateIncident.runCreateIncident")
	public void runAssignIncident() throws InterruptedException {
		// Enter Incident in filter navigator and press enter
		Thread.sleep(60000);
		wait.until(ExpectedConditions.visibilityOf(
				shadowRoot.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']")));
		WebElement allLink = shadowRoot
				.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']");
		allLink.click();
		shadowRoot.findElementByXPath("//input[@id='filter']").sendKeys("Incident", Keys.ENTER);

		// click on open and Search for the existing incident and click on the incident
		WebElement numberHeader = shadowRoot.findElementByXPath("//a[contains(text(),'Number')]");
		wait.until(ExpectedConditions.visibilityOf(numberHeader));
		numberHeader.click();
		WebElement inciEle = shadowRoot.findElementByXPath("(//table/tbody/tr/td[3]/a)[1]");
		String incNum = inciEle.getText();
		wait.until(ExpectedConditions.visibilityOf(inciEle));
		inciEle.click();

		// Assign the incident to Software group
		WebElement assignmentGroupEle = shadowRoot
				.findElementByXPath("//input[@id='sys_display.incident.assignment_group']");
		wait.until(ExpectedConditions.visibilityOf(assignmentGroupEle));
		assignmentGroupEle.click();

		// Update the incident with Work Notes
		WebElement workNoteEle = shadowRoot.findElementByXPath("//textarea[@id='activity-stream-textarea']");
		wait.until(ExpectedConditions.visibilityOf(workNoteEle));
		workNoteEle.click();

		shadowRoot.findElementByXPath("//div/button[contains(text(),'Update')]").click();

		// Verify the Assignment group and Assigned for the incident
		wait.until(ExpectedConditions.visibilityOf(inciEle));
		inciEle.click();

		if (assignmentGroupEle.getText().equals("Software")) {
			System.out.println("The incident # " + incNum + " has assigned to group successfully");
		} else {
			System.out.println("The incident # " + incNum + " has not assigned to the group");
		}

	}

}
