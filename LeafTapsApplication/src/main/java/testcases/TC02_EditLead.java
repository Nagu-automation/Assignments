package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClassPOM;
import pages.LoginPage;

public class TC02_EditLead extends BaseClassPOM{
	
	@BeforeClass
	public void setFilename() {
		fileName = "Data";
		sheetName = "EditLeadDetails";
	}
	
	@Test(dataProvider = "featchData", dependsOnMethods = "testcases.TC01_CreateLead.runCreateLead", priority = 4)
	public void runEditLead(String cName, String fName, String lName) throws InterruptedException {
		new LoginPage(driver)
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCrmsfa()
		.clickLeadsTab()
		.clickFindLeadsLink()
		.clickPhoneTab()
		.enterPhoneAreaCode()
		.clickLeadId()
		.clickEdit()
		.editCompanyName(cName)
		.editFirstName(fName)
		.editLastName(lName)
		.clickUpdate()
		.verifyCompanyName();
	
	}

}
