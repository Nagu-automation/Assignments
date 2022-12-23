package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.*;

public class EditLeadCC extends BaseClassCC {

	public String cNameUpdated;
	
	@Then("Verify Find by section is displayed")
	public void verifyFindBySectionIsDisplayed() {
		boolean findByEle = driver.findElement(By.xpath("//span[text()='Find by']")).isDisplayed();
		sa.assertEquals(findByEle, true);
		sa.assertAll();
	}

	@When("Click on phone tab")
	public void clickOnPhoneTab() {
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

	}

	@When("Enter first two digits of phone number as {string}")
	public void enterFirstTwoDigitsOfPhoneNumber(String areaCode) {
		
		WebElement phoneNumberEle = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
		phoneNumberEle.clear();
		phoneNumberEle.sendKeys(areaCode);

	}

	@When("Click on Find Leads button")
	public void clickOnFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	}

	@Then("Verify Lead List is displayed")
	public void verifyLeadListIsDisplayed() {
		boolean leadListEle = driver.findElement(By.xpath("//span[text()='Lead List']")).isDisplayed();
		sa.assertEquals(leadListEle, true);
		sa.assertAll();
		
	}

	@When("Click on first instance of the list")
	public void clickOnFirstInstanceOfTheList() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]"))));
		WebElement firstSearchResult = driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]"));
		leadId = firstSearchResult.getText();
		firstSearchResult.click();
	}

	@Then("Verify {string} page is displayed")
	public void verifyViewLeadPageIsDisplayed(String pageName) {
		boolean viewLeadPageEle = driver.findElement(By.xpath("//div[text()='"+pageName+"']")).isDisplayed();
		sa.assertEquals(viewLeadPageEle, true);
		sa.assertAll();
		
		if(pageName.equalsIgnoreCase("View Page"))
		{
		WebElement cNameEle = driver.findElement(By.xpath("(//table/tbody/tr/td[2]/span)[1]"));
		leadIdExp = cNameEle.getText().replaceAll("[^0-9]", "");
		
		sa.assertEquals(leadIdExp, leadId);
		sa.assertAll();
		}

	}

	@When("Updating the fields company name as {string} first Name as {string} last name as {string} and click on update button")
	public void updatingTheFieldsAndClickOnUpdateButton(String cName, String fName, String lName) {
		cNameUpdated = cName;
		WebElement cNameEle = driver.findElement(By.id("updateLeadForm_companyName"));
		cNameEle.clear();
		cNameEle.sendKeys(cName);
		
		WebElement fNameEle = driver.findElement(By.id("updateLeadForm_firstName"));
		fNameEle.clear();
		fNameEle.sendKeys(fName);
		
		WebElement lNameEle = driver.findElement(By.id("updateLeadForm_lastName"));
		lNameEle.clear();
		lNameEle.sendKeys(lName);
		
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
	}

	@Then("Verify the changes are updated")
	public void verifyTheChangesAreUpdated() {
		
		boolean cNameUpdValueStatus = driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(cNameUpdated);
		
		sa.assertEquals(cNameUpdValueStatus, true);
		sa.assertAll();

	}

}
