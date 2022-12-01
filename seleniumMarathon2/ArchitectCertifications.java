package seleniumMarathon2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	String username = "hari.radhakrishnan@qeagle.com";
	String password = "Testleaf$321";

	public static void main(String[] args) {

		ArchitectCertifications arcCert = new ArchitectCertifications();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);

		// 1. Launch Salesforce application https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Shadow shadowDom = new Shadow(driver);
		shadowDom.setImplicitWait(10);

		// 2. Login with Provided Credentials
		driver.findElement(By.id("username")).sendKeys(arcCert.username);
		driver.findElement(By.id("password")).sendKeys(arcCert.password);
		driver.findElement(By.id("Login")).click();

		// 3. Click on Learn More link in Mobile Publisher and click Confirm and Click
		// Learning and Mouse hover on Learning On Trailhead
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandle.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		shadowDom.findElementByXPath("//span[text()='Learning']").click();

		WebElement learningOnTrailhead = shadowDom.findElementByXPath("//span[text()='Learning on Trailhead']");
		builder.moveToElement(learningOnTrailhead).perform();

		// 4. Select SalesForce Certification
		shadowDom.findElementByXPath("//h4/a[text()='Salesforce Certification']").click();

		// 5. Choose Your Role as Salesforce Architect and verify the URL
		driver.findElement(By.xpath("//div[text()='Architect' and text()='Salesforce']")).click();

		// 6. Get the Text(Summary) of Salesforce Architect
		String para1 = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following-sibling::div"))
				.getText();
		System.out.println(para1);

		// 7. Get the List of Salesforce Architect Certifications Available
		System.out.println("List of Sales Force Architect Applications:");
		List<WebElement> listsofSalesforceArch = driver
				.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		for (WebElement listofSalesForceArch : listsofSalesforceArch) {
			System.out.println(listofSalesForceArch.getText());
		}

		// 8. Click on Application Architect
		listsofSalesforceArch.get(0).click();

		// 9.Get the List of Certifications available
		System.out.println("List of Architect Applications:");
		List<WebElement> listofCerts = driver.findElements(By.xpath(
				"//div[text()='Earn your Prerequisites']/following-sibling::div//div[@class='credentials-card_title']/a"));
		for (WebElement listofCert : listofCerts) {
			System.out.println(listofCert.getText());

		}
	}

}
