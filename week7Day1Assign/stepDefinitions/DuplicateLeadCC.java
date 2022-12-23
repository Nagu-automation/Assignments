package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

public class DuplicateLeadCC extends BaseClassCC{
	
	public String dupId;
	
	@When("Enter the company name as {string}")
	public void enterTheCompanyNameAs(String cName) {
		driver.findElement(By.xpath("(//div/input[@name='companyName'])[2]")).sendKeys(cName);		
	}
	
	@Then("Verify Duplicate lead is created")
	public void verifyDuplicateLeadIsCreated() {
		WebElement duplicatedEle = driver.findElement(By.xpath("(//table/tbody/tr/td[2]/span)[1]"));
		dupId = duplicatedEle.getText().replaceAll("^[0-9]", "");
		
		sa.assertNotEquals(dupId, leadId);
		sa.assertAll();
		
	}
	

}
