package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClassLT;
import pages.LoginPageLT;

public class TC001_CreateLeadLT extends BaseClassLT{
	
	@BeforeTest
	public void setFileName() {
		super.fileName = "DataExcel";
		super.sheetName = "CreateLeadDetails";
	}
	
	@Test(dataProvider = "LeafTapData", alwaysRun = true, priority = 1)
	public void runCreateLeadLT(String cName, String fName, String lName) {
		new LoginPageLT()
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
