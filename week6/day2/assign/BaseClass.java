package week6.day2.assign;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	public ChromeDriver driver;

	@Parameters({ "url", "uName", "pWord" })
	@BeforeMethod(alwaysRun = true)
	public void preCondition(@Optional("http://leaftaps.com/opentaps/control/login") String url,@Optional("DemoCSR") String uName,@Optional("crmsfa") String pWord) {
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@AfterMethod(alwaysRun = true)
	public void postCondition() {
		driver.close();
	}

	@DataProvider(name = "CreateLeadData")
	public String[][] leafTapsData_create() throws IOException {

		XSSFWorkbook LeafTapsDataWb = new XSSFWorkbook("./data/LeafTapsApplication_TestNG_Data.xlsx");
		XSSFSheet createLeadDataSheet = LeafTapsDataWb.getSheet("CreateLeadData");
		int lastRowNum = createLeadDataSheet.getLastRowNum();
		int lastColumnNum = createLeadDataSheet.getRow(0).getLastCellNum();

		String[][] data = new String[lastRowNum][lastColumnNum];

		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastColumnNum; j++) {

				XSSFCell cell = createLeadDataSheet.getRow(i).getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			}

		}

		LeafTapsDataWb.close();

		return data;
	}
	
	@DataProvider(name = "MergeLeadData")
	public String[][] leafTapsData_merge() throws IOException {

		XSSFWorkbook LeafTapsDataWb = new XSSFWorkbook("./data/LeafTapsApplication_TestNG_Data.xlsx");
		XSSFSheet mergeLeadDataSheet = LeafTapsDataWb.getSheet("CreateLeadData");
		int lastRowNum = mergeLeadDataSheet.getLastRowNum();
		int lastColumnNum = mergeLeadDataSheet.getRow(0).getLastCellNum();

		String[][] data = new String[lastRowNum][lastColumnNum];

		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastColumnNum; j++) {

				XSSFCell cell = mergeLeadDataSheet.getRow(i).getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			}

		}

		LeafTapsDataWb.close();

		return data;
	}

}
