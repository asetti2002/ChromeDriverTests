package task1;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Akash Setti
 */

public class tests {

	static WebDriver driver;
	static final String pathChromeDriver = "/Users/akashsetti/Desktop/chromedriver";
	static final String pathLoginPage = "http://localhost:3000/";

//	String firstName = "txtFirstName";
//	String lastName = "txtLastName";
	String emailAddress = "Email";
	String password = "pwd";
//	String phoneNumber = "txtPhone";
//	String address = "txtAddress";
//	String gender = "selectGender";
//	String state = "selectState";
	String btnValidate = "sb";
//	String validationResult = "FinalResult";

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

	@Test
	public void loginSuccessTest() throws InterruptedException {
		driver.get(pathLoginPage);
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@id='" + firstName + "']")).sendKeys("Akash");
//		driver.findElement(By.xpath("//input[@id='" + lastName + "']")).sendKeys("Setti");

//		Select user = new Select(driver.findElement(By.name(gender)));
//		user.selectByVisibleText("Male");
//		user = new Select(driver.findElement(By.name(state)));
//		user.selectByVisibleText("Iowa");

		driver.findElement(By.xpath("//input[@id='" + emailAddress + "']")).sendKeys("admin@test.com");
		driver.findElement(By.xpath("//input[@id='" + password + "']")).sendKeys("password");
//		driver.findElement(By.xpath("//input[@id='" + phoneNumber + "']")).sendKeys("1234567890");
//		driver.findElement(By.xpath("//input[@id='" + address + "']")).sendKeys("Ames,IA");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='" + btnValidate + "']")).click();
//		String strMessage = driver.findElement(By.xpath("//label[@id='" + validationResult + "']")).getText();
//		assertEquals("Failed test case", strMessage, "OK!");
	}

	@Test
	public void loginFailedTest() throws InterruptedException {
		driver.get(pathLoginPage);
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@id='" + firstName + "']")).sendKeys("Om");
//		driver.findElement(By.xpath("//input[@id='" + lastName + "']")).sendKeys("Shukla");

//		Select user = new Select(driver.findElement(By.name(gender)));
//		user.selectByVisibleText("Male");
//		user = new Select(driver.findElement(By.name(state)));
//		user.selectByVisibleText("Iowa");

		driver.findElement(By.xpath("//input[@id='" + emailAddress + "']")).sendKeys("admin@test.com");
		driver.findElement(By.xpath("//input[@id='" + password + "']")).sendKeys("pass");
//		driver.findElement(By.xpath("//input[@id='" + phoneNumber + "']")).sendKeys("abcde");
//		driver.findElement(By.xpath("//input[@id='" + address + "']")).sendKeys("Ames,IA");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='" + btnValidate + "']")).click();
//		String strMessage = driver.findElement(By.xpath("//label[@id='" + validationResult + "']")).getText();
//		assertEquals("Failed test case", strMessage, "Error");
	}
}
