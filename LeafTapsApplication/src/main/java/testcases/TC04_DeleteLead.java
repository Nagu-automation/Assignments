package testcases;

import org.testng.annotations.Test;

import base.BaseClassPOM;
import pages.LoginPage;

public class TC04_DeleteLead extends BaseClassPOM{
	
	@Test(priority = 3)
	public void runDeleteLead() throws InterruptedException {
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
		.clickDelete();
	}

}
