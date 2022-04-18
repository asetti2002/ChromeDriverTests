package tests;

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
 * @author Om Shukla
 * Date: 3/23/2022
 */

public class LoginTests {

    static WebDriver driver;
    static final String pathChromeDriver="/Users/akashsetti/Desktop/chromedriver";
    static final String pathLoginPage = "http://localhost:3000/";

    String emailAddress = "Email";
    String password = "pwd";
    String btnValidate = "sb";

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
        System.out.println("Starting window");
        driver.findElement(By.xpath("//input[@id='" + emailAddress + "']")).sendKeys("admin@test.com");
        driver.findElement(By.xpath("//input[@id='" + password + "']")).sendKeys("password");

        Thread.sleep(1000);
        System.out.println("After Sleep");
        driver.findElement(By.id(btnValidate)).submit();
        System.out.println("Button clicked");
        Thread.sleep(2000);
    }
}