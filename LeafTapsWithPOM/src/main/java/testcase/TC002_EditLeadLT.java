package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClassLT;
import pages.LoginPageLT;

public class TC002_EditLeadLT extends BaseClassLT{
	
	@BeforeTest
	public void setFileName() {
		super.fileName = "DataExcel";
		super.sheetName = "EditLeadDetails";
	}
	
	@Test(dataProvider = "LeafTapData", priority = 4)
	public void runEditLead(String cName, String fName, String lName) {
		try {
			new LoginPageLT()
			.enterUsername()
			.enterPassword()
			.clickLogin()
			.clickCrmsfa()
			.clickLeadsTab()
			.clickFindLeadsLink()
			.clickPhoneTab()
			.enterPhoneAreaCode()
			.clickFindLeadsBtn()
			.clickLeadId()
			.clickEdit()
			.editCompanyName(cName)
			.editFirstName(fName)
			.editLastName(lName)
			.clickUpdate()
			.verifyCompanyName();
		} catch (InterruptedException e) {
			
			e.getMessage();
		}
	}

}
