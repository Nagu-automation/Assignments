package testcase;

import org.testng.annotations.Test;

import base.BaseClassLT;
import pages.LoginPageLT;

public class TC004_DeleteLead extends BaseClassLT {

	@Test(priority = 2)
	public void runDeleteLead() {
		try {
			new LoginPageLT().enterUsername().enterPassword().clickLogin().clickCrmsfa().clickLeadsTab()
					.clickFindLeadsLink().clickPhoneTab().enterPhoneAreaCode().clickFindLeadsBtn().clickLeadId()
					.clickDelete();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
