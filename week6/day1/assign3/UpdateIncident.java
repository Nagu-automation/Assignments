package week6.day1.assign3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass {

	@Test(priority = 2, dependsOnMethods = "week6.day1.assign3.CreateIncident.runCreateIncident")
	public void runUpdateIncident() throws InterruptedException {

		// Enter Incident in filter navigator and press enter
		Thread.sleep(60000);
		wait.until(ExpectedConditions.visibilityOf(
				shadowRoot.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']")));
		WebElement allLink = shadowRoot
				.findElementByXPath("//div[contains(@class,'polaris-header-menu')]/div[text()='All']");
		allLink.click();
		shadowRoot.findElementByXPath("//input[@id='filter']").sendKeys("Incidents", Keys.ENTER);

		// Search for the existing incident and click on the incident
		Thread.sleep(5000);
		WebElement iFrameEle = shadowRoot.findElementByXPath("//iframe[@id='gsft_main']");
		wait.until(ExpectedConditions.visibilityOf(iFrameEle));
		driver.switchTo().frame(iFrameEle);
		WebElement numberHeader = shadowRoot.findElementByXPath("//a[contains(text(),'Number')]");
		wait.until(ExpectedConditions.visibilityOf(numberHeader));
		numberHeader.click();
		WebElement inciEle = shadowRoot.findElementByXPath("(//table/tbody/tr/td[3]/a)[1]");
		wait.until(ExpectedConditions.visibilityOf(inciEle));
		inciEle.click();

		// Update the incidents with Urgency as High and State as In Progress
		WebElement urgencyEle = shadowRoot.findElementByXPath("//select[@id='incident.urgency']");
		Select urgencySel = new Select(urgencyEle);
		urgencySel.selectByValue("1");

		WebElement stateEle = shadowRoot.findElementByXPath("//select[@id='incident.state']");
		Select stateSel = new Select(stateEle);
		stateSel.selectByValue("2");

		shadowRoot.findElementByXPath("//button[@id='sysverb_update_bottom']").click();

		// Verify the priority and state
		shadowRoot.findElementByXPath("//table/tbody/tr/td[3]/a[contains(text()='" + incidentNo + "')]").click();
		String urgencySelValue = shadowRoot
				.findElementByXPath("//select[@id='incident.urgency']/option[@selected='SELECTED']").getText();
		String urgencyValue = urgencySelValue.replaceAll("[^A-Za-z]", " ").trim();
		if (urgencyValue.equalsIgnoreCase("High")) {
			System.out.println("Urgency is selected as expected");

		} else {
			System.out.println("Urgency is not selected as expected");
		}

		String stateSelValue = shadowRoot
				.findElementByXPath("//select[@id='incident.state']/option[@selected='SELECTED']").getText();
		if (stateSelValue.equalsIgnoreCase("In Progress")) {
			System.out.println("State is selected as expected");
		} else {
			System.out.println("State is not selected as expected");
		}

		driver.switchTo().defaultContent();
	}

}
