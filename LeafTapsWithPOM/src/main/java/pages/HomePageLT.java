package pages;

import org.openqa.selenium.By;
import base.BaseClassLT;

public class HomePageLT extends BaseClassLT{
	
		public MyHomePageLT clickCrmsfa() {
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePageLT();
	}

}
