package stepDefinitions;

import org.openqa.selenium.By;

import io.cucumber.java.en.*;

public class DeleteLeadCC extends BaseClassCC{
	
	@When("Enter the first name as {string}")
	public void enterTheFirstNameAs(String fName) {
		
	  driver.findElement(By.xpath("(//div/input[@name='firstName'])[3]")).sendKeys(fName);
	}
	
	@When("Enter the lead id")
	public void enterTheLeadId() {
		driver.findElement(By.xpath("//div/input[@name='id']")).sendKeys(leadId);
	    
	}
	
	@Then("Verify the lead is deleted")
	public void verifyTheLeadIsDeleted() {
		boolean deleteLeadStatus = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		
		sa.assertTrue(deleteLeadStatus);
		sa.assertAll();

	}

}
