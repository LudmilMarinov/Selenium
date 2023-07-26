package driverExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class FirefoxHomePageStartUpExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\webdrivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.homepage", "http://pragmatic.bg/automation/example4.html");
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://abv.bg");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExamples() {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("pragmabg");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("parola");
        driver.findElement(By.id("loginBut")).click();
    }


}
