package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClassPOM;

public class HomePage extends BaseClassPOM{
	
	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public MyHomePage clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}

}
