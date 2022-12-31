package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadData;

public class BaseClassLT extends ReadData{

	public static final ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();
	public RemoteWebDriver driver;
	public ChromeOptions option;
	public static WebDriverWait wait;
	public static Properties prop;
	public static FileInputStream fis;
	public String fileName;
	public String sheetName;
	public static String userName;
	public static String passWord;

	public void setDriver(RemoteWebDriver driver) {
		tlDriver.set(driver);
	}

	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		setDriver(new ChromeDriver(option));
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		prop = new Properties();

		try {
			fis = new FileInputStream("./src/main/resources/utils/configLT.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		userName = prop.getProperty("userName");
		passWord = prop.getProperty("passWord");
		
		getDriver().get(prop.getProperty("url"));
	}

	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	
	@DataProvider(name="LeafTapData", parallel = true)
	public String[][] readData() {
		return readFromExcel(fileName, sheetName);
	}

}
