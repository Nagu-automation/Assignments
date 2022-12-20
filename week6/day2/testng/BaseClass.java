package week6.day2.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	public ChromeDriver driver;
	public String fileName;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void beforeMethod(String url, String uName, String pwd) {
		
		// Launch URL "http://leaftaps.com/opentaps/control/login"

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
	
	@DataProvider(name="data")
	public String[][] setData() throws IOException{
		//String[][] data = new String[2][3];
		
		/*
		 * data[0][0] = "Company1"; data[0][1] = "fName1"; data[0][2] = "lName1";
		 * 
		 * data[1][0] = "Company2"; data[1][1] = "fName2"; data[1][2] = "lName2";
		 */
		
		return ReadDataFromExcel.readData(fileName);
		
	}

}
