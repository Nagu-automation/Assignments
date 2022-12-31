package testcase;

import org.testng.annotations.Test;

import base.BaseClassLT;
import pages.LoginPageLT;

public class TC003_DuplicateLeadLT extends BaseClassLT{
	
	@Test(priority = 3)
	public void runDuplicateLeadLT() {
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
			.clickDuplicate()
			.clickCreateLead();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
