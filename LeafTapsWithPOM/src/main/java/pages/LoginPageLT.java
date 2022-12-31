package pages;

import org.openqa.selenium.By;

import base.BaseClassLT;

public class LoginPageLT extends BaseClassLT{
	
	public LoginPageLT enterUsername() {
		getDriver().findElement(By.id("username")).sendKeys(userName);
		return this;
	}

	public LoginPageLT enterPassword() {
		getDriver().findElement(By.id("password")).sendKeys(passWord);
		return this;
	}

	public HomePageLT clickLogin() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new HomePageLT();
	}

}
