package testcases;

import org.testng.annotations.Test;

import base.BaseClassPOM;
import pages.LoginPage;

public class TC03_DuplicateLead extends BaseClassPOM{
	
	@Test(priority = 2)
	public void runDuplicateLead() throws InterruptedException {
		
		new LoginPage(driver)
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
		.clickCreateLead()
		.verifyCompanyName();
		
	}

}
