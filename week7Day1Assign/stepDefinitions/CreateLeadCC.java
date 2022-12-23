package stepDefinitions;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadCC extends BaseClassCC{
	
	@Given("Click on {string} tab")
	public void clickOnTabs(String tabsName) {
		driver.findElement(By.linkText(tabsName)).click();
	}
	
	@And("Enter {string} as {string}")
	public void enterFieldInputs(String fieldName, String fieldValue) {
		driver.findElement(By.id("createLeadForm_"+fieldName)).sendKeys(fieldValue);
	}
	
	@When("Click on create lead button")
	public void clickOnCreateLeadBtn() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Verify lead is created")
	public void verifyLeadCreation() {
		boolean viewLeadText = driver.findElement(By.xpath("//div[text()='View Lead']")).isDisplayed();
		sa.assertEquals(viewLeadText, true);
		sa.assertAll();
	}

}
