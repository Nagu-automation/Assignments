package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClassPOM;
import pages.LoginPage;

public class TC01_CreateLead extends BaseClassPOM{
	
	@BeforeClass
	public void setFilename() {
		fileName = "Data";
		sheetName = "CreateLeadDetails";
	}
	
	@Test(dataProvider = "featchData", alwaysRun = true, priority = 1)
	public void runCreateLead(String cName, String fName, String lName) {
		
		new LoginPage(driver)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCrmsfa()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.enterCompanyName(cName)
		.enterFirstName(fName)
		.enterLastName(lName)
		.clickCreateLeadButton()
		.verifyCompanyName();
		
	}

}
